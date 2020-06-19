package com.ebc43.bc_backend.TaskManagement.EvidenciaNecessariaTarefa;

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
public class EvidenciaNecessariaTarefaController {
	@Autowired
	private EvidenciaNecessariaTarefaService service;
	@GetMapping("/evidencia_necessaria_tarefa")
	List<EvidenciaNecessariaTarefa> all() {
		return service.all();
	}

	@PostMapping("/evidencia_necessaria_tarefa")
	EvidenciaNecessariaTarefa newEvidenciaNecessariaTarefa(@RequestBody EvidenciaNecessariaTarefa newEvidenciaNecessariaTarefa) {
		return service.newEvidenciaNecessariaTarefa(newEvidenciaNecessariaTarefa);
	}

	// Single item

	@GetMapping("/evidencia_necessaria_tarefa/{id}")
	EvidenciaNecessariaTarefa one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/evidencia_necessaria_tarefa/{id}")
	EvidenciaNecessariaTarefa replaceEvidenciaNecessariaTarefa(@RequestBody EvidenciaNecessariaTarefa newEvidenciaNecessariaTarefa, @PathVariable Integer id) {
		return service.replaceEvidenciaNecessariaTarefa(newEvidenciaNecessariaTarefa,id);
	}

	@DeleteMapping("/evidencia_necessaria_tarefa/{id}")
	void deleteEvidenciaNecessariaTarefa(@PathVariable Integer id) {
		service.deleteEvidenciaNecessariaTarefa(id);
	}
}
