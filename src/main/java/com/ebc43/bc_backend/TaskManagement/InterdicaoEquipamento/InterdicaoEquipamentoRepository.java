package com.ebc43.bc_backend.TaskManagement.InterdicaoEquipamento;

import java.util.UUID;

import com.ebc43.bc_backend.SoftDeleteRepository.UUIDSoftDeleteCrudRepository;

public interface InterdicaoEquipamentoRepository extends UUIDSoftDeleteCrudRepository<InterdicaoEquipamento, UUID>{
}