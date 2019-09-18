package edu.asu.diging.rcn.core.model;

import java.util.List;

public interface DateSet {

    String getId();

    void setId(String id);

    String getLocalType();

    void setLocalType(String localType);

    List<Date> getDates();

    void setDates(List<Date> dates);

    List<DateRange> getDateRanges();

    void setDateRanges(List<DateRange> dateRanges);

}