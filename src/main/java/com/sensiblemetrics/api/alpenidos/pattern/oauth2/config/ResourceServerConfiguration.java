package com.sensiblemetrics.api.alpenidos.pattern.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(final ResourceServerSecurityConfigurer resources) {
        resources.resourceId("api-resource");
    }

    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/api/v{[0-9]+}/user").hasRole("USER")
            .anyRequest().authenticated()
        ;
    }
}
