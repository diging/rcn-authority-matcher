package edu.asu.diging.rcn.core.model;

import java.util.List;

public interface Function {

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

    List<Citation> getCitations();

    void setCitations(List<Citation> citations);

    PlaceEntry getPlaceEntry();

    void setPlaceEntry(PlaceEntry placeEntry);

    Term getTerm();

    void setTerm(Term term);

}