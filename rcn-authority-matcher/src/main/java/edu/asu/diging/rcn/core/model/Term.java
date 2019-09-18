package edu.asu.diging.rcn.core.model;

public interface Term {

    String getId();

    void setId(String id);

    String getLastDateTimeVerified();

    void setLastDateTimeVerified(String lastDateTimeVerified);

    String getScriptCode();

    void setScriptCode(String scriptCode);

    String getTransliteration();

    void setTransliteration(String transliteration);

    String getVocabularySource();

    void setVocabularySource(String vocabularySource);

}