package com.ebc43.bc_backend.BoatManagement.ModeloEmbarcacao;

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
public class ModeloEmbarcacaoController {
	@Autowired
	private ModeloEmbarcacaoService service;
	@GetMapping("/modelo_embarcacao")
	List<ModeloEmbarcacao> all() {
		return service.all();
	}

	@PostMapping("/modelo_embarcacao")
	ModeloEmbarcacao newModeloEmbarcacao(@RequestBody ModeloEmbarcacao newModeloEmbarcacao) {
		return service.newModeloEmbarcacao(newModeloEmbarcacao);
	}

	// Single item

	@GetMapping("/modelo_embarcacao/{id}")
	ModeloEmbarcacao one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/modelo_embarcacao/{id}")
	ModeloEmbarcacao replaceModeloEmbarcacao(@RequestBody ModeloEmbarcacao newModeloEmbarcacao, @PathVariable Integer id) {
		return service.replaceModeloEmbarcacao(newModeloEmbarcacao,id);
	}

	@DeleteMapping("/modelo_embarcacao/{id}")
	void deleteModeloEmbarcacao(@PathVariable Integer id) {
		service.deleteModeloEmbarcacao(id);
	}
}