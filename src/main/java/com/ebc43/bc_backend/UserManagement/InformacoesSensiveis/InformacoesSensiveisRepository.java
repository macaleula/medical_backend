package com.ebc43.bc_backend.UserManagement.InformacoesSensiveis;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.ebc43.bc_backend.SoftDeleteRepository.IntegerIdSoftDeleteCrudRepository;
import com.ebc43.bc_backend.UserManagement.Usuario.Usuario;

public interface InformacoesSensiveisRepository extends IntegerIdSoftDeleteCrudRepository<InformacoesSensiveis, Integer>{
	@Query("SELECT i FROM InformacoesSensiveis i WHERE i.username = :username")
	public Optional<Usuario> findByUserName(String username);
}