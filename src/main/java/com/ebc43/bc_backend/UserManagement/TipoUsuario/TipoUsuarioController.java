package com.ebc43.bc_backend.UserManagement.TipoUsuario;

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
public class TipoUsuarioController {
	@Autowired
	private TipoUsuarioService service;
	@GetMapping("/tipo_usuario")
	List<TipoUsuario> all() {
		return service.all();
	}

	@PostMapping("/tipo_usuario")
	TipoUsuario newTipoUsuario(@RequestBody TipoUsuario newTipoUsuario) {
		return service.newTipoUsuario(newTipoUsuario);
	}

	// Single item

	@GetMapping("/tipo_usuario/{id}")
	TipoUsuario one(@PathVariable Integer id) {
		return service.one(id);
	}

	@PutMapping("/tipo_usuario/{id}")
	TipoUsuario replaceTipoUsuario(@RequestBody TipoUsuario newTipoUsuario, @PathVariable Integer id) {
		return service.replaceTipoUsuario(newTipoUsuario,id);
	}

	@DeleteMapping("/tipo_usuario/{id}")
	void deleteTipoUsuario(@PathVariable Integer id) {
		service.deleteTipoUsuario(id);
	}
}
