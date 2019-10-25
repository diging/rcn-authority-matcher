package edu.asu.diging.rcn.core.service.impl;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.asu.diging.rcn.core.data.MatchingJobRepository;
import edu.asu.diging.rcn.core.exceptions.MessageCreationException;
import edu.asu.diging.rcn.core.kafka.IKafkaRequestProducer;
import edu.asu.diging.rcn.core.model.IMatchingJob;
import edu.asu.diging.rcn.core.model.JobStatus;
import edu.asu.diging.rcn.core.model.impl.MatchingJob;
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
}
