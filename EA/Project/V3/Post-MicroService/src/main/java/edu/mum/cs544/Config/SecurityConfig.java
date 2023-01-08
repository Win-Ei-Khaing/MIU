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
        auth.inMemoryAuthentication()
                .withUser("admin").password("{bcrypt}$2a$10$sW0aZaPvRA/zMaezswOlLevc4vYXIRTYhafMeRI145.GwXzxPM2FC").roles("ADMIN","BLOGGER","USER").and() //Group12Admin
                .withUser("blogger").password("{bcrypt}$2a$10$9xeiOqcnP3hQO/1wn7zW2OE9KOGmbClfHuIJpiM6H0aPCAjS8uOv2").roles("BLOGGER").and() //Group12User
                .withUser("user").password("{bcrypt}$2a$10$aj.m2BCgkuNg73HGXprVJ.PMmFM21.qXBbOFbu0b3QEF/SEliMxPi").roles("USER"); //Group12Blogger
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