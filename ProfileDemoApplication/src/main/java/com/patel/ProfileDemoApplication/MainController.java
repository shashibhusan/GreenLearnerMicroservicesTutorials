package com.patel.ProfileDemoApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	Logger log=LoggerFactory.getLogger("Profile Demo Application ");
	
	@GetMapping("/logging")
	public void getLogging()
	{
		log.trace("Trace logging");
		log.debug("Debug logging");
		log.info("Info logging");
		log.warn("Warning logging");
		log.error("Error Logging");
	}

}
