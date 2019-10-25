package edu.asu.diging.rcn.web.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.asu.diging.rcn.core.exceptions.MessageCreationException;
import edu.asu.diging.rcn.core.service.IDatasetManager;
import edu.asu.diging.rcn.core.service.IMatchingManager;
import edu.asu.diging.rcn.web.auth.forms.MatchDatasetsForm;
import edu.asu.diging.simpleusers.core.model.IUser;

@Controller
public class MatchDatasetsController {

    @Autowired
    private IDatasetManager datasetManager;
    
    @Autowired
    private IMatchingManager matchingManager;

    @RequestMapping(value="/auth/datasets/match")
    public String show(Model model) {
        model.addAttribute("datasets", datasetManager.list());
        model.addAttribute("matchForm", new MatchDatasetsForm());
        
        return "/auth/datasets/match";
    }
    
    @RequestMapping(value="/auth/datasets/match", method=RequestMethod.POST)
    public String match(MatchDatasetsForm matchForm, Authentication authentication, RedirectAttributes redirectAttrs) throws MessageCreationException {
        matchingManager.startMatching(matchForm.getBaseDataset(), matchForm.getCompareDataset(), (IUser)authentication.getPrincipal());
        
        redirectAttrs.addFlashAttribute("show_alert", true);
        redirectAttrs.addFlashAttribute("alert_type", "success");
        redirectAttrs.addFlashAttribute("alert_msg", "Datasets have been queued for matching.");
        
        return "redirect:/auth/datasets";
    }
}
