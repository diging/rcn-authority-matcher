package edu.asu.diging.rcn.core.model;

import java.util.List;

public interface Source {

    String getId();

    void setId(String id);

    List<String> getSourceEntries();

    void setSourceEntries(List<String> sourceEntries);

}