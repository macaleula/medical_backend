package com.ebc43.bc_backend.TaskManagement.InterdicaoAmbiente;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterdicaoAmbienteController {
	@Autowired
	private InterdicaoAmbienteService service;
	@GetMapping("/interdicao_ambiente")
	List<InterdicaoAmbiente> all() {
		return service.all();
	}

	@PostMapping("/interdicao_ambiente")
	InterdicaoAmbiente newInterdicaoAmbiente(@RequestBody InterdicaoAmbiente newInterdicaoAmbiente) {
		return service.newInterdicaoAmbiente(newInterdicaoAmbiente);
	}

	// Single item

	@GetMapping("/interdicao_ambiente/{id}")
	InterdicaoAmbiente one(@PathVariable UUID id) {
		return service.one(id);
	}

	@PutMapping("/interdicao_ambiente/{id}")
	InterdicaoAmbiente replaceInterdicaoAmbiente(@RequestBody InterdicaoAmbiente newInterdicaoAmbiente, @PathVariable UUID id) {
		return service.replaceInterdicaoAmbiente(newInterdicaoAmbiente, id);
	}

	@DeleteMapping("/interdicao_ambiente/{id}")
	void deleteInterdicaoAmbiente(@PathVariable UUID id) {
		service.deleteInterdicaoAmbiente(id);
	}

}
