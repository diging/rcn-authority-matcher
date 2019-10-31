package edu.asu.diging.rcn.core.model;

import java.time.OffsetDateTime;
import java.util.List;

import edu.asu.diging.eaccpf.model.Dataset;
import edu.asu.diging.rcn.core.model.impl.JobPhase;

public interface IMatchingJob extends IJob {

    String getUsername();

    void setUsername(String username);

    JobStatus getStatus();

    void setStatus(JobStatus status);

    OffsetDateTime getCreatedOn();

    void setCreatedOn(OffsetDateTime createdOn);

    List<JobPhase> getPhases();

    void setPhases(List<JobPhase> phases);

    String getBaseDatasetId();

    void setBaseDatasetId(String baseDatasetId);

    String getCompareDatasetId();

    void setCompareDatasetId(String compareDatasetId);

    Dataset getCompareDataset();

    void setCompareDataset(Dataset compareDataset);

}