package edu.asu.diging.rcn.core.model.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.ComponentEntry;
import edu.asu.diging.rcn.core.model.SetComponent;

@Entity
public class SetComponentImpl implements SetComponent {

    @Id
    @GeneratedValue(generator = "setComp_id_generator")
    @GenericGenerator(name = "setComp_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "SET"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String lastDateTimeVerified;
    private String xlinkHref;
    
    @ElementCollection
    private List<String> descriptiveNote;
    
    @OneToMany(targetEntity=ComponentEntryImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<ComponentEntry> componentEntries;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.SetComponent#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.SetComponent#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.SetComponent#getLastDateTimeVerified()
     */
    @Override
    public String getLastDateTimeVerified() {
        return lastDateTimeVerified;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.SetComponent#setLastDateTimeVerified(java.lang.String)
     */
    @Override
    public void setLastDateTimeVerified(String lastDateTimeVerified) {
        this.lastDateTimeVerified = lastDateTimeVerified;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.SetComponent#getXlinkHref()
     */
    @Override
    public String getXlinkHref() {
        return xlinkHref;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.SetComponent#setXlinkHref(java.lang.String)
     */
    @Override
    public void setXlinkHref(String xlinkHref) {
        this.xlinkHref = xlinkHref;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.SetComponent#getDescriptiveNote()
     */
    @Override
    public List<String> getDescriptiveNote() {
        return descriptiveNote;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.SetComponent#setDescriptiveNote(java.util.List)
     */
    @Override
    public void setDescriptiveNote(List<String> descriptiveNote) {
        this.descriptiveNote = descriptiveNote;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.SetComponent#getComponentEntries()
     */
    @Override
    public List<ComponentEntry> getComponentEntries() {
        return componentEntries;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.SetComponent#setComponentEntries(java.util.List)
     */
    @Override
    public void setComponentEntries(List<ComponentEntry> componentEntries) {
        this.componentEntries = componentEntries;
    }
}
