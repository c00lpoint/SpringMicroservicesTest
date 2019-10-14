package com.c00lpoint.test.ratingdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RatingDataServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingDataServicesApplication.class, args);
	}

}
