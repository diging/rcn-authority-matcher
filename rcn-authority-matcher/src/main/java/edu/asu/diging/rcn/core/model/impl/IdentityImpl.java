package edu.asu.diging.rcn.core.model.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.EntityId;
import edu.asu.diging.rcn.core.model.EntityType;
import edu.asu.diging.rcn.core.model.Identity;
import edu.asu.diging.rcn.core.model.NameEntry;
import edu.asu.diging.rcn.core.model.NameEntryParallel;

@Entity
public class IdentityImpl implements Identity {

    @Id
    @GeneratedValue(generator = "identity_id_generator")
    @GenericGenerator(name = "identity_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "ID"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String localType;
    private String identityType;
    
    @OneToOne(targetEntity=EntityIdImpl.class, mappedBy="identity", cascade=CascadeType.ALL, orphanRemoval=true)
    private EntityId entityId;
    
    @Enumerated(EnumType.STRING)
    private EntityType entityType;
    
    private String descriptiveNote;
    
    @OneToMany(targetEntity=NameEntryImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<NameEntry> nameEntries;
    
    @OneToMany(targetEntity=NameEntryParallelImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<NameEntryParallel> nameEntriesParallel;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Identity#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Identity#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Identity#getLocalType()
     */
    @Override
    public String getLocalType() {
        return localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Identity#setLocalType(java.lang.String)
     */
    @Override
    public void setLocalType(String localType) {
        this.localType = localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Identity#getIdentityType()
     */
    @Override
    public String getIdentityType() {
        return identityType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Identity#setIdentityType(java.lang.String)
     */
    @Override
    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Identity#getEntityId()
     */
    @Override
    public EntityId getEntityId() {
        return entityId;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Identity#setEntityId(edu.asu.diging.rcn.core.model.EntityId)
     */
    @Override
    public void setEntityId(EntityId entityId) {
        this.entityId = entityId;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Identity#getEntityType()
     */
    @Override
    public EntityType getEntityType() {
        return entityType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Identity#setEntityType(edu.asu.diging.rcn.core.model.EntityType)
     */
    @Override
    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Identity#getDescriptiveNote()
     */
    @Override
    public String getDescriptiveNote() {
        return descriptiveNote;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Identity#setDescriptiveNote(java.lang.String)
     */
    @Override
    public void setDescriptiveNote(String descriptiveNote) {
        this.descriptiveNote = descriptiveNote;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Identity#getNameEntries()
     */
    @Override
    public List<NameEntry> getNameEntries() {
        return nameEntries;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Identity#setNameEntries(java.util.List)
     */
    @Override
    public void setNameEntries(List<NameEntry> nameEntries) {
        this.nameEntries = nameEntries;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Identity#getNameEntriesParallel()
     */
    @Override
    public List<NameEntryParallel> getNameEntriesParallel() {
        return nameEntriesParallel;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Identity#setNameEntriesParallel(java.util.List)
     */
    @Override
    public void setNameEntriesParallel(List<NameEntryParallel> nameEntriesParallel) {
        this.nameEntriesParallel = nameEntriesParallel;
    }
    
}
