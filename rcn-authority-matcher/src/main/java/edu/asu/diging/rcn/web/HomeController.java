package edu.asu.diging.rcn.web;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.asu.diging.oauth.tokens.core.service.IOAuthClientManager;

@Controller
public class HomeController {
    
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private IOAuthClientManager manager;
    
    @PostConstruct
    public void init() {
        logger.debug("--------------------> " + manager + " " + manager.getClass());
    }

    @RequestMapping(value = "/")
    public String home(Model model) {
        return "home";
    }
}
