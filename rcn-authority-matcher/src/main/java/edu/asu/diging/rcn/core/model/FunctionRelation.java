package edu.asu.diging.rcn.core.model;

import java.util.List;

public interface FunctionRelation {

    String getId();

    void setId(String id);

    String getCpfRelationType();

    void setCpfRelationType(String cpfRelationType);

    String getLastDateTimeVerified();

    void setLastDateTimeVerified(String lastDateTimeVerified);

    List<Date> getDate();

    void setDate(List<Date> date);

    List<DateRange> getDateRange();

    void setDateRange(List<DateRange> dateRange);

    List<DateSet> getDateSet();

    void setDateSet(List<DateSet> dateSet);

    List<String> getDescriptiveNote();

    void setDescriptiveNote(List<String> descriptiveNote);

    List<PlaceEntry> getPlaceEntries();

    void setPlaceEntries(List<PlaceEntry> placeEntries);

    List<RelationEntry> getRelationEntries();

    void setRelationEntries(List<RelationEntry> relationEntries);

}