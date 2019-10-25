package edu.asu.diging.rcn.core.service;

import java.util.List;

import edu.asu.diging.eaccpf.model.Record;

public interface IRecordManager {

    Record get(String id);

    void delete(List<Record> records);

}