package com.medical_app.bc_backend.Usuario;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medical_app.bc_backend.Security.UsuarioDetailsService;
import com.medical_app.bc_backend.Security.Model.AuthenticationRequest;
import com.medical_app.bc_backend.Security.Model.AuthenticationResponse;
import com.medical_app.bc_backend.Utils.JwtUtil;



@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private UsuarioDetailsService usuarioDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@GetMapping("/usuario")
	List<Usuario> all() {
		return service.all();
	}

	@PostMapping("/usuario")
	Usuario newUsuario(@RequestBody Usuario newUsuario) {
		return service.newUsuario(newUsuario);
	}

	// Single item

	@GetMapping("/usuario/{id}")
	Usuario one(@PathVariable Integer id) {
		return service.one(id);
	}
	
	@GetMapping("/usuario/username/{username}")
	Usuario getByUserName(@PathVariable String username) {
		return service.one(username);
	}

	@PutMapping("/usuario/{id}")
	Usuario replaceUsuario(@RequestBody Usuario newUsuario, @PathVariable Integer id) {
		return service.replaceUsuario(newUsuario,id);
	}

	@DeleteMapping("/usuario/{id}")
	void deleteUsuario(@PathVariable Integer id) {
		service.deleteUsuario(id);
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password.",e);
		}
		final UserDetails userDetails = usuarioDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	@PostMapping("/create_usuario")
	public Usuario registerNewUsuario(@RequestBody Usuario newUsuario) throws Exception {
		return service.newUsuario(newUsuario);
	}
}