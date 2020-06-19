package com.ebc43.bc_backend.TaskManagement.Tarefa;

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
public class TarefaController {
	
	@Autowired
	private TarefaServiceProvider serviceProvider;


	@GetMapping("/tarefa")
	List<Tarefa> all() {
		return serviceProvider.getService().all();
	}
	
	@GetMapping("/tarefa/embarcacao/{embarcacaoId}")
	List<Tarefa> allByEmbarcacaoId(@PathVariable Integer embarcacaoId) {
		return serviceProvider.getService().operantesByEmbarcacaoId(embarcacaoId);
	}
	
	@GetMapping("/tarefa/historico/embarcacao/{embarcacaoId}")
	List<Tarefa> historicoByEmbarcacaoId(@PathVariable Integer embarcacaoId) {
		return serviceProvider.getService().historicoByEmbarcacaoId(embarcacaoId);
	}
	
	@GetMapping("/tarefa/ambiente/{ambienteId}")
	List<Tarefa> allByAmbienteId(@PathVariable Integer ambienteId) {
		return serviceProvider.getService().operantesByAmbienteId(ambienteId);
	}
	
	@GetMapping("/tarefa/historico/ambiente/{ambienteId}")
	List<Tarefa> historicoByAmbienteId(@PathVariable Integer ambienteId) {
		return serviceProvider.getService().historicoByAmbienteId(ambienteId);
	}
	
	@GetMapping("/tarefa/ultima_finalizada/modelo_ambiente/{modeloTarefaId}")
	Tarefa findUltimaFinalizadaByModeloTarefa(@PathVariable Integer modeloTarefaId) {
		return serviceProvider.getService().findUltimaFinalizadaByModeloTarefa(modeloTarefaId);
	}

	@PostMapping("/tarefa")
	Tarefa newTarefa(@RequestBody Tarefa newTarefa) {    
		return serviceProvider.getService().newTarefa(newTarefa);
	}

	// Single item

	@GetMapping("/tarefa/{id}")
	Tarefa one(@PathVariable UUID id) {
		return serviceProvider.getService().one(id);
	}

	@PutMapping("/tarefa/{id}")
	Tarefa replaceTarefa(@RequestBody Tarefa newTarefa, @PathVariable UUID id) {
		return serviceProvider.getService().replaceTarefa(newTarefa, id);
	}

	@DeleteMapping("/tarefa/{id}")
	void deleteTarefa(@PathVariable UUID id) {
		serviceProvider.getService().deleteTarefa(id);
	}
	
}