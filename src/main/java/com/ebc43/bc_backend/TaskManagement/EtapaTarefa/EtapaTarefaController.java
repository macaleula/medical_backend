package com.ebc43.bc_backend.TaskManagement.EtapaTarefa;

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
public class EtapaTarefaController {
	@Autowired
	private EtapaTarefaService service;
	@GetMapping("/etapa_tarefa")
	List<EtapaTarefa> all() {
		return service.all();
	}

	@PostMapping("/etapa_tarefa")
	EtapaTarefa newEtapaTarefa(@RequestBody EtapaTarefa newEtapaTarefa) {
		return service.newEtapaTarefa(newEtapaTarefa);
	}

	@GetMapping("/etapa_tarefa/{id}")
	EtapaTarefa one(@PathVariable UUID id) {
		return service.one(id);
	}

	@PutMapping("/etapa_tarefa/{id}")
	EtapaTarefa replaceEtapaTarefa(@RequestBody EtapaTarefa newEtapaTarefa, @PathVariable UUID id) {
		return service.replaceEtapaTarefa(newEtapaTarefa, id);
	}

	@DeleteMapping("/etapa_tarefa/{id}")
	void deleteEtapaTarefa(@PathVariable UUID id) {
		service.deleteEtapaTarefa(id);
	}
}
