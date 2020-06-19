package com.ebc43.bc_backend.TaskManagement.PosRequisitoModeloTarefa;

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
public class PosRequisitoModeloTarefaController {
	@Autowired
	private PosRequisitoModeloTarefaService service;
	@GetMapping("/pos_requisito_modelo_tarefa")
	List<PosRequisitoModeloTarefa> all() {
		return service.all();
	}

	@PostMapping("/pos_requisito_modelo_tarefa")
	PosRequisitoModeloTarefa newPosRequisitoModeloTarefa(@RequestBody PosRequisitoModeloTarefa newPosRequisitoModeloTarefa) {
		return service.newPosRequisitoModeloTarefa(newPosRequisitoModeloTarefa);
	}

	// Single item

	@GetMapping("/pos_requisito_modelo_tarefa/{id}")
	PosRequisitoModeloTarefa one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/pos_requisito_modelo_tarefa/{id}")
	PosRequisitoModeloTarefa replacePosRequisitoModeloTarefa(@RequestBody PosRequisitoModeloTarefa newPosRequisitoModeloTarefa, @PathVariable Integer id) {
		return service.replacePosRequisitoModeloTarefa(newPosRequisitoModeloTarefa,id);
	}

	@DeleteMapping("/pos_requisito_modelo_tarefa/{id}")
	void deletePosRequisitoModeloTarefa(@PathVariable Integer id) {
		service.deletePosRequisitoModeloTarefa(id);
	}
}
