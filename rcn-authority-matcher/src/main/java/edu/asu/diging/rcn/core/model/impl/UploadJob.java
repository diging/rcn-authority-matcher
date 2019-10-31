package edu.asu.diging.rcn.core.model.impl;

import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.asu.diging.rcn.core.model.IUploadJob;
import edu.asu.diging.rcn.core.model.JobStatus;

@Entity
public class UploadJob implements IUploadJob {

    @Id
    @GeneratedValue(generator = "job_id_generator")
    @GenericGenerator(name = "job_id_generator", parameters = @Parameter(name = "prefix", value = "JOB"), strategy = "edu.asu.diging.rcn.core.data.IdGenerator")
    private String id;

    private String username;

    @Enumerated(EnumType.STRING)
    private JobStatus status;

    private OffsetDateTime createdOn;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<JobPhase> phases;

    private String filename;
    private long fileSize;
    private String contentType;
    
    private String datasetId;

    /*
     * (non-Javadoc)
     * 
     * @see edu.asu.diging.citesphere.core.model.jobs.impl.IUploadJob#getFilename()
     */
    @Override
    public String getFilename() {
        return filename;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * edu.asu.diging.citesphere.core.model.jobs.impl.IUploadJob#setFilename(java.
     * lang.String)
     */
    @Override
    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public long getFileSize() {
        return fileSize;
    }

    @Override
    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public JobStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(JobStatus status) {
        this.status = status;
    }

    @Override
    public OffsetDateTime getCreatedOn() {
        return createdOn;
    }

    @Override
    public void setCreatedOn(OffsetDateTime createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public List<JobPhase> getPhases() {
        return phases;
    }

    @Override
    public void setPhases(List<JobPhase> phases) {
        this.phases = phases;
    }

    @Override
    public String getDatasetId() {
        return datasetId;
    }

    @Override
    public void setDatasetId(String datasetId) {
        this.datasetId = datasetId;
    }
}