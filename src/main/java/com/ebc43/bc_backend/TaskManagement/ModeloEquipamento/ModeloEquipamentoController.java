package com.ebc43.bc_backend.TaskManagement.ModeloEquipamento;

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
public class ModeloEquipamentoController {
	@Autowired
	private ModeloEquipamentoService service;
	@GetMapping("/modelo_equipamento")
	List<ModeloEquipamento> all() {
		return service.all();
	}

	@PostMapping("/modelo_equipamento")
	ModeloEquipamento newModeloEquipamento(@RequestBody ModeloEquipamento newModeloEquipamento) {
		return service.newModeloEquipamento(newModeloEquipamento);
	}

	// Single item

	@GetMapping("/modelo_equipamento/{id}")
	ModeloEquipamento one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/modelo_equipamento/{id}")
	ModeloEquipamento replaceModeloEquipamento(@RequestBody ModeloEquipamento newModeloEquipamento, @PathVariable Integer id) {
		return service.replaceModeloEquipamento(newModeloEquipamento,id);
	}

	@DeleteMapping("/modelo_equipamento/{id}")
	void deleteModeloEquipamento(@PathVariable Integer id) {
		service.deleteModeloEquipamento(id);
	}
}