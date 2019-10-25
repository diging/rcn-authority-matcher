package edu.asu.diging.rcn.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.asu.diging.eaccpf.data.DatasetRepository;
import edu.asu.diging.eaccpf.model.Dataset;
import edu.asu.diging.eaccpf.model.Record;
import edu.asu.diging.eaccpf.model.impl.DatasetImpl;
import edu.asu.diging.rcn.core.service.IDatasetManager;
import edu.asu.diging.rcn.core.service.IRecordManager;

@Service
@Transactional
public class DatasetManager implements IDatasetManager {

    @Autowired
    private DatasetRepository datasetRepo;
    
    @Autowired
    private IRecordManager recordManager;
     
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.service.impl.IDatasetManager#createDataset(java.lang.String, java.lang.String)
     */
    @Override
    public Dataset create(String title, String description) {
        DatasetImpl dataset = new DatasetImpl();
        dataset.setTitle(title);
        dataset.setDescription(description);
        return datasetRepo.save(dataset);
    }
    
    @Override
    public void remove(String id) {
        Dataset dataset = get(id);
        if (dataset != null) {
            List<Record> records = dataset.getRecords();
            recordManager.delete(records);
        }
    }
    
    @Override
    public Dataset get(String id) {
        Optional<DatasetImpl> dsOptional = datasetRepo.findById(id);
        if (!dsOptional.isPresent()) {
            return null;
        }
        return dsOptional.get();
    }
    
    @Override
    public Dataset getLoaded(String id) {
        Optional<DatasetImpl> dsOptional = datasetRepo.findById(id);
        if (!dsOptional.isPresent()) {
            return null;
        }
        Dataset dataset = dsOptional.get();
        for (Record rd : dataset.getRecords()) {
            rd.getConventionDeclarations().size();
        }
        return dataset;
    }
    
    @Override
    public List<Dataset> list() {
        List<Dataset> datasets = new ArrayList<Dataset>();
        datasetRepo.findAll().forEach(datasets::add);
        return datasets;
    }
}
