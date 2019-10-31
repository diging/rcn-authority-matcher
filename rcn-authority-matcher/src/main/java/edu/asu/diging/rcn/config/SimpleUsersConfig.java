package edu.asu.diging.rcn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import edu.asu.diging.simpleusers.core.config.SimpleUsers;
import edu.asu.diging.simpleusers.core.config.SimpleUsersConfiguration;

@Configuration
@PropertySource("classpath:/config.properties")
public class SimpleUsersConfig implements SimpleUsersConfiguration {

    @Value("${email.user}")
    private String emailUser;

    @Value("${email.password}")
    private String emailPassword;

    @Value("${email.host}")
    private String emailHost;

    @Value("${email.port}")
    private String emailPort;

    @Value("${email.from}")
    private String emailFrom;

    @Value("${app_url}")
    private String appUrl;

    @Override
    public void configure(SimpleUsers simpleUsers) {
        simpleUsers.emailUsername(emailUser).emailPassword(emailPassword).emailServerHost(emailHost)
                .emailServerPort(emailPort).emailFrom(emailFrom).instanceUrl(appUrl);
    }
}
