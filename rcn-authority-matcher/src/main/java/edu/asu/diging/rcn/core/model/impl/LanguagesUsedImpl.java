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

import edu.asu.diging.rcn.core.model.LanguageUsed;
import edu.asu.diging.rcn.core.model.LanguagesUsed;

@Entity
public class LanguagesUsedImpl implements LanguagesUsed {

    @Id
    @GeneratedValue(generator = "langsUsed_id_generator")
    @GenericGenerator(name = "langsUsed_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "LS"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    private String localType;
    
    @ElementCollection
    private List<String> descriptiveNote;
    
    @OneToMany(targetEntity=LanguageUsedImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<LanguageUsed> langugesUsed;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguagesUsed#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguagesUsed#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguagesUsed#getLocalType()
     */
    @Override
    public String getLocalType() {
        return localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguagesUsed#setLocalType(java.lang.String)
     */
    @Override
    public void setLocalType(String localType) {
        this.localType = localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguagesUsed#getDescriptiveNote()
     */
    @Override
    public List<String> getDescriptiveNote() {
        return descriptiveNote;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguagesUsed#setDescriptiveNote(java.util.List)
     */
    @Override
    public void setDescriptiveNote(List<String> descriptiveNote) {
        this.descriptiveNote = descriptiveNote;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguagesUsed#getLangugesUsed()
     */
    @Override
    public List<LanguageUsed> getLangugesUsed() {
        return langugesUsed;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguagesUsed#setLangugesUsed(java.util.List)
     */
    @Override
    public void setLangugesUsed(List<LanguageUsed> langugesUsed) {
        this.langugesUsed = langugesUsed;
    }
    
    
}
