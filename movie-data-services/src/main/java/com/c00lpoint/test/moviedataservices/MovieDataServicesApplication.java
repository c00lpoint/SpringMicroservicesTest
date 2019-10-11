package com.c00lpoint.test.moviedataservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MovieDataServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieDataServicesApplication.class, args);
	}

}
