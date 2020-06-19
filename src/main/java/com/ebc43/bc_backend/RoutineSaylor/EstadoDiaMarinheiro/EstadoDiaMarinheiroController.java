package com.ebc43.bc_backend.RoutineSaylor.EstadoDiaMarinheiro;

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
public class EstadoDiaMarinheiroController {
	@Autowired
	private EstadoDiaMarinheiroService service;
	@GetMapping("/estado_dia_marinheiro")
	List<EstadoDiaMarinheiro> all() {
		return service.all();
	}

	@PostMapping("/estado_dia_marinheiro")
	EstadoDiaMarinheiro newEstadoDiaMarinheiro(@RequestBody EstadoDiaMarinheiro newEstadoDiaMarinheiro) {
		return service.newEstadoDiaMarinheiro(newEstadoDiaMarinheiro);
	}

	// Single item

	@GetMapping("/estado_dia_marinheiro/{id}")
	EstadoDiaMarinheiro one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/estado_dia_marinheiro/{id}")
	EstadoDiaMarinheiro replaceEstadoDiaMarinheiro(@RequestBody EstadoDiaMarinheiro newEstadoDiaMarinheiro, @PathVariable Integer id) {
		return service.replaceEstadoDiaMarinheiro(newEstadoDiaMarinheiro,id);
	}

	@DeleteMapping("/estado_dia_marinheiro/{id}")
	void deleteEstadoDiaMarinheiro(@PathVariable Integer id) {
		service.deleteEstadoDiaMarinheiro(id);
	}
}