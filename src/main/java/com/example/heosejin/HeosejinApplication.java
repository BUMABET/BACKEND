package com.example.heosejin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableFeignClients
public class HeosejinApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeosejinApplication.class, args);
	}

}
