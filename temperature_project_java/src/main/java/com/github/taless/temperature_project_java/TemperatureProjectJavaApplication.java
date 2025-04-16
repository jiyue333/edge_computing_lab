package com.github.taless.temperature_project_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TemperatureProjectJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemperatureProjectJavaApplication.class, args);
	}

}
