package com.ebc43.bc_backend.TaskManagement.AtributoEquipamento;

import java.util.UUID;

import com.ebc43.bc_backend.SoftDeleteRepository.UUIDSoftDeleteCrudRepository;

public interface AtributoEquipamentoRepository extends UUIDSoftDeleteCrudRepository<AtributoEquipamento, UUID>{
	
}