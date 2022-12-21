package com.patel.HospitalApiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class HospitalApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApiGatewayApplication.class, args);
	}

}
