package com.ebc43.bc_backend.RoutineSaylor.DiaMarinheiro;

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
public class DiaMarinheiroController {
	@Autowired
	private DiaMarinheiroService service;
	@GetMapping("/dia_marinheiro")
	List<DiaMarinheiro> all() {
		return service.all();
	}

	@PostMapping("/dia_marinheiro")
	DiaMarinheiro newDiaMarinheiro(@RequestBody DiaMarinheiro newDiaMarinheiro) {
		return service.newDiaMarinheiro(newDiaMarinheiro);
	}

	// Single item

	@GetMapping("/dia_marinheiro/{id}")
	DiaMarinheiro one(@PathVariable UUID id) {
		return service.one(id);
	}

	@PutMapping("/dia_marinheiro/{id}")
	DiaMarinheiro replaceDiaMarinheiro(@RequestBody DiaMarinheiro newDiaMarinheiro, @PathVariable UUID id) {
		return service.replaceDiaMarinheiro(newDiaMarinheiro,id);
	}

	@DeleteMapping("/dia_marinheiro/{id}")
	void deleteDiaMarinheiro(@PathVariable UUID id) {
		service.deleteDiaMarinheiro(id);
	}
}