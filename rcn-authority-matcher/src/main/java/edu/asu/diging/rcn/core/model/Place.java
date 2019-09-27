package edu.asu.diging.rcn.core.model;

import java.util.List;

public interface Place {

    String getId();

    void setId(String id);

    String getLocalType();

    void setLocalType(String localType);

    List<Citation> getCitations();

    void setCitations(List<Citation> citations);

    Date getDate();

    void setDate(Date date);

    DateRange getDateRange();

    void setDateRange(DateRange dateRange);

    DateSet getDateSet();

    void setDateSet(DateSet dateSet);

    List<String> getDescriptiveNote();

    void setDescriptiveNote(List<String> descriptiveNote);

    List<Address> getAddresses();

    void setAddresses(List<Address> addresses);

    List<PlaceEntry> getPlaceEntries();

    void setPlaceEntries(List<PlaceEntry> placeEntries);

    List<PlaceRole> getPlaceRoles();

    void setPlaceRoles(List<PlaceRole> placeRoles);

}