package com.medical_app.bc_backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckPathController {
	@GetMapping("/")
	String  rootHealthCheck() {
		return "Health Check OK";
	}
	
	@GetMapping("/healthCheck")
	String  healthCheck() {
		return "Health Check OK";
	}
}
