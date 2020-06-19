package com.ebc43.bc_backend.UserManagement.InformacoesSensiveis;

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
public class InformacoesSensiveisController {
	@Autowired
	private InformacoesSensiveisService service;
	@GetMapping("/informacoes_sensiveis")
	List<InformacoesSensiveis> all() {
		return service.all();
	}

	@PostMapping("/informacoes_sensiveis")
	InformacoesSensiveis newInformacoesSensiveis(@RequestBody InformacoesSensiveis newInformacoesSensiveis) {
		return service.newInformacoesSensiveis(newInformacoesSensiveis);
	}

	// Single item

	@GetMapping("/informacoes_sensiveis/{id}")
	InformacoesSensiveis one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/informacoes_sensiveis/{id}")
	InformacoesSensiveis replaceInformacoesSensiveis(@RequestBody InformacoesSensiveis newInformacoesSensiveis, @PathVariable Integer id) {
		return service.replaceInformacoesSensiveis(newInformacoesSensiveis,id);
	}

	@DeleteMapping("/informacoes_sensiveis/{id}")
	void deleteInformacoesSensiveis(@PathVariable Integer id) {
		service.deleteInformacoesSensiveis(id);
	}
}
