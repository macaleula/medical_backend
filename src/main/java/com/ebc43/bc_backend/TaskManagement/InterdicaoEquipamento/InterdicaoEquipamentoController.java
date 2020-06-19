package com.ebc43.bc_backend.TaskManagement.InterdicaoEquipamento;

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
public class InterdicaoEquipamentoController {
	@Autowired
	private InterdicaoEquipamentoService service;
	@GetMapping("/interdicao_equipamento")
	List<InterdicaoEquipamento> all() {
		return service.all();
	}

	@PostMapping("/interdicao_equipamento")
	InterdicaoEquipamento newInterdicaoEquipamento(@RequestBody InterdicaoEquipamento newInterdicaoEquipamento) {
		return service.newInterdicaoEquipamento(newInterdicaoEquipamento);
	}

	// Single item

	@GetMapping("/interdicao_equipamento/{id}")
	InterdicaoEquipamento one(@PathVariable UUID id) {
		return service.one(id);
	}

	@PutMapping("/interdicao_equipamento/{id}")
	InterdicaoEquipamento replaceInterdicaoEquipamento(@RequestBody InterdicaoEquipamento newInterdicaoEquipamento, @PathVariable UUID id) {
		return service.replaceInterdicaoEquipamento(newInterdicaoEquipamento, id);
	}

	@DeleteMapping("/interdicao_equipamento/{id}")
	void deleteInterdicaoEquipamento(@PathVariable UUID id) {
		service.deleteInterdicaoEquipamento(id);
	}

}
