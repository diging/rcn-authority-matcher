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

import edu.asu.diging.rcn.core.model.IMatchingJob;
import edu.asu.diging.rcn.core.model.JobStatus;

@Entity
public class MatchingJob implements IMatchingJob {

    @Id
    @GeneratedValue(generator = "mjob_id_generator")
    @GenericGenerator(name = "mjob_id_generator", parameters = @Parameter(name = "prefix", value = "MJOB"), strategy = "edu.asu.diging.rcn.core.data.IdGenerator")
    private String id;

    private String username;

    @Enumerated(EnumType.STRING)
    private JobStatus status;

    private OffsetDateTime createdOn;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<JobPhase> phases;

    private String baseDatasetId;
    private String compareDatasetId;


    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.IMatchingJob#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.IMatchingJob#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.IMatchingJob#getUsername()
     */
    @Override
    public String getUsername() {
        return username;
    }

    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.IMatchingJob#setUsername(java.lang.String)
     */
    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.IMatchingJob#getStatus()
     */
    @Override
    public JobStatus getStatus() {
        return status;
    }

    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.IMatchingJob#setStatus(edu.asu.diging.rcn.core.model.JobStatus)
     */
    @Override
    public void setStatus(JobStatus status) {
        this.status = status;
    }

    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.IMatchingJob#getCreatedOn()
     */
    @Override
    public OffsetDateTime getCreatedOn() {
        return createdOn;
    }

    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.IMatchingJob#setCreatedOn(java.time.OffsetDateTime)
     */
    @Override
    public void setCreatedOn(OffsetDateTime createdOn) {
        this.createdOn = createdOn;
    }

    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.IMatchingJob#getPhases()
     */
    @Override
    public List<JobPhase> getPhases() {
        return phases;
    }

    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.IMatchingJob#setPhases(java.util.List)
     */
    @Override
    public void setPhases(List<JobPhase> phases) {
        this.phases = phases;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.IMatchingJob#getBaseDatasetId()
     */
    @Override
    public String getBaseDatasetId() {
        return baseDatasetId;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.IMatchingJob#setBaseDatasetId(java.lang.String)
     */
    @Override
    public void setBaseDatasetId(String baseDatasetId) {
        this.baseDatasetId = baseDatasetId;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.IMatchingJob#getCompareDatasetId()
     */
    @Override
    public String getCompareDatasetId() {
        return compareDatasetId;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.IMatchingJob#setCompareDatasetId(java.lang.String)
     */
    @Override
    public void setCompareDatasetId(String compareDatasetId) {
        this.compareDatasetId = compareDatasetId;
    }

}