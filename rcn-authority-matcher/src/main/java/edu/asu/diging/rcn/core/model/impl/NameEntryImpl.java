package edu.asu.diging.rcn.core.model.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.NameEntry;
import edu.asu.diging.rcn.core.model.NamePart;
import edu.asu.diging.rcn.core.model.UseDates;

@Entity
public class NameEntryImpl implements NameEntry {

    @Id
    @GeneratedValue(generator = "nameEntry_id_generator")
    @GenericGenerator(name = "nameEntry_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "NE"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String localType;
    private String scriptCode;
    private String transliteration;
    
    private String alternativeForm;
    private String authorizedForm;
    private String preferredForm;
    
    @OneToMany(targetEntity=NamePartImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<NamePart> parts;
    
    @OneToOne(targetEntity=UseDatesImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private UseDates useDates;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NameEntry#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NameEntry#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NameEntry#getLocalType()
     */
    @Override
    public String getLocalType() {
        return localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NameEntry#setLocalType(java.lang.String)
     */
    @Override
    public void setLocalType(String localType) {
        this.localType = localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NameEntry#getScriptCode()
     */
    @Override
    public String getScriptCode() {
        return scriptCode;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NameEntry#setScriptCode(java.lang.String)
     */
    @Override
    public void setScriptCode(String scriptCode) {
        this.scriptCode = scriptCode;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NameEntry#getTransliteration()
     */
    @Override
    public String getTransliteration() {
        return transliteration;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NameEntry#setTransliteration(java.lang.String)
     */
    @Override
    public void setTransliteration(String transliteration) {
        this.transliteration = transliteration;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NameEntry#getAlternativeForm()
     */
    @Override
    public String getAlternativeForm() {
        return alternativeForm;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NameEntry#setAlternativeForm(java.lang.String)
     */
    @Override
    public void setAlternativeForm(String alternativeForm) {
        this.alternativeForm = alternativeForm;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NameEntry#getAuthorizedForm()
     */
    @Override
    public String getAuthorizedForm() {
        return authorizedForm;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NameEntry#setAuthorizedForm(java.lang.String)
     */
    @Override
    public void setAuthorizedForm(String authorizedForm) {
        this.authorizedForm = authorizedForm;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NameEntry#getPreferredForm()
     */
    @Override
    public String getPreferredForm() {
        return preferredForm;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NameEntry#setPreferredForm(java.lang.String)
     */
    @Override
    public void setPreferredForm(String preferredForm) {
        this.preferredForm = preferredForm;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NameEntry#getParts()
     */
    @Override
    public List<NamePart> getParts() {
        return parts;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NameEntry#setParts(java.util.List)
     */
    @Override
    public void setParts(List<NamePart> parts) {
        this.parts = parts;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NameEntry#getUseDates()
     */
    @Override
    public UseDates getUseDates() {
        return useDates;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.NameEntry#setUseDates(edu.asu.diging.rcn.core.model.UseDates)
     */
    @Override
    public void setUseDates(UseDates useDates) {
        this.useDates = useDates;
    }
    
}
