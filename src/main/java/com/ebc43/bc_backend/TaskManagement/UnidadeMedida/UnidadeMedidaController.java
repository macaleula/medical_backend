package com.ebc43.bc_backend.TaskManagement.UnidadeMedida;

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
public class UnidadeMedidaController {
	@Autowired
	private UnidadeMedidaService service;
	@GetMapping("/unidade_medida")
	List<UnidadeMedida> all() {
		return service.all();
	}

	@PostMapping("/unidade_medida")
	UnidadeMedida newUnidadeMedida(@RequestBody UnidadeMedida newUnidadeMedida) {
		return service.newUnidadeMedida(newUnidadeMedida);
	}

	// Single item

	@GetMapping("/unidade_medida/{id}")
	UnidadeMedida one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/unidade_medida/{id}")
	UnidadeMedida replaceUnidadeMedida(@RequestBody UnidadeMedida newUnidadeMedida, @PathVariable Integer id) {
		return service.replaceUnidadeMedida(newUnidadeMedida,id);
	}

	@DeleteMapping("/unidade_medida/{id}")
	void deleteUnidadeMedida(@PathVariable Integer id) {
		service.deleteUnidadeMedida(id);
	}
}
