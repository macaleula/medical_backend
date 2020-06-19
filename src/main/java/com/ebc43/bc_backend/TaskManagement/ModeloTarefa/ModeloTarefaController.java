package com.ebc43.bc_backend.TaskManagement.ModeloTarefa;

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
public class ModeloTarefaController {
	@Autowired
	private ModeloTarefaService service;
	@GetMapping("/modelo_tarefa")
	List<ModeloTarefa> all() {
			return service.all();
	}

	@PostMapping("/modelo_tarefa")
	ModeloTarefa newModeloTarefa(@RequestBody ModeloTarefa newModeloTarefa) {
		return service.newModeloTarefa(newModeloTarefa);
	}

	// Single item

	@GetMapping("/modelo_tarefa/{id}")
	ModeloTarefa one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/modelo_tarefa/{id}")
	ModeloTarefa replaceModeloTarefa(@RequestBody ModeloTarefa newModeloTarefa, @PathVariable Integer id) {
		return service.replaceModeloTarefa(newModeloTarefa,id);
	}

	@DeleteMapping("/modelo_tarefa/{id}")
	void deleteModeloTarefa(@PathVariable Integer id) {
		service.deleteModeloTarefa(id);
	}

}