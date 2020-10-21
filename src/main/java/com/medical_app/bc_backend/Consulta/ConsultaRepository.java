package com.medical_app.bc_backend.Consulta;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ConsultaRepository extends CrudRepository<Consulta, Integer>{
	
	@Query("SELECT c FROM Consulta c WHERE c.medico.username = :username")
	List<Consulta> findAllByMedicoUsername(String username);
	
	@Query("SELECT c FROM Consulta c WHERE c.paciente.username = :username")
	List<Consulta> findAllByPacienteUsername(String username);

}
