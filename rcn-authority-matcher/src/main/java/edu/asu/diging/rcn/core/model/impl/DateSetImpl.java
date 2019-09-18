package edu.asu.diging.rcn.core.model.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.Date;
import edu.asu.diging.rcn.core.model.DateRange;
import edu.asu.diging.rcn.core.model.DateSet;

@Entity
public class DateSetImpl implements DateSet {

    @Id
    @GeneratedValue(generator = "dateset_id_generator")
    @GenericGenerator(name = "dateset_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "DS"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    private String localType;
    @OneToMany(targetEntity=DateImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Date> dates;
    @OneToMany(targetEntity=DateRangeImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<DateRange> dateRanges;
    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.DateSet#getId()
     */
    @Override
    public String getId() {
        return id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.DateSet#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.DateSet#getLocalType()
     */
    @Override
    public String getLocalType() {
        return localType;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.DateSet#setLocalType(java.lang.String)
     */
    @Override
    public void setLocalType(String localType) {
        this.localType = localType;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.DateSet#getDates()
     */
    @Override
    public List<Date> getDates() {
        return dates;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.DateSet#setDates(java.util.List)
     */
    @Override
    public void setDates(List<Date> dates) {
        this.dates = dates;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.DateSet#getDateRanges()
     */
    @Override
    public List<DateRange> getDateRanges() {
        return dateRanges;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.DateSet#setDateRanges(java.util.List)
     */
    @Override
    public void setDateRanges(List<DateRange> dateRanges) {
        this.dateRanges = dateRanges;
    }
    
}
