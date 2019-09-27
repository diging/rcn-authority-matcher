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

import edu.asu.diging.rcn.core.model.Source;
import edu.asu.diging.rcn.core.model.SourceEntry;

@Entity
public class SourceImpl implements Source {

    @Id
    @GeneratedValue(generator = "source_id_generator")
    @GenericGenerator(name = "source_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "SR"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String lastDateTimeVerified;

    @ElementCollection
    private List<String> descriptiveNote;
    
    @OneToMany(targetEntity=SourceEntryImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<SourceEntry> relationEntries;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Source#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Source#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }
    
    public String getLastDateTimeVerified() {
        return lastDateTimeVerified;
    }

    public void setLastDateTimeVerified(String lastDateTimeVerified) {
        this.lastDateTimeVerified = lastDateTimeVerified;
    }

    public List<String> getDescriptiveNote() {
        return descriptiveNote;
    }

    public void setDescriptiveNote(List<String> descriptiveNote) {
        this.descriptiveNote = descriptiveNote;
    }

    public List<SourceEntry> getRelationEntries() {
        return relationEntries;
    }

    public void setRelationEntries(List<SourceEntry> relationEntries) {
        this.relationEntries = relationEntries;
    }
}
