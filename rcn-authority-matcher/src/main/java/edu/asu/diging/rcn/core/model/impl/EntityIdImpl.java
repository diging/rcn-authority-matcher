package edu.asu.diging.rcn.core.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.EntityId;
import edu.asu.diging.rcn.core.model.Identity;

@Entity
public class EntityIdImpl implements EntityId {

    @Id
    @GeneratedValue(generator = "entityId_id_generator")
    @GenericGenerator(name = "entityId_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "EI"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String localType;
    private String entityId;
    
    private Identity identity;
    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.EntityId#getId()
     */
    @Override
    public String getId() {
        return id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.EntityId#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.EntityId#getLocalType()
     */
    @Override
    public String getLocalType() {
        return localType;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.EntityId#setLocalType(java.lang.String)
     */
    @Override
    public void setLocalType(String localType) {
        this.localType = localType;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.EntityId#getEntityId()
     */
    @Override
    public String getEntityId() {
        return entityId;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.EntityId#setEntityId(java.lang.String)
     */
    @Override
    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }
    public Identity getIdentity() {
        return identity;
    }
    public void setIdentity(Identity identity) {
        this.identity = identity;
    }
    
    
}
