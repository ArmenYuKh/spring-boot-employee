package com.springboot.demo.springbootdemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("employee1")
                .password("1")
                .roles("EMPLOYEE")
                .and()
                .withUser("employee2")
                .password("2")
                .roles("EMPLOYEE")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN")
                .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers("/rest/**")
                .access("hasAnyRole('ADMIN')")
                .mvcMatchers("/employee/**")
                .access("hasAnyRole('EMPLOYEE', 'ADMIN')")
                .antMatchers("/templates/**")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureForwardUrl("/login?error=true")
                .defaultSuccessUrl("/", false)
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout();
    }
}
