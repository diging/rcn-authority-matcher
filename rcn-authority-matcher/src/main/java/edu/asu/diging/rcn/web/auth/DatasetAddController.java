package edu.asu.diging.rcn.web.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.asu.diging.rcn.core.service.IDatasetManager;
import edu.asu.diging.rcn.web.auth.forms.DatasetForm;

@Controller
public class DatasetAddController {

    @Autowired
    private IDatasetManager datasetManager;

    @RequestMapping(value="/auth/datasets/add", method=RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute("datasetForm", new DatasetForm());
        return "auth/datasets/add";
    }
    
    @RequestMapping(value="/auth/datasets/add", method=RequestMethod.POST)
    public String post(DatasetForm form) {
        datasetManager.create(form.getName(), form.getDescription());
        return "redirect:/auth/datasets";
    }
}
