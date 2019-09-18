package edu.asu.diging.rcn.core.model;

public interface DateRange {

    String getId();

    void setId(String id);

    String getFromDate();

    void setFromDate(String fromDate);

    String getToDate();

    void setToDate(String toDate);

    void setLocalType(String localType);

    String getLocalType();

}