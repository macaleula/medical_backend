package com.ebc43.bc_backend.UserManagement.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import com.ebc43.bc_backend.SoftDeleteRepository.IntegerIdSoftDeleteCrudRepository;
import com.ebc43.bc_backend.UserManagement.Usuario.Usuario;

public interface UsuarioRepository extends IntegerIdSoftDeleteCrudRepository<Usuario, Integer>{
	@Query("SELECT u FROM Usuario u WHERE u.informacoesSensiveis.username = :username")
	public Optional<Usuario> findByUserName(String username);
}