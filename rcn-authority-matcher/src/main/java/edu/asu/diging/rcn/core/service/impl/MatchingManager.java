package edu.asu.diging.rcn.core.service.impl;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.asu.diging.rcn.core.data.MatchingJobRepository;
import edu.asu.diging.rcn.core.exceptions.MessageCreationException;
import edu.asu.diging.rcn.core.kafka.IKafkaRequestProducer;
import edu.asu.diging.rcn.core.model.IMatchingJob;
import edu.asu.diging.rcn.core.model.JobStatus;
import edu.asu.diging.rcn.core.model.impl.MatchingJob;
import edu.asu.diging.rcn.core.service.IDatasetManager;
import edu.asu.diging.rcn.core.service.IMatchingManager;
import edu.asu.diging.rcn.kafka.messages.KafkaTopics;
import edu.asu.diging.rcn.kafka.messages.model.KafkaMatchAuthoritiesJobMessage;
import edu.asu.diging.simpleusers.core.model.IUser;

@Service
public class MatchingManager implements IMatchingManager {
    
    @Autowired
    private IKafkaRequestProducer kafkaProducer;
    
    @Autowired
    private MatchingJobRepository matchJobRepository;
    
    @Autowired
    private IDatasetManager datasetManager;
    

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.service.impl.IMatchingManager#startMatching(edu.asu.diging.eaccpf.model.Dataset, edu.asu.diging.eaccpf.model.Dataset, edu.asu.diging.simpleusers.core.model.IUser)
     */
    @Override
    public void startMatching(String baseDataset, String compareDataset, IUser user) throws MessageCreationException {
        IMatchingJob matchJob = new MatchingJob();
        matchJob.setBaseDatasetId(baseDataset);
        matchJob.setCompareDatasetId(compareDataset);
        matchJob.setCreatedOn(OffsetDateTime.now());
        matchJob.setStatus(JobStatus.PREPARED);
        matchJob.setUsername(user.getUsername());
        matchJob = matchJobRepository.save((MatchingJob) matchJob);
        
        KafkaMatchAuthoritiesJobMessage msg = new KafkaMatchAuthoritiesJobMessage();
        msg.setBaseDataset(baseDataset);
        msg.setMatchDataset(compareDataset);
        msg.setInitiator(user.getUsername());
        msg.setJobId(matchJob.getId());
        kafkaProducer.sendRequest(msg, KafkaTopics.MATCH_DATASETS_TOPIC);
    }
    
    @Override
    public List<IMatchingJob> listMatchingJobs(String datasetId, Pageable pageable) {
        List<IMatchingJob> results = new ArrayList<IMatchingJob>();
        matchJobRepository.findDistinctByBaseDatasetIdOrCompareDatasetIdOrderByCreatedOn(datasetId, datasetId, pageable).forEach(results::add);;
        results.forEach(m -> m.setCompareDataset(datasetManager.get(m.getCompareDatasetId())));
        return results;
    }
    
    @Override
    public IMatchingJob get(String jobId) {
        Optional<MatchingJob> optional = matchJobRepository.findById(jobId);
        if (!optional.isPresent()) {
            return null;
        }
        return optional.get();
    }
    
}
