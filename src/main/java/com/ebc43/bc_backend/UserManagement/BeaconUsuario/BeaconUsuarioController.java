package com.ebc43.bc_backend.UserManagement.BeaconUsuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebc43.bc_backend.UserManagement.BeaconUsuario.BeaconUsuario;
import com.ebc43.bc_backend.UserManagement.BeaconUsuario.BeaconUsuarioService;

@RestController
public class BeaconUsuarioController {
	@Autowired
	private BeaconUsuarioService service;
	@GetMapping("/beacon_usuario")
	List<BeaconUsuario> all() {
		return service.all();
	}

	@PostMapping("/beacon_usuario")
	BeaconUsuario newBeaconUsuario(@RequestBody BeaconUsuario newBeaconUsuario) {
		return service.newBeaconUsuario(newBeaconUsuario);
	}

	// Single item

	@GetMapping("/beacon_usuario/{id}")
	BeaconUsuario one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/beacon_usuario/{id}")
	BeaconUsuario replaceBeaconUsuario(@RequestBody BeaconUsuario newBeaconUsuario, @PathVariable Integer id) {
		return service.replaceBeaconUsuario(newBeaconUsuario,id);
	}

	@DeleteMapping("/beacon_usuario/{id}")
	void deleteBeaconUsuario(@PathVariable Integer id) {
		service.deleteBeaconUsuario(id);
	}
}
