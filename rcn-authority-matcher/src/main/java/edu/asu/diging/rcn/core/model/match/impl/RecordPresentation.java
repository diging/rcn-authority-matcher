package edu.asu.diging.rcn.core.model.match.impl;

import java.util.List;

import edu.asu.diging.eaccpf.model.NameEntry;
import edu.asu.diging.eaccpf.model.Record;
import edu.asu.diging.rcn.core.model.match.IRecordPresentation;

public class RecordPresentation implements IRecordPresentation {

    private Record record;
    private List<NameEntry> nameEntries;
    private List<String> names;
    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.match.impl.IRecordPresentation#getRecord()
     */
    @Override
    public Record getRecord() {
        return record;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.match.impl.IRecordPresentation#setRecord(edu.asu.diging.eaccpf.model.Record)
     */
    @Override
    public void setRecord(Record record) {
        this.record = record;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.match.impl.IRecordPresentation#getNameEntries()
     */
    @Override
    public List<NameEntry> getNameEntries() {
        return nameEntries;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.match.impl.IRecordPresentation#setNameEntries(java.util.List)
     */
    @Override
    public void setNameEntries(List<NameEntry> nameEntries) {
        this.nameEntries = nameEntries;
    }
    @Override
    public List<String> getNames() {
        return names;
    }
    @Override
    public void setNames(List<String> names) {
        this.names = names;
    }
    
    
    
    
}
