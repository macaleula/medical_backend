package com.ebc43.bc_backend.RoutineSaylor.EmbarcacaoMarinheiro;

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
public class EmbarcacaoMarinheiroController {
	@Autowired
	private EmbarcacaoMarinheiroService service;
	@GetMapping("/embarcacao_marinheiro")
	List<EmbarcacaoMarinheiro> all() {
		return service.all();
	}
	
	@PostMapping("/embarcacao_marinheiro")
	EmbarcacaoMarinheiro newEmbarcacaoMarinheiro(@RequestBody EmbarcacaoMarinheiro newEmbarcacaoMarinheiro) {
		return service.newEmbarcacaoMarinheiro(newEmbarcacaoMarinheiro);
		
	}
	
	// Single item
	
	@GetMapping("/embarcacao_marinheiro/{id}")
	EmbarcacaoMarinheiro one(@PathVariable Integer id) {
		return service.one(id);
			}
	
	@PutMapping("/embarcacao_marinheiro/{id}")
	EmbarcacaoMarinheiro replaceEmbarcacaoMarinheiro(@RequestBody EmbarcacaoMarinheiro newEmbarcacaoMarinheiro, @PathVariable Integer id) {
		return service.replaceEmbarcacaoMarinheiro(newEmbarcacaoMarinheiro,id);
		
	}
	
	@DeleteMapping("/embarcacao_marinheiro/{id}")
	void deleteEmbarcacaoMarinheiro(@PathVariable Integer id) {
		service.deleteEmbarcacaoMarinheiro(id);
	}


}