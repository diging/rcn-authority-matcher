package edu.asu.diging.rcn.web.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.asu.diging.eaccpf.model.Dataset;
import edu.asu.diging.rcn.core.service.IDatasetManager;

@Controller
public class DatasetController {

    @Autowired
    private IDatasetManager datasetManager;
    
    @RequestMapping(value="/auth/datasets/{datasetId}")
    public String get(@PathVariable("datasetId") String datasetId, Model model) {
        Dataset dataset = datasetManager.getLoaded(datasetId);
        // handle not found
        
        model.addAttribute("dataset", dataset);
        return "/auth/datasets/dataset";
    }
}
