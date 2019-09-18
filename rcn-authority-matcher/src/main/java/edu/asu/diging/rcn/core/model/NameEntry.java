package edu.asu.diging.rcn.core.model;

import java.util.List;

public interface NameEntry {

    String getId();

    void setId(String id);

    String getLocalType();

    void setLocalType(String localType);

    String getScriptCode();

    void setScriptCode(String scriptCode);

    String getTransliteration();

    void setTransliteration(String transliteration);

    String getAlternativeForm();

    void setAlternativeForm(String alternativeForm);

    String getAuthorizedForm();

    void setAuthorizedForm(String authorizedForm);

    String getPreferredForm();

    void setPreferredForm(String preferredForm);

    List<NamePart> getParts();

    void setParts(List<NamePart> parts);

    UseDates getUseDates();

    void setUseDates(UseDates useDates);

}