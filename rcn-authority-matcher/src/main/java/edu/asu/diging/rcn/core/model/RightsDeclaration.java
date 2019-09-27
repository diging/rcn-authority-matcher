package edu.asu.diging.rcn.core.model;

import java.util.List;

public interface RightsDeclaration {

    String getId();

    void setId(String id);

    String getLocalType();

    void setLocalType(String localType);

    String getAbbreviation();

    void setAbbreviation(String abbreviation);

    String getCitation();

    void setCitation(String citation);

    List<String> getDescriptiveNote();

    void setDescriptiveNote(List<String> descriptiveNote);

}