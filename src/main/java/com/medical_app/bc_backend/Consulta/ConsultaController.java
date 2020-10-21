package com.medical_app.bc_backend.Consulta;

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
public class ConsultaController {
	@Autowired
	private ConsultaServiceProvider serviceProvider;
	
	@GetMapping("/consulta")
	List<Consulta> all() {
		return serviceProvider.getService().all();
	}

	@PostMapping("/consulta")
	Consulta newConsulta(@RequestBody Consulta newConsulta) {
		return serviceProvider.getService().newConsulta(newConsulta);
	}

	// Single item

	@GetMapping("/consulta/{id}")
	Consulta one(@PathVariable Integer id) {
		return serviceProvider.getService().one(id);
	}

	@PutMapping("/consulta/{id}")
	Consulta replaceConsulta(@RequestBody Consulta newConsulta, @PathVariable Integer id) {
		return serviceProvider.getService().replaceConsulta(newConsulta,id);
	}

	@DeleteMapping("/consulta/{id}")
	void deleteConsulta(@PathVariable Integer id) {
		serviceProvider.getService().deleteConsulta(id);
	}
}
