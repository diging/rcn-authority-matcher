package edu.asu.diging.rcn.core.model;

import java.util.List;

public interface LanguagesUsed {

    String getId();

    void setId(String id);

    String getLocalType();

    void setLocalType(String localType);

    List<String> getDescriptiveNote();

    void setDescriptiveNote(List<String> descriptiveNote);

    List<LanguageUsed> getLangugesUsed();

    void setLangugesUsed(List<LanguageUsed> langugesUsed);

}