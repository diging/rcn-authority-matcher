package edu.asu.diging.rcn.core.model.impl;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.DateRange;
import edu.asu.diging.rcn.core.model.LocalControl;

@Entity
public class LocalControlImpl implements LocalControl {

    @Id
    @GeneratedValue(generator = "locCon_id_generator")
    @GenericGenerator(name = "locCon_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "LC"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String date;
    @OneToOne(targetEntity=DateRangeImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private DateRange dateRange;
    private String term;
    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalControl#getId()
     */
    @Override
    public String getId() {
        return id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalControl#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalControl#getDate()
     */
    @Override
    public String getDate() {
        return date;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalControl#setDate(java.lang.String)
     */
    @Override
    public void setDate(String date) {
        this.date = date;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalControl#getDateRange()
     */
    @Override
    public DateRange getDateRange() {
        return dateRange;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalControl#setDateRange(edu.asu.diging.rcn.core.model.DateRange)
     */
    @Override
    public void setDateRange(DateRange dateRange) {
        this.dateRange = dateRange;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalControl#getTerm()
     */
    @Override
    public String getTerm() {
        return term;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalControl#setTerm(java.lang.String)
     */
    @Override
    public void setTerm(String term) {
        this.term = term;
    }
    
}
