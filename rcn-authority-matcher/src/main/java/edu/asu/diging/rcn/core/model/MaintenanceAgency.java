package edu.asu.diging.rcn.core.model;

import edu.asu.diging.rcn.core.model.impl.RecordImpl;

public interface MaintenanceAgency {

    String getId();

    void setId(String id);

    String getName();

    void setName(String name);

    String getCode();

    void setCode(String code);

    String getDescriptiveNote();

    void setDescriptiveNote(String descriptiveNote);

    RecordImpl getRecord();

    void setRecord(RecordImpl record);

}