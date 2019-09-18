package edu.asu.diging.rcn.core.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.DateTime;

@Entity
public class DateTimeImpl implements DateTime {

    @Id
    @GeneratedValue(generator = "datetime_id_generator")
    @GenericGenerator(name = "datetime_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "DT"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String standard;
    private String datetime;
    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.DateTime#getId()
     */
    @Override
    public String getId() {
        return id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.DateTime#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.DateTime#getStandard()
     */
    @Override
    public String getStandard() {
        return standard;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.DateTime#setStandard(java.lang.String)
     */
    @Override
    public void setStandard(String standard) {
        this.standard = standard;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.DateTime#getDatetime()
     */
    @Override
    public String getDatetime() {
        return datetime;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.DateTime#setDatetime(java.lang.String)
     */
    @Override
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
