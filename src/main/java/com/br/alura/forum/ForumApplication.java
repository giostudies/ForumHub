package com.br.alura.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.br.alura.forum.repository")
public class ForumApplication {
	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}
}
