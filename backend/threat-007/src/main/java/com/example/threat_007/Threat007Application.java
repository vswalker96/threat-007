package com.example.threat_007;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Threat007Application {

	public static void main(String[] args) {
		SpringApplication.run(Threat007Application.class, args);
	}

}
