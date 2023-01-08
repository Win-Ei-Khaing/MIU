package edu.mum.cs544.Config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("edu.mum.cs544")
@EntityScan("edu.mum.cs544.Domain")
@EnableJpaRepositories("edu.mum.cs544.Repository")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
