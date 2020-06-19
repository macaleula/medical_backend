package com.ebc43.bc_backend.TaskManagement.ComplementoTarefaGenerica;

import java.util.UUID;

import com.ebc43.bc_backend.SoftDeleteRepository.UUIDSoftDeleteCrudRepository;

public interface ComplementoTarefaGenericaRepository extends UUIDSoftDeleteCrudRepository<ComplementoTarefaGenerica, UUID>{
}