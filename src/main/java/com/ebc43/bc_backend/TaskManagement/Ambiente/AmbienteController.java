package com.ebc43.bc_backend.TaskManagement.Ambiente;

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
public class AmbienteController {
	@Autowired
	private AmbienteService service;
	@GetMapping("/ambiente")
	List<Ambiente> all() {
		return service.all();
	}

	@PostMapping("/ambiente")
	Ambiente newAmbiente(@RequestBody Ambiente newAmbiente) {
		return service.newAmbiente(newAmbiente);
	}

	// Single item

	@GetMapping("/ambiente/{id}")
	Ambiente one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/ambiente/{id}")
	Ambiente  replaceAmbiente(@RequestBody Ambiente newAmbiente, @PathVariable Integer id) {
		return service.replaceAmbiente(newAmbiente,id);
	}

	@DeleteMapping("/ambiente/{id}")
	void deleteAmbiente(@PathVariable Integer id) {
		service.deleteAmbiente(id);
	}

}