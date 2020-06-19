package com.ebc43.bc_backend.RoutineSaylor.DiaSemana;

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
public class DiaSemanaController {
	@Autowired
	private DiaSemanaService service;
	@GetMapping("/dia_semana")
	List<DiaSemana> all() {
		return service.all();
	}

	@PostMapping("/dia_semana")
	DiaSemana newDiaSemana(@RequestBody DiaSemana newDiaSemana) {
		return service.newDiaSemana(newDiaSemana);
	}

	// Single item

	@GetMapping("/dia_semana/{id}")
	DiaSemana one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/dia_semana/{id}")
	DiaSemana replaceDiaSemana(@RequestBody DiaSemana newDiaSemana, @PathVariable Integer id) {
		return service.replaceDiaSemana(newDiaSemana,id);
	}

	@DeleteMapping("/dia_semana/{id}")
	void deleteDiaSemana(@PathVariable Integer id) {
		service.deleteDiaSemana(id);
	}
}