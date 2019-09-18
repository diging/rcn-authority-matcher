package edu.asu.diging.rcn.core.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.MaintenanceAgency;

@Entity
public class MaintenanceAgencyImpl implements MaintenanceAgency {
    
    @Id
    @GeneratedValue(generator = "agency_id_generator")
    @GenericGenerator(name = "agency_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "AG"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    private String name;
    private String code;
    private String descriptiveNote;
    private RecordImpl record;
    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.MaintenanceAgency#getId()
     */
    @Override
    public String getId() {
        return id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.MaintenanceAgency#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.MaintenanceAgency#getName()
     */
    @Override
    public String getName() {
        return name;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.MaintenanceAgency#setName(java.lang.String)
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.MaintenanceAgency#getCode()
     */
    @Override
    public String getCode() {
        return code;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.MaintenanceAgency#setCode(java.lang.String)
     */
    @Override
    public void setCode(String code) {
        this.code = code;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.MaintenanceAgency#getDescriptiveNote()
     */
    @Override
    public String getDescriptiveNote() {
        return descriptiveNote;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.MaintenanceAgency#setDescriptiveNote(java.lang.String)
     */
    @Override
    public void setDescriptiveNote(String descriptiveNote) {
        this.descriptiveNote = descriptiveNote;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.MaintenanceAgency#getRecord()
     */
    @Override
    public RecordImpl getRecord() {
        return record;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.MaintenanceAgency#setRecord(edu.asu.diging.rcn.core.model.impl.RecordImpl)
     */
    @Override
    public void setRecord(RecordImpl record) {
        this.record = record;
    }
}
