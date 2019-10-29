package edu.asu.diging.rcn.web.auth.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.asu.diging.rcn.core.model.IMatchingJob;
import edu.asu.diging.rcn.core.service.IDatasetManager;
import edu.asu.diging.rcn.core.service.IMatchManager;
import edu.asu.diging.rcn.core.service.IMatchingManager;

@Controller
public class MatchListController {

    @Autowired
    private IMatchManager matchManager;
    
    @Autowired
    private IMatchingManager jobManager;
    
    @Autowired
    private IDatasetManager datasetManager;
    
    @RequestMapping("/auth/datasets/{datasetId}/jobs/matching/{jobId}")
    public String list(Model model, @PathVariable String datasetId, @PathVariable String jobId, Pageable pageable) {
        model.addAttribute("matches", matchManager.list(jobId, pageable));
        model.addAttribute("totalPages", (int) Math.ceil(matchManager.getTotalMatches(jobId)/new Float(pageable.getPageSize())));
        model.addAttribute("totalResults", matchManager.getTotalMatches(jobId));
        model.addAttribute("currentPage", pageable.getPageNumber());
        model.addAttribute("dataset", datasetManager.get(datasetId));
        IMatchingJob job = jobManager.get(jobId);
        model.addAttribute("compareTo", job.getCompareDataset());
        model.addAttribute("job", job);
        return "/auth/datasets/jobs/job";
    }
}
