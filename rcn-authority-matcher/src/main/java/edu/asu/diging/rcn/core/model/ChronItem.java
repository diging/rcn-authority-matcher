package edu.asu.diging.rcn.core.model;

public interface ChronItem {

    String getId();

    void setId(String id);

    Date getDate();

    void setDate(Date date);

    DateRange getDateRange();

    void setDateRange(DateRange dateRange);

    String getEvent();

    void setEvent(String event);

    String getPlaceEntry();

    void setPlaceEntry(String placeEntry);

    void setLocalType(String localType);

    String getLocalType();

}