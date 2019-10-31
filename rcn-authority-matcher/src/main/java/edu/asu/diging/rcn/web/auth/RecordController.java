package edu.asu.diging.rcn.web.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.asu.diging.rcn.core.service.IRecordManager;

@Controller
public class RecordController {

    @Autowired
    private IRecordManager recordManager;

    @RequestMapping(value="/auth/datasets/{datasetId}/record/{recordId}")
    public String list(Model model, @PathVariable("recordId") String recordId) {
        model.addAttribute("record", recordManager.get(recordId));
        return "auth/datasets/record";
    }
}
