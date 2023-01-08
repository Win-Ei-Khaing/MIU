package edu.mum.cs544.Config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableGlobalMethodSecurity(securedEnabled = true)
@ComponentScan({"edu.mum.cs544", "edu.mum.cs544.Config"})
@EntityScan("edu.mum.cs544.Domain")
@EnableJpaRepositories("edu.mum.cs544.Repository")
@EnableAspectJAutoProxy
// @EnableTransactionManagement
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
