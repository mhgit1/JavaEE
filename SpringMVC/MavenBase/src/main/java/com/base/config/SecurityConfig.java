/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@ComponentScan("com.base.service")
@EnableWebSecurity

/**
 *
 * @author Ohjelmistokehitys
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    @Qualifier(value="userDetailsService")
    UserDetailsService userDetailsService;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
            //http.headers().cacheControl().disable();
            //http.headers().defaultsDisabled();
            System.out.println("CONFIGURE HTTPSECURITY");
            http.authorizeRequests().antMatchers("/").permitAll()
            .antMatchers("/second").access("hasRole('ROLE_ADMIN')")
            .antMatchers("/teacher").access("hasRole('ADMIN') and hasRole('DBA')")
            .and().formLogin()
            .defaultSuccessUrl("/second")
            .loginPage("/login").failureUrl("/login?error")
            .usernameParameter("username")
            .passwordParameter("password").and()
            .logout().logoutSuccessUrl("/login?logout")
            .and().csrf()
            .and().exceptionHandling().accessDeniedPage("/403");
    }

}
