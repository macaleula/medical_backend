package com.ebc43.bc_backend.TaskManagement.EstadoTarefa;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;

@Entity
@Table(name="estado_tarefa")
public class EstadoTarefa extends IntegerIdAbstractEntity {
	@Column(nullable=false)
	@Size(max=45)
	private String nome;
	@Size(max = 999)
	@Column(nullable=false)
	private String descricao;
	
	public EstadoTarefa() {
	}

	public EstadoTarefa(Integer id, @Size(max = 45) String nome, @Size(max = 999) String descricao, Date createdAt,
			Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}