package com.c00lpoint.test.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class MovieCatalogServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServicesApplication.class, args);
	}

}
