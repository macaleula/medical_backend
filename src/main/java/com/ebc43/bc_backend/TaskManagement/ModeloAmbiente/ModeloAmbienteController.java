package com.ebc43.bc_backend.TaskManagement.ModeloAmbiente;

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
public class ModeloAmbienteController {
	@Autowired
	private ModeloAmbienteService service;
	@GetMapping("/modelo_ambiente")
	List<ModeloAmbiente> all() {
		return service.all();
	}

	@PostMapping("/modelo_ambiente")
	ModeloAmbiente newModeloAmbiente(@RequestBody ModeloAmbiente newModeloAmbiente) {
		return service.newModeloAmbiente(newModeloAmbiente);
	}

	// Single item

	@GetMapping("/modelo_ambiente/{id}")
	ModeloAmbiente one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/modelo_ambiente/{id}")
	ModeloAmbiente replaceModeloAmbiente(@RequestBody ModeloAmbiente newModeloAmbiente, @PathVariable Integer id) {
		return service.replaceModeloAmbiente(newModeloAmbiente,id);
	}

	@DeleteMapping("/modelo_ambiente/{id}")
	void deleteModeloAmbiente(@PathVariable Integer id) {
		service.deleteModeloAmbiente(id);
	}
}