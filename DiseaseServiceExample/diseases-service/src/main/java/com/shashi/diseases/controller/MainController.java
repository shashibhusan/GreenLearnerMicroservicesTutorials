package com.shashi.diseases.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@GetMapping("/diseases")
	public String getDiseasesDetails()
	{
		return "This is Diseases service";
	}

	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="No such Book")
	@GetMapping("/diseases/{id}")
	public String Test(@PathVariable("id") int employeeId)
	{
		return "Just for testing";
	}
	 
}
