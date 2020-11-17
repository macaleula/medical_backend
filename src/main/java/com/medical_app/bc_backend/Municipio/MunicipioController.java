package com.medical_app.bc_backend.Municipio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MunicipioController {
	@Autowired
	private MunicipioService service;
	@GetMapping("/municipio")
	List<Municipio> all() {
		return service.all();
	}

	@PostMapping("/municipio")
	Municipio newMunicipio(@RequestBody Municipio newMunicipio) {
		return service.newMunicipio(newMunicipio);
	}

	// Single item

	@GetMapping("/municipio/{id}")
	Municipio one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/municipio/{id}")
	Municipio replaceMunicipio(@RequestBody Municipio newMunicipio, @PathVariable Integer id) {
		return service.replaceMunicipio(newMunicipio,id);
	}

	@DeleteMapping("/municipio/{id}")
	void deleteMunicipio(@PathVariable Integer id) {
		service.deleteMunicipio(id);
	}
}