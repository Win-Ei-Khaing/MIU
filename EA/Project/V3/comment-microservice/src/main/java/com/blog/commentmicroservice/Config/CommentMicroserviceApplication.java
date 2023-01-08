package com.blog.commentmicroservice.Config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.blog.commentmicroservice")
@EntityScan("com.blog.commentmicroservice.Domain")
@EnableJpaRepositories("com.blog.commentmicroservice.Repository")	
public class CommentMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentMicroserviceApplication.class, args);
	}

}
