package com.medical_app.bc_backend.MedicoMunicipio;

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
public class MedicoMunicipioController {
	@Autowired
	private MedicoMunicipioService service;
	@GetMapping("/medico_municipio")
	List<MedicoMunicipio> all() {
		return service.all();
	}

	@PostMapping("/medico_municipio")
	MedicoMunicipio newMedicoMunicipio(@RequestBody MedicoMunicipio newMedicoMunicipio) {
		return service.newMedicoMunicipio(newMedicoMunicipio);
	}

	// Single item

	@GetMapping("/medico_municipio/{id}")
	MedicoMunicipio one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/medico_municipio/{id}")
	MedicoMunicipio replaceMedicoMunicipio(@RequestBody MedicoMunicipio newMedicoMunicipio, @PathVariable Integer id) {
		return service.replaceMedicoMunicipio(newMedicoMunicipio,id);
	}

	@DeleteMapping("/medico_municipio/{id}")
	void deleteMedicoMunicipio(@PathVariable Integer id) {
		service.deleteMedicoMunicipio(id);
	}
}
