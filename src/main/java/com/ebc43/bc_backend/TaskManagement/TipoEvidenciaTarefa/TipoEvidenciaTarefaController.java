package com.ebc43.bc_backend.TaskManagement.TipoEvidenciaTarefa;

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
public class TipoEvidenciaTarefaController {
	@Autowired
	private TipoEvidenciaTarefaService service;
	@GetMapping("/tipo_evidencia_tarefa")
	List<TipoEvidenciaTarefa> all() {
		return service.all();
	}

	@PostMapping("/tipo_evidencia_tarefa")
	TipoEvidenciaTarefa newTipoEvidenciaTarefa(@RequestBody TipoEvidenciaTarefa newTipoEvidenciaTarefa) {
		return service.newTipoEvidenciaTarefa(newTipoEvidenciaTarefa);
	}

	// Single item

	@GetMapping("/tipo_evidencia_tarefa/{id}")
	TipoEvidenciaTarefa one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/tipo_evidencia_tarefa/{id}")
	TipoEvidenciaTarefa replaceTipoEvidenciaTarefa(@RequestBody TipoEvidenciaTarefa newTipoEvidenciaTarefa, @PathVariable Integer id) {
		return service.replaceTipoEvidenciaTarefa(newTipoEvidenciaTarefa,id);
	}

	@DeleteMapping("/tipo_evidencia_tarefa/{id}")
	void deleteTipoEvidenciaTarefa(@PathVariable Integer id) {
		service.deleteTipoEvidenciaTarefa(id);
	}
}
