package edu.asu.diging.rcn.web.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.asu.diging.rcn.core.service.IDatasetManager;
import edu.asu.diging.rcn.core.service.IRecordManager;

@Controller
public class DatasetController {

    @Autowired
    private IDatasetManager datasetManager;
    
    @Autowired
    private IRecordManager recordManager;
    
    @RequestMapping(value="/auth/datasets/{datasetId}")
    public String get(@PathVariable("datasetId") String datasetId, Model model, Pageable pageable) {
        model.addAttribute("dataset", datasetManager.get(datasetId));
        model.addAttribute("records", recordManager.listRecords(datasetId, pageable));
        model.addAttribute("recordCount", (int) Math.ceil(recordManager.getRecordCount(datasetId)/new Float(pageable.getPageSize())));
        model.addAttribute("currentPage", pageable.getPageNumber());
        return "/auth/datasets/dataset";
    }
}
