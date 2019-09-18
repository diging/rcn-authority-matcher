package edu.asu.diging.rcn.core.model.impl;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.LanguageUsed;

@Entity
public class LanguageUsedImpl implements LanguageUsed {

    @Id
    @GeneratedValue(generator = "langUsed_id_generator")
    @GenericGenerator(name = "langUsed_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "LU"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    @ElementCollection
    private List<String> descriptiveNote;
    
    private String language;
    private String languageCode;
    private String script;
    private String scriptCode;
    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguageUsed#getId()
     */
    @Override
    public String getId() {
        return id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguageUsed#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguageUsed#getDescriptiveNote()
     */
    @Override
    public List<String> getDescriptiveNote() {
        return descriptiveNote;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguageUsed#setDescriptiveNote(java.util.List)
     */
    @Override
    public void setDescriptiveNote(List<String> descriptiveNote) {
        this.descriptiveNote = descriptiveNote;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguageUsed#getLanguage()
     */
    @Override
    public String getLanguage() {
        return language;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguageUsed#setLanguage(java.lang.String)
     */
    @Override
    public void setLanguage(String language) {
        this.language = language;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguageUsed#getLanguageCode()
     */
    @Override
    public String getLanguageCode() {
        return languageCode;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguageUsed#setLanguageCode(java.lang.String)
     */
    @Override
    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguageUsed#getScript()
     */
    @Override
    public String getScript() {
        return script;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguageUsed#setScript(java.lang.String)
     */
    @Override
    public void setScript(String script) {
        this.script = script;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguageUsed#getScriptCode()
     */
    @Override
    public String getScriptCode() {
        return scriptCode;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguageUsed#setScriptCode(java.lang.String)
     */
    @Override
    public void setScriptCode(String scriptCode) {
        this.scriptCode = scriptCode;
    }
    
}
