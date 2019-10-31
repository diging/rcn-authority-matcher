package edu.asu.diging.rcn.web.auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.asu.diging.rcn.core.exceptions.DatasetNotFoundException;
import edu.asu.diging.rcn.core.model.IUploadJob;
import edu.asu.diging.rcn.core.model.JobStatus;
import edu.asu.diging.rcn.core.model.impl.UploadJob;
import edu.asu.diging.rcn.core.service.IDatasetManager;
import edu.asu.diging.rcn.core.service.IUploadJobManager;
import edu.asu.diging.simpleusers.core.model.IUser;

@Controller
public class UploadDSContentController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private IUploadJobManager jobManager;

    @Autowired
    private IDatasetManager datasetManager;
    
    @RequestMapping(value = "/auth/dscontent/upload", method = RequestMethod.GET)
    public String show(Model model, Authentication authentication) {
        model.addAttribute("datasets", datasetManager.list());
        return "auth/dscontent/upload";
    }

    @RequestMapping(value = "/auth/dscontent/upload", method = RequestMethod.POST)
    public ResponseEntity<String> uploadFiles(Authentication authentication, @RequestParam("dataset") String dataset,
            @RequestParam("files") MultipartFile[] files) {

        IUser user = (IUser) authentication.getPrincipal();
        
        List<byte[]> fileBytes = new ArrayList<>();
        for (MultipartFile file : files) {
            try {
                fileBytes.add(file.getBytes());
            } catch (IOException e) {
                logger.error("Could not get file content from request.", e);
                fileBytes.add(null);
            }
        }
        
        List<IUploadJob> jobs = new ArrayList<>();
        for (int i = 0; i<files.length; i++) {
            try {
                jobs.add(jobManager.createUploadJob(user, dataset, files[i], fileBytes.get(i)));
            } catch (DatasetNotFoundException e) {
                logger.error("Could not create upload job.", e);
                IUploadJob job = new UploadJob();
                job.setStatus(JobStatus.FAILURE);
                jobs.add(job);
            }
        }
        
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();
        ArrayNode filesNode = root.putArray("jobs");
        for (IUploadJob job : jobs) {
            ObjectNode jobNode = mapper.createObjectNode();
            jobNode.put("jobId", job.getId());
            jobNode.put("filename", job.getFilename());
            jobNode.put("status", job.getStatus().name());
            filesNode.add(jobNode);
        }
        return new ResponseEntity<String>(root.toString(), HttpStatus.OK);
    }

}