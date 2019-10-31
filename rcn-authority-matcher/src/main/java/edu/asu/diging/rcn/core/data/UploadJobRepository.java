package edu.asu.diging.rcn.core.data;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import edu.asu.diging.rcn.core.model.impl.UploadJob;

public interface UploadJobRepository extends CrudRepository<UploadJob, String> {

    List<UploadJob> findByUsername(String username, Pageable pagable);
}