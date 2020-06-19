package com.ebc43.bc_backend.TaskManagement.PropriedadeModeloEquipamento;

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
public class PropriedadeModeloEquipamentoController {
	@Autowired
	private PropriedadeModeloEquipamentoService service;
	@GetMapping("/propriedade_modelo_equipamento")
	List<PropriedadeModeloEquipamento> all() {
		return service.all();
	}

	@PostMapping("/propriedade_modelo_equipamento")
	PropriedadeModeloEquipamento newPropriedadeModeloEquipamento(@RequestBody PropriedadeModeloEquipamento newPropriedadeModeloEquipamento) {
		return service.newPropriedadeModeloEquipamento(newPropriedadeModeloEquipamento);
	}

	// Single item

	@GetMapping("/propriedade_modelo_equipamento/{id}")
	PropriedadeModeloEquipamento one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/propriedade_modelo_equipamento/{id}")
	PropriedadeModeloEquipamento replacePropriedadeModeloEquipamento(@RequestBody PropriedadeModeloEquipamento newPropriedadeModeloEquipamento, @PathVariable Integer id) {
		return service.replacePropriedadeModeloEquipamento(newPropriedadeModeloEquipamento,id);
	}

	@DeleteMapping("/propriedade_modelo_equipamento/{id}")
	void deletePropriedadeModeloEquipamento(@PathVariable Integer id) {
		service.deletePropriedadeModeloEquipamento(id);
	}
}
