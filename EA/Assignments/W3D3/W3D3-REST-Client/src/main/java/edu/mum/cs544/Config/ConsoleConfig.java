package edu.mum.cs544.Config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("edu.mum.cs544")
public class ConsoleConfig { 
    @Bean
    public RestTemplate getRestTemplate() { 
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(ConsoleConfig.class, args);
    }

} 