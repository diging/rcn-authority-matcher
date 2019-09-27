package edu.asu.diging.rcn.core.model;

import java.util.List;

public interface SetComponent {

    String getId();

    void setId(String id);

    String getLastDateTimeVerified();

    void setLastDateTimeVerified(String lastDateTimeVerified);

    String getXlinkHref();

    void setXlinkHref(String xlinkHref);

    List<String> getDescriptiveNote();

    void setDescriptiveNote(List<String> descriptiveNote);

    List<ComponentEntry> getComponentEntries();

    void setComponentEntries(List<ComponentEntry> componentEntries);

}