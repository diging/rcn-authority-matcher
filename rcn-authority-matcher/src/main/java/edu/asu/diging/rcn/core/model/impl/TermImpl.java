package edu.asu.diging.rcn.core.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.Term;

@Entity
public class TermImpl implements Term {

    @Id
    @GeneratedValue(generator = "term_id_generator")
    @GenericGenerator(name = "term_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "TE"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String lastDateTimeVerified;
    
    private String scriptCode;
    
    private String transliteration;
    
    private String vocabularySource;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Term#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Term#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Term#getLastDateTimeVerified()
     */
    @Override
    public String getLastDateTimeVerified() {
        return lastDateTimeVerified;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Term#setLastDateTimeVerified(java.lang.String)
     */
    @Override
    public void setLastDateTimeVerified(String lastDateTimeVerified) {
        this.lastDateTimeVerified = lastDateTimeVerified;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Term#getScriptCode()
     */
    @Override
    public String getScriptCode() {
        return scriptCode;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Term#setScriptCode(java.lang.String)
     */
    @Override
    public void setScriptCode(String scriptCode) {
        this.scriptCode = scriptCode;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Term#getTransliteration()
     */
    @Override
    public String getTransliteration() {
        return transliteration;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Term#setTransliteration(java.lang.String)
     */
    @Override
    public void setTransliteration(String transliteration) {
        this.transliteration = transliteration;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Term#getVocabularySource()
     */
    @Override
    public String getVocabularySource() {
        return vocabularySource;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Term#setVocabularySource(java.lang.String)
     */
    @Override
    public void setVocabularySource(String vocabularySource) {
        this.vocabularySource = vocabularySource;
    }
    
}
