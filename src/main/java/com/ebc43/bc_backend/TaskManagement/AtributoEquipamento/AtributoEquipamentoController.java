package com.ebc43.bc_backend.TaskManagement.AtributoEquipamento;

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

import com.ebc43.bc_backend.TaskManagement.AtributoEquipamento.AtributoEquipamento;
import com.ebc43.bc_backend.TaskManagement.AtributoEquipamento.AtributoEquipamentoService;

@RestController
public class AtributoEquipamentoController {
	@Autowired
	private AtributoEquipamentoService service;
	@GetMapping("/atributo_equipamento")
	List<AtributoEquipamento> all() {
		return service.all();
	}

	@PostMapping("/atributo_equipamento")
	AtributoEquipamento newAtributoEquipamento(@RequestBody AtributoEquipamento newAtributoEquipamento) {    
		return service.newAtributoEquipamento(newAtributoEquipamento);
	}

	// Single item

	@GetMapping("/atributo_equipamento/{id}")
	AtributoEquipamento one(@PathVariable UUID id) {
		return service.one(id);
	}

	@PutMapping("/atributo_equipamento/{id}")
	AtributoEquipamento replaceAtributoEquipamento(@RequestBody AtributoEquipamento newAtributoEquipamento, @PathVariable UUID id) {
		return service.replaceAtributoEquipamento(newAtributoEquipamento, id);
	}

	@DeleteMapping("/atributo_equipamento/{id}")
	void deleteAtributoEquipamento(@PathVariable UUID id) {
		service.deleteAtributoEquipamento(id);
	}
}
