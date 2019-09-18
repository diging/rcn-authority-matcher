package edu.asu.diging.rcn.core.model.impl;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.ChronItem;
import edu.asu.diging.rcn.core.model.Date;
import edu.asu.diging.rcn.core.model.DateRange;

@Entity
public class ChronItemImpl implements ChronItem {

    @Id
    @GeneratedValue(generator = "chronItem_id_generator")
    @GenericGenerator(name = "chronItem_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "CI"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    private String localType;
    
    @OneToOne(targetEntity=DateImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private Date date;
    
    @OneToOne(targetEntity=DateRangeImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private DateRange dateRange;
    
    private String event;
    private String placeEntry;
    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronItem#getId()
     */
    @Override
    public String getId() {
        return id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronItem#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String getLocalType() {
        return localType;
    }
    @Override
    public void setLocalType(String localType) {
        this.localType = localType;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronItem#getDate()
     */
    @Override
    public Date getDate() {
        return date;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronItem#setDate(edu.asu.diging.rcn.core.model.Date)
     */
    @Override
    public void setDate(Date date) {
        this.date = date;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronItem#getDateRange()
     */
    @Override
    public DateRange getDateRange() {
        return dateRange;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronItem#setDateRange(edu.asu.diging.rcn.core.model.DateRange)
     */
    @Override
    public void setDateRange(DateRange dateRange) {
        this.dateRange = dateRange;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronItem#getEvent()
     */
    @Override
    public String getEvent() {
        return event;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronItem#setEvent(java.lang.String)
     */
    @Override
    public void setEvent(String event) {
        this.event = event;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronItem#getPlaceEntry()
     */
    @Override
    public String getPlaceEntry() {
        return placeEntry;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronItem#setPlaceEntry(java.lang.String)
     */
    @Override
    public void setPlaceEntry(String placeEntry) {
        this.placeEntry = placeEntry;
    }
    
}
