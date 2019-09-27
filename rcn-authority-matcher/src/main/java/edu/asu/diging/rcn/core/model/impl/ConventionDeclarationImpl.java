package edu.asu.diging.rcn.core.model.impl;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.ConventionDeclaration;

@Entity
public class ConventionDeclarationImpl implements ConventionDeclaration {

    @Id
    @GeneratedValue(generator = "conDecl_id_generator")
    @GenericGenerator(name = "conDecl_id_generator", parameters = @Parameter(name = "prefix", value = "CD"), strategy = "edu.asu.diging.rcn.core.data.IdGenerator")
    private String id;

    private String abbreviation;
    private String citation;

    @ElementCollection
    private List<String> descriptiveNote;

    /*
     * (non-Javadoc)
     * 
     * @see edu.asu.diging.rcn.core.model.impl.ConventionDeclaration#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * edu.asu.diging.rcn.core.model.impl.ConventionDeclaration#setId(java.lang.
     * String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * edu.asu.diging.rcn.core.model.impl.ConventionDeclaration#getAbbreviation()
     */
    @Override
    public String getAbbreviation() {
        return abbreviation;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * edu.asu.diging.rcn.core.model.impl.ConventionDeclaration#setAbbreviation(java
     * .lang.String)
     */
    @Override
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /*
     * (non-Javadoc)
     * 
     * @see edu.asu.diging.rcn.core.model.impl.ConventionDeclaration#getCitation()
     */
    @Override
    public String getCitation() {
        return citation;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * edu.asu.diging.rcn.core.model.impl.ConventionDeclaration#setCitation(java.
     * lang.String)
     */
    @Override
    public void setCitation(String citation) {
        this.citation = citation;
    }

    @Override
    public List<String> getDescriptiveNote() {
        return descriptiveNote;
    }

    @Override
    public void setDescriptiveNote(List<String> descriptiveNote) {
        this.descriptiveNote = descriptiveNote;
    }

}
