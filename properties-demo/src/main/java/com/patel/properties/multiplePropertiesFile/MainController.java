package com.patel.properties.multiplePropertiesFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@Autowired
	private User user;
	
	@Autowired
	private UserConfig config;
	
	@GetMapping("/users")
	public String getUsers()
	{
		System.out.println(user.getSystemProps());
		return user.toString();
	}
	
	@GetMapping("/userConfig")
	public String getUserConfig()
	{
		return config.toString();
	}
}
