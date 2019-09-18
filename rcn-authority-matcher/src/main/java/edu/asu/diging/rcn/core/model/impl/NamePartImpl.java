package edu.asu.diging.rcn.core.model.impl;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.NamePart;

public class NamePartImpl implements NamePart {

    @Id
    @GeneratedValue(generator = "nameEntry_id_generator")
    @GenericGenerator(name = "nameEntry_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "NE"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String localType;
    private String part;
    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NamePart#getId()
     */
    @Override
    public String getId() {
        return id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NamePart#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NamePart#getLocalType()
     */
    @Override
    public String getLocalType() {
        return localType;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NamePart#setLocalType(java.lang.String)
     */
    @Override
    public void setLocalType(String localType) {
        this.localType = localType;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NamePart#getPart()
     */
    @Override
    public String getPart() {
        return part;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NamePart#setPart(java.lang.String)
     */
    @Override
    public void setPart(String part) {
        this.part = part;
    }
    
    
}
