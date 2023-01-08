package miu.edu.lab03post;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyFirstSpringProjectApplication {

    @Bean
    public ModelMapper moduleMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(MyFirstSpringProjectApplication.class, args);
    }

}
