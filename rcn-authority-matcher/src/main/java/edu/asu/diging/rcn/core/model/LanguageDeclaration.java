package edu.asu.diging.rcn.core.model;

import edu.asu.diging.rcn.core.model.impl.RecordImpl;

public interface LanguageDeclaration {

    String getId();

    void setId(String id);

    String getLanguage();

    void setLanguage(String language);

    String getLanguageCode();

    void setLanguageCode(String languageCode);

    String getScript();

    void setScript(String script);

    String getScriptCode();

    void setScriptCode(String scriptCode);

    RecordImpl getRecord();

    void setRecord(RecordImpl record);

}