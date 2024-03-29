package com.shashi.circuitBreaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shashi.circuitBreaker.model.User;
import com.shashi.circuitBreaker.service.ControllerService;

@RestController
public class MainController {
	
	@Autowired
	private ControllerService controllerService;
	
	@GetMapping("/users")
	List<User>getUserList()
	{
		return controllerService.getAllUser();
	}
	
	@PostMapping("/user")
	String addUser(@RequestBody User user)
	{
		return controllerService.addUser(user);
	}

}
