package com.ebc43.bc_backend.BoatManagement.EmbarcacaoProprietario;

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
public class EmbarcacaoProprietarioController {
	@Autowired
	private EmbarcacaoProprietarioService service;
	@GetMapping("/embarcacao_proprietario")
	List<EmbarcacaoProprietario> all() {
		return service.all();
	}

	@PostMapping("/embarcacao_proprietario")
	EmbarcacaoProprietario newEmbarcacaoProprietario(@RequestBody EmbarcacaoProprietario newEmbarcacaoProprietario) {
		return service.newEmbarcacaoProprietario(newEmbarcacaoProprietario);
	}

	// Single item

	@GetMapping("/embarcacao_proprietario/{id}")
	EmbarcacaoProprietario one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/embarcacao_proprietario/{id}")
	EmbarcacaoProprietario replaceEmbarcacaoProprietario(@RequestBody EmbarcacaoProprietario newEmbarcacaoProprietario, @PathVariable Integer id) 
			{
		return service.replaceEmbarcacaoProprietario(newEmbarcacaoProprietario,id);
	}

	@DeleteMapping("/embarcacao_proprietario/{id}")
	void deleteEmbarcacaoProprietario(@PathVariable Integer id) {
		service.deleteEmbarcacaoProprietario(id);
	}	
}
