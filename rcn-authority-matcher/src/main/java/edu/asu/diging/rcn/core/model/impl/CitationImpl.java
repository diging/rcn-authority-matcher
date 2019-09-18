package edu.asu.diging.rcn.core.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.Citation;

@Entity
public class CitationImpl implements Citation {

    @Id
    @GeneratedValue(generator = "citation_id_generator")
    @GenericGenerator(name = "citation_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "CI"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String citationParts;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Citation#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Citation#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Citation#getCitationParts()
     */
    @Override
    public String getCitationParts() {
        return citationParts;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Citation#setCitationParts(java.lang.String)
     */
    @Override
    public void setCitationParts(String citationParts) {
        this.citationParts = citationParts;
    }
    
}
