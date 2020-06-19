package com.ebc43.bc_backend.TaskManagement.MarinheiroEscalado;

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
public class MarinheiroEscaladoController {
	@Autowired
	private MarinheiroEscaladoService service;
	@GetMapping("/marinheiro_escalado")
	List<MarinheiroEscalado> all() {
		return service.all();
	}

	@PostMapping("/marinheiro_escalado")
	MarinheiroEscalado newMarinheiroEscalado(@RequestBody MarinheiroEscalado newMarinheiroEscalado) {
		return service.newMarinheiroEscalado(newMarinheiroEscalado);
	}

	// Single item

	@GetMapping("/marinheiro_escalado/{id}")
	MarinheiroEscalado one(@PathVariable UUID id) {
		return service.one(id);
	}

	@PutMapping("/marinheiro_escalado/{id}")
	MarinheiroEscalado replaceMarinheiroEscalado(@RequestBody MarinheiroEscalado newMarinheiroEscalado, @PathVariable UUID id) {
		return service.replaceMarinheiroEscalado(newMarinheiroEscalado, id);
	}

	@DeleteMapping("/marinheiro_escalado/{id}")
	void deleteMarinheiroEscalado(@PathVariable UUID id) {
		service.deleteMarinheiroEscalado(id);
	}

}
