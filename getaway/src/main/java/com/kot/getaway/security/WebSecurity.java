package com.kot.getaway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebSecurity
@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private final Environment environment;
    private AuthorizationFilter authorizationFilter;

    @Autowired
    public WebSecurity(Environment environment) throws Exception {
        this.environment = environment;
    }

    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) throws Exception {
        http.csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeExchange()
                .pathMatchers(environment.getProperty("api.h2-console.url.path")).permitAll()
                .pathMatchers(HttpMethod.POST, environment.getProperty("api.registration.url.path")).permitAll()
                .pathMatchers(HttpMethod.POST, environment.getProperty("api.login.url.path")).permitAll()
                .anyExchange().authenticated()
                .and()
                .addFilterAt(new AuthorizationFilter(environment), SecurityWebFiltersOrder.AUTHORIZATION);

        return http.build();
    }
}
