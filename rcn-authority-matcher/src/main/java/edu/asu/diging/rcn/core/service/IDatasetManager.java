package edu.asu.diging.rcn.core.service;

import java.util.List;

import edu.asu.diging.eaccpf.model.Dataset;

public interface IDatasetManager {

    Dataset create(String title, String description);

    List<Dataset> list();

    Dataset get(String id);

    Dataset getLoaded(String id);

}