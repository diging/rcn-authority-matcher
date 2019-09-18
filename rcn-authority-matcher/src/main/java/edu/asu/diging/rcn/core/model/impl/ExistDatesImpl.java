package edu.asu.diging.rcn.core.model.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.Date;
import edu.asu.diging.rcn.core.model.DateRange;
import edu.asu.diging.rcn.core.model.DateSet;
import edu.asu.diging.rcn.core.model.ExistDates;

@Entity
public class ExistDatesImpl implements ExistDates {

    @Id
    @GeneratedValue(generator = "desc_id_generator")
    @GenericGenerator(name = "desc_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "DE"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    @OneToOne(targetEntity=DateImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private Date date;
    
    @OneToOne(targetEntity=DateRangeImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private DateRange dateRange;
    
    @OneToOne(targetEntity=DateSetImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private DateSet dateSet;
    
    @ElementCollection
    private List<String> descriptiveNote;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ExistDates#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ExistDates#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ExistDates#getDate()
     */
    @Override
    public Date getDate() {
        return date;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ExistDates#setDate(edu.asu.diging.rcn.core.model.Date)
     */
    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ExistDates#getDateRange()
     */
    @Override
    public DateRange getDateRange() {
        return dateRange;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ExistDates#setDateRange(edu.asu.diging.rcn.core.model.DateRange)
     */
    @Override
    public void setDateRange(DateRange dateRange) {
        this.dateRange = dateRange;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ExistDates#getDateSet()
     */
    @Override
    public DateSet getDateSet() {
        return dateSet;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ExistDates#setDateSet(edu.asu.diging.rcn.core.model.DateSet)
     */
    @Override
    public void setDateSet(DateSet dateSet) {
        this.dateSet = dateSet;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ExistDates#getDescriptiveNote()
     */
    @Override
    public List<String> getDescriptiveNote() {
        return descriptiveNote;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ExistDates#setDescriptiveNote(java.util.List)
     */
    @Override
    public void setDescriptiveNote(List<String> descriptiveNote) {
        this.descriptiveNote = descriptiveNote;
    }
    
}
