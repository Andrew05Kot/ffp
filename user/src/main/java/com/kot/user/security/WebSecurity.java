package com.kot.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.kot.user.api.backoffice.v1.user.UserV1Controller;

@Configuration
@EnableAutoConfiguration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final FFPUserDetailsService ffpUserDetailsService;
    private final Environment environment;

    @Autowired
    public WebSecurity(FFPUserDetailsService ffpUserDetailsService,
                       BCryptPasswordEncoder bCryptPasswordEncoder,
                       Environment environment) {
        this.ffpUserDetailsService = ffpUserDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.environment = environment;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();

        http
                .authorizeRequests().antMatchers(UserV1Controller.API_URL + "/registration").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(getAuthenticationFilter());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(ffpUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    private AuthenticationFilter getAuthenticationFilter() throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(ffpUserDetailsService, environment, authenticationManager());
        authenticationFilter.setFilterProcessesUrl(environment.getProperty("api.v1.login_url"));
        return authenticationFilter;
    }
}
