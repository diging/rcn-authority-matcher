package edu.asu.diging.rcn.api.v1;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.asu.diging.rcn.core.model.IUploadJob;
import edu.asu.diging.rcn.core.service.IUploadJobManager;

@Controller
public class RetrieveUploadController extends V1Controller {
    
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUploadJobManager jobManager;
    
    
    @RequestMapping(value="/upload/{datasetId}")
    public ResponseEntity<String> get(HttpServletResponse response, @RequestHeader HttpHeaders headers, @PathVariable("datasetId") String datasetId) {
        IUploadJob job = jobManager.findUploadJob(datasetId);
        
        byte[] content = jobManager.getUploadedFile(job);
        if (content == null) {
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode node = mapper.createObjectNode();
            node.put("message", "No content.");
            return new ResponseEntity<String>(node.toString(), HttpStatus.I_AM_A_TEAPOT);
        }
        response.setContentType(job.getContentType());
        response.setContentLength(new Long(job.getFileSize()).intValue());
        response.setHeader("Content-disposition", "filename=\"" + job.getFilename() + "\""); 
        try {
            response.getOutputStream().write(content);
            response.getOutputStream().close();
        } catch (IOException e) {
            logger.error("Could not create repsonse object.", e);
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<String>(HttpStatus.OK);
    }
}