package com.medical_app.bc_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.medical_app.bc_backend")
public class MedicalAppWebApplication extends SpringBootServletInitializer { // AWS

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MedicalAppWebApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MedicalAppWebApplication.class, args);
	}

}
