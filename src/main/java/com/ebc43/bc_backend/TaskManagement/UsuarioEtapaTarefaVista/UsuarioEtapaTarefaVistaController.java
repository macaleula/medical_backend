package com.ebc43.bc_backend.TaskManagement.UsuarioEtapaTarefaVista;

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

import com.ebc43.bc_backend.TaskManagement.UsuarioEtapaTarefaVista.UsuarioEtapaTarefaVista;
import com.ebc43.bc_backend.TaskManagement.UsuarioEtapaTarefaVista.UsuarioEtapaTarefaVistaService;

@RestController
public class UsuarioEtapaTarefaVistaController {
	@Autowired
	private UsuarioEtapaTarefaVistaService service;
	@GetMapping("/usuario_etapa_tarefa_vista")
	List<UsuarioEtapaTarefaVista> all() {
		return service.all();
	}

	@PostMapping("/usuario_etapa_tarefa_vista")
	UsuarioEtapaTarefaVista newTarefa(@RequestBody UsuarioEtapaTarefaVista newUsuarioEtapaTarefaVista) {    
		return service.newUsuarioEtapaTarefaVista(newUsuarioEtapaTarefaVista);
	}

	@GetMapping("/usuario_etapa_tarefa_vista/{id}")
	UsuarioEtapaTarefaVista one(@PathVariable UUID id) {
		return service.one(id);
	}

	@PutMapping("/usuario_etapa_tarefa_vista/{id}")
	UsuarioEtapaTarefaVista replaceTarefa(@RequestBody UsuarioEtapaTarefaVista newUsuarioEtapaTarefaVista, @PathVariable UUID id) {
		return service.replaceUsuarioEtapaTarefaVista(newUsuarioEtapaTarefaVista, id);
	}

	@DeleteMapping("/usuario_etapa_tarefa_vista/{id}")
	void deleteTarefa(@PathVariable UUID id) {
		service.deleteUsuarioEtapaTarefaVista(id);
	}

}
