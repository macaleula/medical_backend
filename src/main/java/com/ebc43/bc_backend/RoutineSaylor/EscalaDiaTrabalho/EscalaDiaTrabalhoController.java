package com.ebc43.bc_backend.RoutineSaylor.EscalaDiaTrabalho;

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
public class EscalaDiaTrabalhoController {
	@Autowired
	private EscalaDiaTrabalhoService service;
	@GetMapping("/escala_dia_trabalho")
	List<EscalaDiaTrabalho> all() {
		return service.all();
	}
	
	@PostMapping("/escala_dia_trabalho")
	EscalaDiaTrabalho newEscalaDiaTrabalho(@RequestBody EscalaDiaTrabalho newEscalaDiaTrabalho) {    
		return service.newEscalaDiaTrabalho(newEscalaDiaTrabalho);
	}
	
	// Single item
	
	@GetMapping("/escala_dia_trabalho/{id}")
	EscalaDiaTrabalho one(@PathVariable UUID id) {
		return service.one(id);
	}
	
	@PutMapping("/escala_dia_trabalho/{id}")
	EscalaDiaTrabalho replaceEscalaDiaTrabalho(@RequestBody EscalaDiaTrabalho newEscalaDiaTrabalho, @PathVariable UUID id) {
		return service.replaceEscalaDiaTrabalho(newEscalaDiaTrabalho, id);
	}
	
	@DeleteMapping("/escala_dia_trabalho/{id}")
	void deleteEscalaDiaTrabalho(@PathVariable UUID id) {
		service.deleteEscalaDiaTrabalho(id);
	}

}
