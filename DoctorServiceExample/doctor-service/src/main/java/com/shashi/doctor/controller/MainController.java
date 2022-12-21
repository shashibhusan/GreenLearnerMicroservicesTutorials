package com.shashi.doctor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping("/doctors")
	public String getDoctorDetails()
	{
		return "This is Doctors service";
	}
	
}
