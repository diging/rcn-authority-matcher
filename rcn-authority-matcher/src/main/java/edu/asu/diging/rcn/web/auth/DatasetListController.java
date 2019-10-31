package edu.asu.diging.rcn.web.auth;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.asu.diging.rcn.core.service.IDatasetManager;

@Controller
public class DatasetListController {
    
    @Autowired
    private IDatasetManager datasetManager;

    @RequestMapping(value="/auth/datasets")
    public String list(Model model, Principal principal, Pageable pageable) {
        model.addAttribute("datasets", datasetManager.list());
        return "auth/datasets/list";
    }
}
