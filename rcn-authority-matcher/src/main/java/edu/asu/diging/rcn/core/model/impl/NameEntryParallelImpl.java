package edu.asu.diging.rcn.core.model.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.NameEntry;
import edu.asu.diging.rcn.core.model.NameEntryParallel;

public class NameEntryParallelImpl implements NameEntryParallel {

    @Id
    @GeneratedValue(generator = "nameEntryPar_id_generator")
    @GenericGenerator(name = "nameEntryPar_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "NP"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String localType;
    
    @OneToMany(targetEntity=NameEntryImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<NameEntry> nameEntries;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NameEntryParallel#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NameEntryParallel#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NameEntryParallel#getLocalType()
     */
    @Override
    public String getLocalType() {
        return localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NameEntryParallel#setLocalType(java.lang.String)
     */
    @Override
    public void setLocalType(String localType) {
        this.localType = localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NameEntryParallel#getNameEntries()
     */
    @Override
    public List<NameEntry> getNameEntries() {
        return nameEntries;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NameEntryParallel#setNameEntries(java.util.List)
     */
    @Override
    public void setNameEntries(List<NameEntry> nameEntries) {
        this.nameEntries = nameEntries;
    }
    
    
}
