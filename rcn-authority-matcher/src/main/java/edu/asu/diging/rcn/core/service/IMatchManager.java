package edu.asu.diging.rcn.core.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import edu.asu.diging.rcn.core.model.match.IMatchResult;


public interface IMatchManager {

    List<IMatchResult> list(String jobId, Pageable pageable);

    int getTotalMatches(String jobId);

}