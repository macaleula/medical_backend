package com.ebc43.bc_backend.TaskManagement.RecursoHumanoModeloTarefa;

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
public class RecursoHumanoModeloTarefaController {
	@Autowired
	private RecursoHumanoModeloTarefaService service;
	@GetMapping("/recurso_humano_modelo_tarefa")
	List<RecursoHumanoModeloTarefa>  all() {
		return service.all();
	}

	@PostMapping("/recurso_humano_modelo_tarefa")
	RecursoHumanoModeloTarefa  newRecursoHumanoModeloTarefa(@RequestBody RecursoHumanoModeloTarefa newRecursoHumanoModeloTarefa) {
		return service.newRecursoHumanoModeloTarefa(newRecursoHumanoModeloTarefa);
	}

	// Single item

	@GetMapping("/recurso_humano_modelo_tarefa/{id}")
	RecursoHumanoModeloTarefa  one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/recurso_humano_modelo_tarefa/{id}")
	RecursoHumanoModeloTarefa  replaceRecursoHumanoModeloTarefa(@RequestBody RecursoHumanoModeloTarefa newRecursoHumanoModeloTarefa, @PathVariable Integer id) {
		return service.replaceRecursoHumanoModeloTarefa(newRecursoHumanoModeloTarefa,id);
	}

	@DeleteMapping("/recurso_humano_modelo_tarefa/{id}")
	void deleteRecursoHumanoModeloTarefa(@PathVariable Integer id) {
		service.deleteRecursoHumanoModeloTarefa(id);
	}
}
