package com.patel.ProfileDemoApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

	@Autowired
	private EnvDetails details;
	
	@Bean
	@Profile("dev")
	public EnvDetails devEnv()
	{
		System.out.println("Dev Environment is in used");
		System.out.println(details);
		return details;
	}
	
	@Bean
	@Profile("test")	
	public EnvDetails testEnv()
	{
		System.out.println("Test Environment is in used");
		System.out.println(details);
		return details;
	}
	
	@Bean
	@Profile("prod")	
	public EnvDetails prodEnv()
	{
		System.out.println("Prod Environment is in used");
		System.out.println(details);
		return details;
	}
}
