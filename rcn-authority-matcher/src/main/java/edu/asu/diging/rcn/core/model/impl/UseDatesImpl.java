package edu.asu.diging.rcn.core.model.impl;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.Date;
import edu.asu.diging.rcn.core.model.DateRange;
import edu.asu.diging.rcn.core.model.DateSet;
import edu.asu.diging.rcn.core.model.UseDates;

@Entity
public class UseDatesImpl implements UseDates {

    @Id
    @GeneratedValue(generator = "useDate_id_generator")
    @GenericGenerator(name = "useDate_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "UD"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
   
    @OneToOne(targetEntity=DateImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private Date date;
    
    @OneToOne(targetEntity=DateRangeImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private DateRange dateRange;
    
    @OneToOne(targetEntity=DateSetImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private DateSet dateSet;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.UseDates#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.UseDates#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.UseDates#getDate()
     */
    @Override
    public Date getDate() {
        return date;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.UseDates#setDate(edu.asu.diging.rcn.core.model.Date)
     */
    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.UseDates#getDateRange()
     */
    @Override
    public DateRange getDateRange() {
        return dateRange;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.UseDates#setDateRange(edu.asu.diging.rcn.core.model.DateRange)
     */
    @Override
    public void setDateRange(DateRange dateRange) {
        this.dateRange = dateRange;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.UseDates#getDateSet()
     */
    @Override
    public DateSet getDateSet() {
        return dateSet;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.UseDates#setDateSet(edu.asu.diging.rcn.core.model.DateSet)
     */
    @Override
    public void setDateSet(DateSet dateSet) {
        this.dateSet = dateSet;
    }
    
}
