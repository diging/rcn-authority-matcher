package edu.asu.diging.rcn.core.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.AddressLine;

@Entity
public class AddressLineImpl implements AddressLine {

    @Id
    @GeneratedValue(generator = "addressline_id_generator")
    @GenericGenerator(name = "addressline_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "ADL"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String localType;
    
    private String line;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.AddressLine#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.AddressLine#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.AddressLine#getLocalType()
     */
    @Override
    public String getLocalType() {
        return localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.AddressLine#setLocalType(java.lang.String)
     */
    @Override
    public void setLocalType(String localType) {
        this.localType = localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.AddressLine#getLine()
     */
    @Override
    public String getLine() {
        return line;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.AddressLine#setLine(java.lang.String)
     */
    @Override
    public void setLine(String line) {
        this.line = line;
    }
}
