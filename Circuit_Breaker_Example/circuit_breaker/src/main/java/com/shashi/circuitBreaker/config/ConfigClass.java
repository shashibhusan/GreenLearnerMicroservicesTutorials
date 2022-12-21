package com.shashi.circuitBreaker.config;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplateHandler;

@Configuration
public class ConfigClass {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder)
	{
		UriTemplateHandler handler=new RootUriTemplateHandler("http://localhost:8083/springDataDemo");
		return builder.uriTemplateHandler(handler)
				.setReadTimeout(Duration.ofMillis(3000))
				.build();
	}
	
}