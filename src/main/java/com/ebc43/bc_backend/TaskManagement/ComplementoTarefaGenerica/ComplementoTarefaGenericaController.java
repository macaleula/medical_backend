package com.ebc43.bc_backend.TaskManagement.ComplementoTarefaGenerica;

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
public class ComplementoTarefaGenericaController {
	@Autowired
	private ComplementoTarefaGenericaService service;
	@GetMapping("/complemento_tarefa_generica")
	List<ComplementoTarefaGenerica> all() {
		return service.all();
	}

	@PostMapping("/complemento_tarefa_generica")
	ComplementoTarefaGenerica newComplementoTarefaGenerica(@RequestBody ComplementoTarefaGenerica newComplementoTarefaGenerica) {
		return service.newComplementoTarefaGenerica(newComplementoTarefaGenerica);
	}

	// Single item

	@GetMapping("/complemento_tarefa_generica/{id}")
	ComplementoTarefaGenerica one(@PathVariable UUID id) {
		return service.one(id);
	}

	@PutMapping("/complemento_tarefa_generica/{id}")
	ComplementoTarefaGenerica replaceComplementoTarefaGenerica(@RequestBody ComplementoTarefaGenerica newComplementoTarefaGenerica, @PathVariable UUID id) {
		return service.replaceComplementoTarefaGenerica(newComplementoTarefaGenerica, id);
	}

	@DeleteMapping("/complemento_tarefa_generica/{id}")
	void deleteComplementoTarefaGenerica(@PathVariable UUID id) {
		service.deleteComplementoTarefaGenerica(id);
	}
}
