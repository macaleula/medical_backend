package com.ebc43.bc_backend.TaskManagement.ModeloAtributoEquipamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebc43.bc_backend.TaskManagement.ModeloAtributoEquipamento.ModeloAtributoEquipamento;
import com.ebc43.bc_backend.TaskManagement.ModeloAtributoEquipamento.ModeloAtributoEquipamentoService;

@RestController
public class ModeloAtributoEquipamentoController {
	@Autowired
	private ModeloAtributoEquipamentoService service;
	@GetMapping("/modelo_atributo_equipamento")
	List<ModeloAtributoEquipamento> all() {
		return service.all();
	}

	@PostMapping("/modelo_atributo_equipamento")
	ModeloAtributoEquipamento newModeloAtributoEquipamento(@RequestBody ModeloAtributoEquipamento newModeloAtributoEquipamento) {
		return service.newModeloAtributoEquipamento(newModeloAtributoEquipamento);
	}

	// Single item

	@GetMapping("/modelo_atributo_equipamento/{id}")
	ModeloAtributoEquipamento one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/modelo_atributo_equipamento/{id}")
	ModeloAtributoEquipamento replaceModeloAtributoEquipamento(@RequestBody ModeloAtributoEquipamento newModeloAtributoEquipamento, @PathVariable Integer id) {
		return service.replaceModeloAtributoEquipamento(newModeloAtributoEquipamento,id);
	}

	@DeleteMapping("/modelo_atributo_equipamento/{id}")
	void deleteModeloAtributoEquipamento(@PathVariable Integer id) {
		service.deleteModeloAtributoEquipamento(id);
	}
}
