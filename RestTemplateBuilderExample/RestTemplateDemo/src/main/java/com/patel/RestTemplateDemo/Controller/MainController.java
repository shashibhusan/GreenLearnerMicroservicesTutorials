package com.patel.RestTemplateDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/users")
	List<User> getUserList()
	{
		return restTemplate.getForObject("/users", List.class);
	}
}