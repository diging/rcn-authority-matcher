package edu.asu.diging.rcn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

import edu.asu.diging.oauth.tokens.core.data.OAuthClientRepository;
import edu.asu.diging.oauth.tokens.core.service.IOAuthClientManager;
import edu.asu.diging.oauth.tokens.core.service.impl.OAuthClientManager;

@EnableWebSecurity
public class SecurityContext extends WebSecurityConfigurerAdapter {
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
        // Spring Security ignores request to static resources such as CSS or JS
        // files.
        .ignoring().antMatchers("/static/**");
    }
    
    @Configuration
    @EnableAuthorizationServer
    @PropertySource("classpath:/config.properties")
    public static class OAuth2Configuration extends AuthorizationServerConfigurerAdapter {

        @Value("${_oauth_token_validity}")
        private int oauthTokenValidity;

        @Autowired
        private AuthenticationManager authenticationManager;
        
        @Autowired 
        private OAuthClientRepository clientRepo;
        
        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder;
        
        @Autowired
        @Qualifier("OAuthClientDetailsService")
        private ClientDetailsService clientDetailsService;
        
        @Bean
        public TokenStore tokenStore() {
            return new InMemoryTokenStore();
        }

        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable().authorizeRequests().antMatchers("/oauth/token").permitAll().anyRequest()
                    .authenticated();
        }

        @Override
        public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
            configurer.withClientDetails(clientDetailsService);
        }
        
        @Bean
        public IOAuthClientManager oauthClientManager() {
            return new OAuthClientManager(clientRepo, bCryptPasswordEncoder, oauthTokenValidity);
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints
                    .pathMapping("/oauth/authorize", "/api/v1/oauth/authorize")
                    .pathMapping("/oauth/check_token", "/api/v1/oauth/check_token")
                    .pathMapping("/oauth/confirm_access", "/api/v1/oauth/confirm_access")
                    .pathMapping("/oauth/error", "/api/v1/oauth/error")
                    .pathMapping("/oauth/token", "/api/v1/oauth/token").tokenStore(tokenStore())
                    .authenticationManager(authenticationManager);
        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
            oauthServer.tokenKeyAccess("isAnonymous() || hasAuthority('ROLE_TRUSTED_CLIENT')")
                    .checkTokenAccess("hasAuthority('ROLE_TRUSTED_CLIENT')").allowFormAuthenticationForClients();
        }

    }

    @Configuration
    @Order(1)
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().requireCsrfProtectionMatcher(new CsrfSecurityRequestMatcher()).and().formLogin()
                    // Configures the logout function
                    .and().logout().deleteCookies("JSESSIONID").and()
                    .exceptionHandling().accessDeniedPage("/403")
                    .and().requestMatchers().requestMatchers(new NegatedRequestMatcher(
                                new OrRequestMatcher(
                                        new AntPathRequestMatcher("/api/**")
                                )
                        ))
                    // Configures url based authorization
                    .and()
                    .authorizeRequests()
                    // Anyone can access the urls
                    .antMatchers("/", "/resources/**",
                           "/register").permitAll()
                    // The rest of the our application is protected.
                    .antMatchers("/users/**", "/admin/**").hasRole("ADMIN")
                    .antMatchers("/auth/**").hasAnyRole("USER", "ADMIN")
                    .anyRequest().hasRole("USER");
        }

        public AuthenticationFailureHandler customAuthenticationFailureHandler(String defaultFailureUrl) {
            return new CustomAuthenticationFailureHandler(defaultFailureUrl);
        }
        
    }

    @Configuration
    @EnableResourceServer
    @Order(2)
    public static class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {

        private static final String RESOURCE_ID = "my_rest_api";
        
        @Autowired
        private TokenStore tokenStore;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources.tokenStore(tokenStore).resourceId(RESOURCE_ID).stateless(false);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.csrf().disable().authorizeRequests().antMatchers("/api/**").authenticated().and()
                .exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
        }

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    } 

}