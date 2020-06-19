package com.ebc43.bc_backend.TaskManagement.InterdicaoAmbiente;

import java.util.UUID;

import com.ebc43.bc_backend.SoftDeleteRepository.UUIDSoftDeleteCrudRepository;

public interface InterdicaoAmbienteRepository extends UUIDSoftDeleteCrudRepository<InterdicaoAmbiente, UUID>{
	
}