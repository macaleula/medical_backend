package com.ebc43.bc_backend.TaskManagement.IntegranteGrupoTarefa;

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
public class IntegranteGrupoTarefaController {
	@Autowired
	private IntegranteGrupoTarefaService service;
	@GetMapping("/integrante_grupo_tarefa")
	List<IntegranteGrupoTarefa> all() {
		return service.all();
	}

	@PostMapping("/integrante_grupo_tarefa")
	IntegranteGrupoTarefa newTarefa(@RequestBody IntegranteGrupoTarefa newIntegranteGrupoTarefa) {    
		return service.newIntegranteGrupoTarefa(newIntegranteGrupoTarefa);
	}

	// Single item

	@GetMapping("/integrante_grupo_tarefa/{id}")
	IntegranteGrupoTarefa one(@PathVariable UUID id) {
		return service.one(id);
	}

	@PutMapping("/integrante_grupo_tarefa/{id}")
	IntegranteGrupoTarefa replaceTarefa(@RequestBody IntegranteGrupoTarefa newIntegranteGrupoTarefa, @PathVariable UUID id) {
		return service.replaceIntegranteGrupoTarefa(newIntegranteGrupoTarefa, id);
	}

	@DeleteMapping("/integrante_grupo_tarefa/{id}")
	void deleteIntegranteGrupoTarefa(@PathVariable UUID id) {
		service.deleteIntegranteGrupoTarefa(id);
	}
}
