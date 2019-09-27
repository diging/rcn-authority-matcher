package edu.asu.diging.rcn.core.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.PlaceRole;

@Entity
public class PlaceRoleImpl implements PlaceRole {

    @Id
    @GeneratedValue(generator = "placeRole_id_generator")
    @GenericGenerator(name = "placeRole_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "PR"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String lastDateTimeVerified;
    
    private String scriptCode;
    
    private String transliteration;
    
    private String vocabularySource;
    
    private String placeRole;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceRole#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceRole#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceRole#getLastDateTimeVerified()
     */
    @Override
    public String getLastDateTimeVerified() {
        return lastDateTimeVerified;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceRole#setLastDateTimeVerified(java.lang.String)
     */
    @Override
    public void setLastDateTimeVerified(String lastDateTimeVerified) {
        this.lastDateTimeVerified = lastDateTimeVerified;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceRole#getScriptCode()
     */
    @Override
    public String getScriptCode() {
        return scriptCode;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceRole#setScriptCode(java.lang.String)
     */
    @Override
    public void setScriptCode(String scriptCode) {
        this.scriptCode = scriptCode;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceRole#getTransliteration()
     */
    @Override
    public String getTransliteration() {
        return transliteration;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceRole#setTransliteration(java.lang.String)
     */
    @Override
    public void setTransliteration(String transliteration) {
        this.transliteration = transliteration;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceRole#getVocabularySource()
     */
    @Override
    public String getVocabularySource() {
        return vocabularySource;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceRole#setVocabularySource(java.lang.String)
     */
    @Override
    public void setVocabularySource(String vocabularySource) {
        this.vocabularySource = vocabularySource;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceRole#getPlaceRole()
     */
    @Override
    public String getPlaceRole() {
        return placeRole;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceRole#setPlaceRole(java.lang.String)
     */
    @Override
    public void setPlaceRole(String placeRole) {
        this.placeRole = placeRole;
    }
}
