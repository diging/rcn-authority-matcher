package edu.asu.diging.rcn.web.auth.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.asu.diging.rcn.core.service.IDatasetManager;
import edu.asu.diging.rcn.core.service.IMatchingManager;

@Controller
public class MatchingJobListController {

    @Autowired
    private IMatchingManager matchingManager;
    
    @Autowired
    private IDatasetManager datasetManager;
    
    @RequestMapping("/auth/datasets/{datasetId}/jobs/matching")
    public String list(Model model, @PathVariable String datasetId, Pageable pageable) {
        model.addAttribute("matchingJobs", matchingManager.listMatchingJobs(datasetId, pageable));
        model.addAttribute("dataset", datasetManager.get(datasetId));
        return "/auth/datasets/jobs/matching";
    }
}
