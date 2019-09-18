package edu.asu.diging.rcn.core.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.DateRange;

@Entity
public class DateRangeImpl implements DateRange {
    
    @Id
    @GeneratedValue(generator = "daterange_id_generator")
    @GenericGenerator(name = "daterange_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "DR"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String fromDate;
    private String toDate;
    
    private String localType;
    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.DateRange#getId()
     */
    @Override
    public String getId() {
        return id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.DateRange#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.DateRange#getFromDate()
     */
    @Override
    public String getFromDate() {
        return fromDate;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.DateRange#setFromDate(java.lang.String)
     */
    @Override
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.DateRange#getToDate()
     */
    @Override
    public String getToDate() {
        return toDate;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.DateRange#setToDate(java.lang.String)
     */
    @Override
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }
    @Override
    public String getLocalType() {
        return localType;
    }
    @Override
    public void setLocalType(String localType) {
        this.localType = localType;
    }
    
    
}

