package edu.asu.diging.rcn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
@EnableAspectJAutoProxy
@ComponentScan({"edu.asu.diging.rcn", "edu.asu.diging.simpleusers", "edu.asu.diging.oauth.tokens"})
public class MatcherConfig {
    
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename("classpath:locale/messages");
        source.setFallbackToSystemLocale(false);
        return source;
    }
    
}

