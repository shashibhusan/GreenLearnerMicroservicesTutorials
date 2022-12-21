package com.patel.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource(value={"classpath:controllerOne.properties"}, ignoreResourceNotFound = true)
@PropertySource(value={"classpath:controllerTwo.properties"}, ignoreResourceNotFound = true)
public class PropertiesDemoApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "myapp");
		SpringApplication.run(PropertiesDemoApplication.class, args);
	}

}
