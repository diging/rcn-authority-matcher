package edu.asu.diging.rcn.core.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.Date;

@Entity
public class DateImpl implements Date {

    @Id
    @GeneratedValue(generator = "date_id_generator")
    @GenericGenerator(name = "date_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "DA"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String date;
    private String standardDate;
    private String notBefore;
    
    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Date#getId()
     */
    @Override
    public String getId() {
        return id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Date#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Date#getDate()
     */
    @Override
    public String getDate() {
        return date;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Date#setDate(java.lang.String)
     */
    @Override
    public void setDate(String date) {
        this.date = date;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Date#getStandardDate()
     */
    @Override
    public String getStandardDate() {
        return standardDate;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Date#setStandardDate(java.lang.String)
     */
    @Override
    public void setStandardDate(String standardDate) {
        this.standardDate = standardDate;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Date#getNotBefore()
     */
    @Override
    public String getNotBefore() {
        return notBefore;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Date#setNotBefore(java.lang.String)
     */
    @Override
    public void setNotBefore(String notBefore) {
        this.notBefore = notBefore;
    }
    
}
