package edu.asu.diging.rcn.core.model;

import java.util.List;

public interface ExistDates {

    String getId();

    void setId(String id);

    Date getDate();

    void setDate(Date date);

    DateRange getDateRange();

    void setDateRange(DateRange dateRange);

    DateSet getDateSet();

    void setDateSet(DateSet dateSet);

    List<String> getDescriptiveNote();

    void setDescriptiveNote(List<String> descriptiveNote);

}