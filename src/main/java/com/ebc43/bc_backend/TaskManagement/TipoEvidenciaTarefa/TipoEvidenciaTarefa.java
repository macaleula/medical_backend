package com.ebc43.bc_backend.TaskManagement.TipoEvidenciaTarefa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;

@Table(name="tipo_evidencia_tarefa")
@Entity
public class TipoEvidenciaTarefa extends IntegerIdAbstractEntity {
	@Column(nullable = false)
	@Size(max=45)
	private String nome;
	
	public TipoEvidenciaTarefa() {
	}

	public TipoEvidenciaTarefa(Integer id, @Size(max = 45) String nome, Date createdAt, Date updatedAt,
			Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
