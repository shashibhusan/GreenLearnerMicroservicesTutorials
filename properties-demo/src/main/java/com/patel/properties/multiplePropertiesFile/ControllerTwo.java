package com.patel.properties.multiplePropertiesFile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTwo {
	
	@Value("${controllerTwo.first.name}")
	private String name;

	@GetMapping("/controllerTwo")
	public String getMessage()
	{
		return "This is controller Two **********"+name;
	}
	
}
