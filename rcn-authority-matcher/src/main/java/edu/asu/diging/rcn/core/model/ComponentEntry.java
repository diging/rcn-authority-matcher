package edu.asu.diging.rcn.core.model;

public interface ComponentEntry {

    String getId();

    void setId(String id);

    String getLocalType();

    void setLocalType(String localType);

    String getScriptCode();

    void setScriptCode(String scriptCode);

    String getText();

    void setText(String text);

    String getTransliteration();

    void setTransliteration(String transliteration);

}