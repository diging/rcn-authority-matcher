package edu.asu.diging.rcn.core.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import edu.asu.diging.rcn.core.exceptions.MessageCreationException;
import edu.asu.diging.rcn.core.model.IMatchingJob;
import edu.asu.diging.simpleusers.core.model.IUser;

public interface IMatchingManager {

    void startMatching(String baseDataset, String compareDataset, IUser user) throws MessageCreationException;

    List<IMatchingJob> listMatchingJobs(String datasetId, Pageable pageable);

    IMatchingJob get(String jobId);

}