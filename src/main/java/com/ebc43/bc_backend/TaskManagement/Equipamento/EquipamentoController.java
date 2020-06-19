package com.ebc43.bc_backend.TaskManagement.Equipamento;

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
public class EquipamentoController {
	@Autowired
	private EquipamentoServiceProvider serviceProvider;

	@GetMapping("/equipamento")
	List<Equipamento> all() {
		return serviceProvider.getService().all();
	}
	
	@GetMapping("/equipamento/embarcacao/{id}")
	List<Equipamento> allByEmbarcacaoId(@PathVariable Integer id) {
		return serviceProvider.getService().allByEmbarcacaoId(id);
	}
	
	@GetMapping("/equipamento/ambiente/{id}")
	List<Equipamento> allByAmbienteId(@PathVariable Integer id) {
		return serviceProvider.getService().allByAmbienteId(id);
	}

	@PostMapping("/equipamento")
	Equipamento newEquipamento(@RequestBody Equipamento newEquipamento) {
		return serviceProvider.getService().newEquipamento(newEquipamento);
	}

	// Single item

	@GetMapping("/equipamento/{id}")
	Equipamento one(@PathVariable UUID id) {
		return serviceProvider.getService().one(id);
	}

	@PutMapping("/equipamento/{id}")
	Equipamento replaceEquipamento(@RequestBody Equipamento newEquipamento, @PathVariable UUID id) {
		return serviceProvider.getService().replaceEquipamento(newEquipamento,id);
	}

	@DeleteMapping("/equipamento/{id}")
	void deleteEquipamento(@PathVariable UUID id) {
		serviceProvider.getService().deleteEquipamento(id);
	}
}