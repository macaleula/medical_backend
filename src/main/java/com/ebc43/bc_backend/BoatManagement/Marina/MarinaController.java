package com.ebc43.bc_backend.BoatManagement.Marina;

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
public class MarinaController {
	@Autowired
	private MarinaService service;
	@GetMapping("/marina")
	List<Marina> all() {
		return service.all();
	}

	@PostMapping("/marina")
	Marina newMarina(@RequestBody Marina newMarina) {
		return service.newMarina(newMarina);
	}

	// Single item

	@GetMapping("/marina/{id}")
	Marina one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/marina/{id}")
	Marina replaceMarina(@RequestBody Marina newMarina, @PathVariable Integer id) {
		return service.replaceMarina(newMarina,id);
	}

	@DeleteMapping("/marina/{id}")
	void deleteMarina(@PathVariable Integer id) {
		service.deleteMarina(id);
	}
}