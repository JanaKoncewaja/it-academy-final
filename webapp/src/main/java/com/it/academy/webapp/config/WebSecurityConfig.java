package com.it.academy.webapp.config;

import com.it.academy.service.user.UserService;
import com.it.academy.webapp.security.SpringAuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    @Autowired
    public WebSecurityConfig(UserService userService) {
        this.userService = userService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(
                        "/",
                        "/home",
                        "/search",
                        "/catalogPage",
                        "/catalogOfLightOnSensorsPage*",
                        "/catalogOfTemperatureSensorsPage*").permitAll()
                .antMatchers("/addDevice").hasRole("ADMIN")
                .and()
                .formLogin().defaultSuccessUrl("/home",true).permitAll()
        .and()
        .csrf().disable();

    }


    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new SpringAuthUserService(userService);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService());
    }

}
