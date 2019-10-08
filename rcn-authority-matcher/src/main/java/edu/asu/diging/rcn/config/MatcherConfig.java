package edu.asu.diging.rcn.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan({"edu.asu.diging.rcn", "edu.asu.diging.simpleusers", "edu.asu.diging.oauth.tokens"})
public class MatcherConfig {
    
    @Autowired
    private ListableBeanFactory beanFactory;
    
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename("classpath:locale/messages");
        source.setFallbackToSystemLocale(false);
        return source;
    }
    
    @Bean 
    public SimpleUrlHandlerMapping mergingHandler() {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        for (String name : beanFactory.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        return mapping;
    }
}

