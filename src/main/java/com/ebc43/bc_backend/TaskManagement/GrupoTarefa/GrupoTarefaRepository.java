package com.ebc43.bc_backend.TaskManagement.GrupoTarefa;

import java.util.UUID;

import com.ebc43.bc_backend.SoftDeleteRepository.UUIDSoftDeleteCrudRepository;

public interface GrupoTarefaRepository extends UUIDSoftDeleteCrudRepository<GrupoTarefa, UUID>{
}