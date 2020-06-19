package com.ebc43.bc_backend.BoatManagement.EstadoFederacao;

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
public class EstadoFederacaoController {
	@Autowired
	private EstadoFederacaoService service;
	@GetMapping("/estado_federacao")
	List<EstadoFederacao> all() {
		return service.all();
	}

	@PostMapping("/estado_federacao")
	EstadoFederacao newEstadoFederacao(@RequestBody EstadoFederacao newEstadoFederacao) {
		return service.newEstadoFederacao(newEstadoFederacao);
	}

	// Single item

	@GetMapping("/estado_federacao/{id}")
	EstadoFederacao one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/estado_federacao/{id}")
	EstadoFederacao replaceEstadoFederacao(@RequestBody EstadoFederacao newEstadoFederacao, @PathVariable Integer id) {
		return service.replaceEstadoFederacao(newEstadoFederacao,id);
	}

	@DeleteMapping("/estado_federacao/{id}")
	void deleteEstadoFederacao(@PathVariable Integer id) {
		service.deleteEstadoFederacao(id);
	}
}

