package edu.asu.diging.rcn.core.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.LanguageDeclaration;

@Entity
public class LanguageDeclarationImpl implements LanguageDeclaration {

    @Id
    @GeneratedValue(generator = "lang_id_generator")
    @GenericGenerator(name = "lang_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "LA"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String language;
    private String languageCode;
    private String script;
    private String scriptCode;
    
    private RecordImpl record;
    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguageDeclaration#getId()
     */
    @Override
    public String getId() {
        return id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguageDeclaration#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguageDeclaration#getLanguage()
     */
    @Override
    public String getLanguage() {
        return language;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguageDeclaration#setLanguage(java.lang.String)
     */
    @Override
    public void setLanguage(String language) {
        this.language = language;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguageDeclaration#getLanguageCode()
     */
    @Override
    public String getLanguageCode() {
        return languageCode;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguageDeclaration#setLanguageCode(java.lang.String)
     */
    @Override
    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguageDeclaration#getScript()
     */
    @Override
    public String getScript() {
        return script;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguageDeclaration#setScript(java.lang.String)
     */
    @Override
    public void setScript(String script) {
        this.script = script;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguageDeclaration#getScriptCode()
     */
    @Override
    public String getScriptCode() {
        return scriptCode;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguageDeclaration#setScriptCode(java.lang.String)
     */
    @Override
    public void setScriptCode(String scriptCode) {
        this.scriptCode = scriptCode;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguageDeclaration#getRecord()
     */
    @Override
    public RecordImpl getRecord() {
        return record;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LanguageDeclaration#setRecord(edu.asu.diging.rcn.core.model.impl.RecordImpl)
     */
    @Override
    public void setRecord(RecordImpl record) {
        this.record = record;
    }
    
}
