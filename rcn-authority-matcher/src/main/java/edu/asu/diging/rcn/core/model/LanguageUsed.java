package edu.asu.diging.rcn.core.model;

import java.util.List;

public interface LanguageUsed {

    String getId();

    void setId(String id);

    List<String> getDescriptiveNote();

    void setDescriptiveNote(List<String> descriptiveNote);

    String getLanguage();

    void setLanguage(String language);

    String getLanguageCode();

    void setLanguageCode(String languageCode);

    String getScript();

    void setScript(String script);

    String getScriptCode();

    void setScriptCode(String scriptCode);

}