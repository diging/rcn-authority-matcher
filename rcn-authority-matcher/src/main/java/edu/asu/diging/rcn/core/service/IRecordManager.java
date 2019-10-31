package edu.asu.diging.rcn.core.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import edu.asu.diging.eaccpf.model.Record;

public interface IRecordManager {

    Record get(String id);

    void delete(List<Record> records);

    List<Record> listRecords(String datasetId, Pageable pageable);

    long getRecordCount(String datasetId);

}