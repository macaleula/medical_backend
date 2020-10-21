package com.medical_app.bc_backend.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	@Query("SELECT u FROM Usuario u WHERE u.username = :username")
	public Optional<Usuario> findByUserName(String username);
}