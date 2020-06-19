package com.ebc43.bc_backend.TaskManagement.GrupoTarefa;

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

import com.ebc43.bc_backend.TaskManagement.GrupoTarefa.GrupoTarefa;
import com.ebc43.bc_backend.TaskManagement.GrupoTarefa.GrupoTarefaService;

@RestController
public class GrupoTarefaController {
	@Autowired
	private GrupoTarefaService service;
	@GetMapping("/grupo_tarefa")
	List<GrupoTarefa> all() {
		return service.all();
	}

	@PostMapping("/grupo_tarefa")
	GrupoTarefa newGrupoTarefa(@RequestBody GrupoTarefa newGrupoTarefa) {    
		return service.newGrupoTarefa(newGrupoTarefa);
	}

	// Single item

	@GetMapping("/grupo_tarefa/{id}")
	GrupoTarefa one(@PathVariable UUID id) {
		return service.one(id);
	}

	@PutMapping("/grupo_tarefa/{id}")
	GrupoTarefa replaceGrupoTarefa(@RequestBody GrupoTarefa newGrupoTarefa, @PathVariable UUID id) {
		return service.replaceGrupoTarefa(newGrupoTarefa, id);
	}

	@DeleteMapping("/grupo_tarefa/{id}")
	void deleteGrupoTarefa(@PathVariable UUID id) {
		service.deleteGrupoTarefa(id);
	}
}
