package edu.asu.diging.rcn.core.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.SourceEntry;

@Entity
public class SourceEntryImpl implements SourceEntry {

    @Id
    @GeneratedValue(generator = "sourceEntry_id_generator")
    @GenericGenerator(name = "sourceEntry_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "SEN"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String scriptCode;
    
    private String transliteration;
    
    private String text;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.RelationEntry#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.RelationEntry#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.RelationEntry#getScriptCode()
     */
    @Override
    public String getScriptCode() {
        return scriptCode;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.RelationEntry#setScriptCode(java.lang.String)
     */
    @Override
    public void setScriptCode(String scriptCode) {
        this.scriptCode = scriptCode;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.RelationEntry#getTransliteration()
     */
    @Override
    public String getTransliteration() {
        return transliteration;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.RelationEntry#setTransliteration(java.lang.String)
     */
    @Override
    public void setTransliteration(String transliteration) {
        this.transliteration = transliteration;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.RelationEntry#getText()
     */
    @Override
    public String getText() {
        return text;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.RelationEntry#setText(java.lang.String)
     */
    @Override
    public void setText(String text) {
        this.text = text;
    }
}
