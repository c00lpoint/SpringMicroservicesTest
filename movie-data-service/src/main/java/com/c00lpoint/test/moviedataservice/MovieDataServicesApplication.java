package com.c00lpoint.test.moviedataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MovieDataServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieDataServicesApplication.class, args);
	}

}
