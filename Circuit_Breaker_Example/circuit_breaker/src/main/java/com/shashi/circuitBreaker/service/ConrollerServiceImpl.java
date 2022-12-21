package com.shashi.circuitBreaker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shashi.circuitBreaker.model.User;

@Repository
public class ConrollerServiceImpl implements ControllerService{

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "fallbackMethod", commandKey = "shashibhusan")
	@Override
	public List<User> getAllUser() {
		List<User>  user=restTemplate.getForObject("/users", List.class);
		return user;
	}
	
	//@HystrixCommand(fallbackMethod = "fallbackMethodOfCircuitBreaker")
	@Override
	public String addUser(User user) {
		return restTemplate.postForObject("/register",user,String.class);
	}

	public String fallbackMethodOfCircuitBreaker(User user, Throwable th)
	{
		System.out.println("Invoked fallbackMethodOfCircuitBreaker() "+th.toString());
		return "This is fallbackMethodOfCircuitBreaker()";
	}
	
	public List<User> fallbackMethod(Throwable th)
	{
		List<User> l1=new ArrayList<User>();
		System.out.println("Invoked fallbackMethod() "+th.toString());
		return l1;
	}
}
