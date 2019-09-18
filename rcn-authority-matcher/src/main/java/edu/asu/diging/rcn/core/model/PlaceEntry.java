package edu.asu.diging.rcn.core.model;

public interface PlaceEntry {

    String getId();

    void setId(String id);

    String getLocalType();

    void setLocalType(String localType);

    String getCountryCode();

    void setCountryCode(String countryCode);

    String getLatitude();

    void setLatitude(String latitude);

    String getLongitude();

    void setLongitude(String longitude);

    String getScriptCode();

    void setScriptCode(String scriptCode);

    String getTransliteration();

    void setTransliteration(String transliteration);

    String getVocabularySource();

    void setVocabularySource(String vocabularySource);

}