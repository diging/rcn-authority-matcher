package edu.asu.diging.rcn.core.service.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.asu.diging.eaccpf.data.DatasetRepository;
import edu.asu.diging.eaccpf.model.Dataset;
import edu.asu.diging.eaccpf.model.impl.DatasetImpl;
import edu.asu.diging.rcn.core.data.UploadJobRepository;
import edu.asu.diging.rcn.core.exceptions.DatasetNotFoundException;
import edu.asu.diging.rcn.core.exceptions.FileStorageException;
import edu.asu.diging.rcn.core.exceptions.MessageCreationException;
import edu.asu.diging.rcn.core.kafka.IKafkaRequestProducer;
import edu.asu.diging.rcn.core.model.IUploadJob;
import edu.asu.diging.rcn.core.model.JobStatus;
import edu.asu.diging.rcn.core.model.impl.JobPhase;
import edu.asu.diging.rcn.core.model.impl.UploadJob;
import edu.asu.diging.rcn.core.service.IFileStorageManager;
import edu.asu.diging.rcn.core.service.IUploadJobManager;
import edu.asu.diging.rcn.kafka.messages.KafkaTopics;
import edu.asu.diging.rcn.kafka.messages.model.KafkaJobMessage;
import edu.asu.diging.simpleusers.core.model.IUser;

@Service
@Transactional
@PropertySource("classpath:/config.properties")
public class UploadJobManager implements IUploadJobManager {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${_job_page_size}")
    private int jobPageSize;

    @Autowired
    private UploadJobRepository jobRepository;
    
    @Autowired
    private DatasetRepository datasetRepository;

    @Autowired
    private IFileStorageManager fileManager;

    @Autowired
    private IKafkaRequestProducer kafkaProducer;

    /*
     * (non-Javadoc)
     * 
     * @see edu.asu.diging.citesphere.core.service.jobs.impl.IUploadJobManager#
     * findUploadJob(java.lang.String)
     */
    @Override
    public IUploadJob findUploadJob(String id) {
        Optional<UploadJob> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            IUploadJob job = jobOptional.get();
            if (IUploadJob.class.isAssignableFrom(job.getClass())) {
                return (IUploadJob) job;
            }
        }
        return null;
    }

    @Override
    public IUploadJob findUploadJobFullyLoaded(String id) {
        Optional<UploadJob> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            IUploadJob job = jobOptional.get();
            // load phases
            job.getPhases().size();
            return job;
        }
        return null;
    }

    @Override
    public IUploadJob createUploadJob(IUser user, String datasetId, MultipartFile file, byte[] fileBytes) throws DatasetNotFoundException {

        Optional<DatasetImpl> datasetOptional = datasetRepository.findById(datasetId);
        if (!datasetOptional.isPresent()) {
            throw new DatasetNotFoundException("Could not find dataset with id: " + datasetId);
        }
        
        Dataset dataset = datasetOptional.get();
        
        String filename = file.getOriginalFilename();

        UploadJob job = new UploadJob();
        job.setFilename(filename);
        job.setCreatedOn(OffsetDateTime.now());
        job.setUsername(user.getUsername());
        job.setPhases(new ArrayList<>());
        
        String contentType = null;
        try {
            if (fileBytes == null) {
                job.setStatus(JobStatus.FAILURE);
                job.getPhases().add(new JobPhase(JobStatus.FAILURE, "There is not file content."));
            } else {
                job = jobRepository.save(job);
                fileManager.saveFile(user.getUsername(), job.getId(), filename, fileBytes);
                job.setStatus(JobStatus.PREPARED);
                Tika tika = new Tika();
                contentType = tika.detect(fileBytes);
            }
        } catch (FileStorageException e) {
            logger.error("Could not store file.", e);
            job.setStatus(JobStatus.FAILURE);
            job.getPhases().add(new JobPhase(JobStatus.FAILURE, e.getMessage()));
        } finally {
            jobRepository.save(job);
        }

        if (contentType == null) {
            contentType = file.getContentType();
        }

        job.setContentType(contentType);
        job.setFileSize(file.getSize());
        
        
        job.setDatasetId(dataset.getId());
        job = jobRepository.save(job);
        
        try {
            kafkaProducer.sendRequest(new KafkaJobMessage(dataset.getId(), job.getId()), KafkaTopics.UPLOAD_DATASET_TOPIC);
        } catch (MessageCreationException e) {
            logger.error("Could not send Kafka message.", e);
            job.setStatus(JobStatus.FAILURE);
            job.getPhases().add(new JobPhase(JobStatus.FAILURE, e.getMessage()));
            jobRepository.save(job);
        }

        return job;
    }

    @Override
    public byte[] getUploadedFile(IUploadJob job) {
        String folderPath = fileManager.getFolderPath(job.getUsername(), job.getId());
        try {
            return fileManager
                    .getFileContentFromUrl(new URL("file:" + folderPath + File.separator + job.getFilename()));
        } catch (IOException e) {
            logger.error("Could not retrieve uploaded file.", e);
            return null;
        }
    }

    @Override
    public List<IUploadJob> getUploadJobs(IUser user, int page) {
        List<IUploadJob> results = new ArrayList<>();
        jobRepository.findByUsername(user.getUsername(),
                PageRequest.of(page, jobPageSize, Sort.by(Direction.DESC, "createdOn", "id"))).forEach(job -> {
                    results.add(job);
                });
        return results;
    }
}