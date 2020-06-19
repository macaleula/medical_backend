package com.ebc43.bc_backend.UserManagement.TipoUsuario;

import com.ebc43.bc_backend.SoftDeleteRepository.IntegerIdSoftDeleteCrudRepository;
import com.ebc43.bc_backend.UserManagement.TipoUsuario.TipoUsuario;

public interface TipoUsuarioRepository extends IntegerIdSoftDeleteCrudRepository<TipoUsuario, Integer>{
}