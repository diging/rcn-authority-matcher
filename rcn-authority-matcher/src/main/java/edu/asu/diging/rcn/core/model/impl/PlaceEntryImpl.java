package edu.asu.diging.rcn.core.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.PlaceEntry;

@Entity
public class PlaceEntryImpl implements PlaceEntry {

    @Id
    @GeneratedValue(generator = "placeEntry_id_generator")
    @GenericGenerator(name = "placeEntry_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "PE"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String localType;
    
    private String countryCode;
    
    private String latitude;
    
    private String longitude;
    
    private String scriptCode;
    
    private String transliteration;
    
    private String vocabularySource;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceEntry#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceEntry#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceEntry#getLocalType()
     */
    @Override
    public String getLocalType() {
        return localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceEntry#setLocalType(java.lang.String)
     */
    @Override
    public void setLocalType(String localType) {
        this.localType = localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceEntry#getCountryCode()
     */
    @Override
    public String getCountryCode() {
        return countryCode;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceEntry#setCountryCode(java.lang.String)
     */
    @Override
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceEntry#getLatitude()
     */
    @Override
    public String getLatitude() {
        return latitude;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceEntry#setLatitude(java.lang.String)
     */
    @Override
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceEntry#getLongitude()
     */
    @Override
    public String getLongitude() {
        return longitude;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceEntry#setLongitude(java.lang.String)
     */
    @Override
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceEntry#getScriptCode()
     */
    @Override
    public String getScriptCode() {
        return scriptCode;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceEntry#setScriptCode(java.lang.String)
     */
    @Override
    public void setScriptCode(String scriptCode) {
        this.scriptCode = scriptCode;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceEntry#getTransliteration()
     */
    @Override
    public String getTransliteration() {
        return transliteration;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceEntry#setTransliteration(java.lang.String)
     */
    @Override
    public void setTransliteration(String transliteration) {
        this.transliteration = transliteration;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceEntry#getVocabularySource()
     */
    @Override
    public String getVocabularySource() {
        return vocabularySource;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.PlaceEntry#setVocabularySource(java.lang.String)
     */
    @Override
    public void setVocabularySource(String vocabularySource) {
        this.vocabularySource = vocabularySource;
    }
    
}
