package com.ebc43.bc_backend.TaskManagement.EstadoTarefa;

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
public class EstadoTarefaController {
	@Autowired
	private EstadoTarefaService service;
	@GetMapping("/estado_tarefa")
	List<EstadoTarefa> all() {
		return service.all();
	}

	@PostMapping("/estado_tarefa")
	EstadoTarefa newEstadoTarefa(@RequestBody EstadoTarefa newEstadoTarefa) {
		return service.newEstadoTarefa(newEstadoTarefa);
	}

	// Single item

	@GetMapping("/estado_tarefa/{id}")
	EstadoTarefa one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/estado_tarefa/{id}")
	EstadoTarefa replaceEstadoTarefa(@RequestBody EstadoTarefa newEstadoTarefa, @PathVariable Integer id) {
		return service.replaceEstadoTarefa(newEstadoTarefa,id);
	}

	@DeleteMapping("/estado_tarefa/{id}")
	void deleteEstadoTarefa(@PathVariable Integer id) {
		service.deleteEstadoTarefa(id);
	}
}