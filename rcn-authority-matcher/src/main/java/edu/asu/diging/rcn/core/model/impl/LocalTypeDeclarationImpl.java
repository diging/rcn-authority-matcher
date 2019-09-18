package edu.asu.diging.rcn.core.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.LocalTypeDeclaration;

@Entity
public class LocalTypeDeclarationImpl implements LocalTypeDeclaration {

    @Id
    @GeneratedValue(generator = "loctype_id_generator")
    @GenericGenerator(name = "loctype_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "LT"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String abbreviation;
    private String citation;
    private String descriptiveNote;
    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalTypeDeclaration#getId()
     */
    @Override
    public String getId() {
        return id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalTypeDeclaration#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalTypeDeclaration#getAbbreviation()
     */
    @Override
    public String getAbbreviation() {
        return abbreviation;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalTypeDeclaration#setAbbreviation(java.lang.String)
     */
    @Override
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalTypeDeclaration#getCitation()
     */
    @Override
    public String getCitation() {
        return citation;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalTypeDeclaration#setCitation(java.lang.String)
     */
    @Override
    public void setCitation(String citation) {
        this.citation = citation;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalTypeDeclaration#getDescriptiveNote()
     */
    @Override
    public String getDescriptiveNote() {
        return descriptiveNote;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalTypeDeclaration#setDescriptiveNote(java.lang.String)
     */
    @Override
    public void setDescriptiveNote(String descriptiveNote) {
        this.descriptiveNote = descriptiveNote;
    }
    
}
