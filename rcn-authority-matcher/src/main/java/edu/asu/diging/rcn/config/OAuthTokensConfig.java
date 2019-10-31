package edu.asu.diging.rcn.config;

import org.springframework.context.annotation.Configuration;

import edu.asu.diging.oauth.tokens.config.OAuthTokens;
import edu.asu.diging.oauth.tokens.config.OAuthTokensConfiguration;

@Configuration
public class OAuthTokensConfig implements OAuthTokensConfiguration {

    @Override
    public void configure(OAuthTokens arg0) {
        
    }

}
