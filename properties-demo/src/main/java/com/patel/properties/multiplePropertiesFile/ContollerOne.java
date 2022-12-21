package com.patel.properties.multiplePropertiesFile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContollerOne {
	
	@Value("${controllerOne.first.name}")
	private String name;
	
	@GetMapping("/controllerOne")
	public String getMessage()
	{
		return "This is Controller One===>>>>>> "+name;
	}

}
