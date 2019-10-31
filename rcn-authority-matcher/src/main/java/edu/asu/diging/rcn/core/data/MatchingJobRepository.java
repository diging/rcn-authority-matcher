package edu.asu.diging.rcn.core.data;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import edu.asu.diging.rcn.core.model.impl.MatchingJob;

public interface MatchingJobRepository extends CrudRepository<MatchingJob, String> {

    List<MatchingJob> findByBaseDatasetId(String baseDatasetId, Pageable pageable);
    List<MatchingJob> findByCompareDatasetId(String compareDatasetId, Pageable pageable);
    List<MatchingJob> findDistinctByBaseDatasetIdOrCompareDatasetIdOrderByCreatedOn(String baseDatasetId, String compareDatasetId, Pageable pageable);
}
