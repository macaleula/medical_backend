package com.ebc43.bc_backend.TaskManagement.PreRequisitoModeloTarefa;

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
public class PreRequisitoModeloTarefaController {
	@Autowired
	private PreRequisitoModeloTarefaService service;
	@GetMapping("/pre_requisito_modelo_tarefa")
	List<PreRequisitoModeloTarefa> all() {
		return service.all();
	}

	@PostMapping("/pre_requisito_modelo_tarefa")
	PreRequisitoModeloTarefa newPreRequisitoModeloTarefa(@RequestBody PreRequisitoModeloTarefa newPreRequisitoModeloTarefa) {
		return service.newPreRequisitoModeloTarefa(newPreRequisitoModeloTarefa);
	}

	// Single item

	@GetMapping("/pre_requisito_modelo_tarefa/{id}")
	PreRequisitoModeloTarefa one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/pre_requisito_modelo_tarefa/{id}")
	PreRequisitoModeloTarefa replacePreRequisitoModeloTarefa(@RequestBody PreRequisitoModeloTarefa newPreRequisitoModeloTarefa, @PathVariable Integer id) {
		return service.replacePreRequisitoModeloTarefa(newPreRequisitoModeloTarefa,id);
	}

	@DeleteMapping("/pre_requisito_modelo_tarefa/{id}")
	void deletePreRequisitoModeloTarefa(@PathVariable Integer id) {
		service.deletePreRequisitoModeloTarefa(id);
	}
}
