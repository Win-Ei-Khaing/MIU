package edu.mum.cs544.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.eraseCredentials(false);
        auth.inMemoryAuthentication()
                .withUser("admin").password("{bcrypt}$2a$10$xSIpayOzYUJUA8IBn9rtVedhKgCn9tTdZaeIRKz5NBtNTMYh3uErq").roles("ADMIN","BLOGGER","USER").and() //123
                .withUser("blogger").password("{bcrypt}$2a$10$xSIpayOzYUJUA8IBn9rtVedhKgCn9tTdZaeIRKz5NBtNTMYh3uErq").roles("BLOGGER").and() //123
                .withUser("user").password("{bcrypt}$2a$10$xSIpayOzYUJUA8IBn9rtVedhKgCn9tTdZaeIRKz5NBtNTMYh3uErq").roles("USER"); //123
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
        .csrf().disable()
        .authorizeRequests().anyRequest().authenticated()
        .and()
        .httpBasic();
    }
}