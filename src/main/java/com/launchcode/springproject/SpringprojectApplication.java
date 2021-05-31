package com.launchcode.springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

// Entry class for spring boot
@SpringBootApplication
@EnableConfigurationProperties(WeatherProperties.class)
public class SpringprojectApplication {
	/**
	 * the main method
	 *
	 * @param args the arguments
	 */

	public static void main(String[] args) {
		SpringApplication.run(SpringprojectApplication.class, args);
	}

}

