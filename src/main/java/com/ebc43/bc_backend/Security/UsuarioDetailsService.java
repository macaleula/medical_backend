package com.ebc43.bc_backend.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ebc43.bc_backend.UserManagement.Usuario.Usuario;
import com.ebc43.bc_backend.UserManagement.Usuario.UsuarioRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService{

	@Autowired
	UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> user = repository.findByUserName(username);

		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
		
		return user.map(UsuarioDetails::new).get();
	}

	
}
