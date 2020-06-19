package com.ebc43.bc_backend.TaskManagement.ModeloEvidenciaTarefa;

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
public class ModeloEvidenciaTarefaController {
	@Autowired
	private ModeloEvidenciaTarefaService service;
	@GetMapping("/modelo_evidencia_tarefa")
	List<ModeloEvidenciaTarefa> all() {
		return service.all();
	}

	@PostMapping("/modelo_evidencia_tarefa")
	ModeloEvidenciaTarefa newModeloEvidenciaTarefa(@RequestBody ModeloEvidenciaTarefa newModeloEvidenciaTarefa) {
		return service.newModeloEvidenciaTarefa(newModeloEvidenciaTarefa);
	}

	// Single item

	@GetMapping("/modelo_evidencia_tarefa/{id}")
	ModeloEvidenciaTarefa one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/modelo_evidencia_tarefa/{id}")
	ModeloEvidenciaTarefa replaceModeloEvidenciaTarefa(@RequestBody ModeloEvidenciaTarefa newModeloEvidenciaTarefa, @PathVariable Integer id) {
		return service.replaceModeloEvidenciaTarefa(newModeloEvidenciaTarefa,id);
	}

	@DeleteMapping("/modelo_evidencia_tarefa/{id}")
	void deleteModeloEvidenciaTarefa(@PathVariable Integer id) {
		service.deleteModeloEvidenciaTarefa(id);
	}
}