package edu.asu.diging.rcn.core.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.asu.diging.eaccpf.data.DatasetRepository;
import edu.asu.diging.eaccpf.model.Dataset;
import edu.asu.diging.eaccpf.model.impl.DatasetImpl;
import edu.asu.diging.rcn.core.service.IDatasetManager;

@Service
@Transactional
public class DatasetManager implements IDatasetManager {

    @Autowired
    private DatasetRepository datasetRepo;
    
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
    public List<Dataset> list() {
        List<Dataset> datasets = new ArrayList<Dataset>();
        datasetRepo.findAll().forEach(datasets::add);
        return datasets;
    }
}
