package edu.asu.diging.rcn.core.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import edu.asu.diging.eaccpf.model.Dataset;

public interface IDatasetManager {

    Dataset create(String title, String description, String creator);

    List<Dataset> list();

    Dataset get(String id);

    Dataset getLoaded(String id);

    void remove(String id);

    List<Dataset> list(String username, Pageable pagable);

}