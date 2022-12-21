package com.shashi.patient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@GetMapping("/patients")
	public String getPatientDetail()
	{
		return "This is Patient Service";
	}

}
