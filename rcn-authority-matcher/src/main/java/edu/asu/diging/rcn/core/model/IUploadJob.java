package edu.asu.diging.rcn.core.model;

import java.time.OffsetDateTime;
import java.util.List;

import edu.asu.diging.rcn.core.model.impl.JobPhase;

public interface IUploadJob extends IJob {

    String getFilename();

    void setFilename(String filename);
    
    public JobStatus getStatus();

    public void setStatus(JobStatus status);
    
    public List<JobPhase> getPhases();

    public void setPhases(List<JobPhase> phases);

    void setContentType(String contentType);

    String getContentType();

    void setFileSize(long fileSize);

    long getFileSize();

    void setCreatedOn(OffsetDateTime createdOn);

    OffsetDateTime getCreatedOn();

    void setUsername(String username);

    String getUsername();

    void setDatasetId(String datasetId);

    String getDatasetId();    

}