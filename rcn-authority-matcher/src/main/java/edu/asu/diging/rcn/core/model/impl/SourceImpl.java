package edu.asu.diging.rcn.core.model.impl;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.Source;

@Entity
public class SourceImpl implements Source {

    @Id
    @GeneratedValue(generator = "source_id_generator")
    @GenericGenerator(name = "source_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "SR"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    @ElementCollection
    private List<String> sourceEntries;

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

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Source#getSourceEntries()
     */
    @Override
    public List<String> getSourceEntries() {
        return sourceEntries;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Source#setSourceEntries(java.util.List)
     */
    @Override
    public void setSourceEntries(List<String> sourceEntries) {
        this.sourceEntries = sourceEntries;
    }
    
    
}
