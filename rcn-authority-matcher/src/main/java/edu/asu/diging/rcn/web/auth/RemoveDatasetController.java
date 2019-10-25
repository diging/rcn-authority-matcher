package edu.asu.diging.rcn.web.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.asu.diging.rcn.core.service.IDatasetManager;

@Controller
public class RemoveDatasetController {

    @Autowired
    private IDatasetManager datasetManager;
    
    @RequestMapping(value="/auth/datasets/{datasetId}", method=RequestMethod.DELETE)
    public String get(@PathVariable("datasetId") String datasetId, Model model) {
        datasetManager.remove(datasetId);
        
        return "redirect:/auth/datasets/";
    }
}
