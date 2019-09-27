package edu.asu.diging.rcn.core.model.impl;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.RightsDeclaration;

@Entity
public class RightsDeclarationImpl implements RightsDeclaration {

    @Id
    @GeneratedValue(generator = "rights_id_generator")
    @GenericGenerator(name = "rights_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "RI"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String localType;
    
    private String abbreviation;
    private String citation;

    @ElementCollection
    private List<String> descriptiveNote;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.RightsDeclaration#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.RightsDeclaration#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.RightsDeclaration#getLocalType()
     */
    @Override
    public String getLocalType() {
        return localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.RightsDeclaration#setLocalType(java.lang.String)
     */
    @Override
    public void setLocalType(String localType) {
        this.localType = localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.RightsDeclaration#getAbbreviation()
     */
    @Override
    public String getAbbreviation() {
        return abbreviation;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.RightsDeclaration#setAbbreviation(java.lang.String)
     */
    @Override
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.RightsDeclaration#getCitation()
     */
    @Override
    public String getCitation() {
        return citation;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.RightsDeclaration#setCitation(java.lang.String)
     */
    @Override
    public void setCitation(String citation) {
        this.citation = citation;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.RightsDeclaration#getDescriptiveNote()
     */
    @Override
    public List<String> getDescriptiveNote() {
        return descriptiveNote;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.RightsDeclaration#setDescriptiveNote(java.util.List)
     */
    @Override
    public void setDescriptiveNote(List<String> descriptiveNote) {
        this.descriptiveNote = descriptiveNote;
    }
    
}
