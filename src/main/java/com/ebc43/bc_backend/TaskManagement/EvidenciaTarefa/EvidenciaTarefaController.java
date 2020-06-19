package com.ebc43.bc_backend.TaskManagement.EvidenciaTarefa;

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
public class EvidenciaTarefaController {
	@Autowired
	private EvidenciaTarefaService service;
	@GetMapping("/evidencia_tarefa")
	List<EvidenciaTarefa> all() {
		return service.all();
	}

	@PostMapping("/evidencia_tarefa")
	EvidenciaTarefa newEvidenciaTarefa(@RequestBody EvidenciaTarefa newEvidenciaTarefa) {
		return service.newEvidenciaTarefa(newEvidenciaTarefa);
	}

	@GetMapping("/evidencia_tarefa/{id}")
	EvidenciaTarefa one(@PathVariable UUID id) {
		return service.one(id);
	}

	@PutMapping("/evidencia_tarefa/{id}")
	EvidenciaTarefa replaceEvidenciaTarefa(@RequestBody EvidenciaTarefa newEvidenciaTarefa, @PathVariable UUID id) {
		return service.replaceEvidenciaTarefa(newEvidenciaTarefa, id);
	}

	@DeleteMapping("/evidencia_tarefa/{id}")
	void deleteEvidenciaTarefa(@PathVariable UUID id) {
		service.deleteEvidenciaTarefa(id);
	}
	
}