package edu.asu.diging.rcn.core.model.match;

import java.util.List;

import edu.asu.diging.eaccpf.model.NameEntry;
import edu.asu.diging.eaccpf.model.Record;

public interface IRecordPresentation {

    Record getRecord();

    void setRecord(Record record);

    List<NameEntry> getNameEntries();

    void setNameEntries(List<NameEntry> nameEntries);

    void setNames(List<String> name);

    List<String> getNames();

}