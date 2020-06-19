package com.ebc43.bc_backend.TaskManagement.Grandeza;

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
public class GrandezaController {
	@Autowired
	private GrandezaService service;
	
	@GetMapping("/grandeza")
	List<Grandeza> all() {
		return service.all();
	}

	@PostMapping("/grandeza")
	Grandeza newGrandeza(@RequestBody Grandeza newGrandeza) {
		return service.newGrandeza(newGrandeza);
	}

	// Single item

	@GetMapping("/grandeza/{id}")
	Grandeza one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/grandeza/{id}")
	Grandeza replaceGrandeza(@RequestBody Grandeza newGrandeza, @PathVariable Integer id) {
		return service.replaceGrandeza(newGrandeza,id);
	}

	@DeleteMapping("/grandeza/{id}")
	void deleteGrandeza(@PathVariable Integer id) {
		service.deleteGrandeza(id);
	}
}
