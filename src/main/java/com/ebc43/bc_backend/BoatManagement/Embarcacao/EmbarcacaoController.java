package com.ebc43.bc_backend.BoatManagement.Embarcacao;


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
public class EmbarcacaoController {
	@Autowired
	private EmbarcacaoService service;
	@GetMapping("/embarcacao")
	List<Embarcacao>  all() {
		return service.all();
	}

	@PostMapping("/embarcacao")
	Embarcacao  newEmbarcacao(@RequestBody Embarcacao newEmbarcacao) {
		return service.newEmbarcacao(newEmbarcacao);
	}

	// Single item

	@GetMapping("/embarcacao/{id}")
	Embarcacao  one(@PathVariable Integer id) {
		return service.one(id);
	}
	
	@GetMapping("/embarcacao/nome/{name}")
	Embarcacao byNome(@PathVariable String name) {
		return service.byNome(name);
	}
	
	@GetMapping("/embarcacao/marina/{name}")
	Embarcacao byMarina(@PathVariable String name) {
		return service.byMarina(name);
	}

	@PutMapping("/embarcacao/{id}")
	Embarcacao replaceEmbarcacao(@RequestBody Embarcacao newEmbarcacao, @PathVariable Integer id) {
		return service.replaceEmbarcacao(newEmbarcacao,id);
	}

	@DeleteMapping("/embarcacao/{id}")
	void deleteEmbarcacao(@PathVariable Integer id) {
		service.deleteEmbarcacao(id);
	}
	
}
