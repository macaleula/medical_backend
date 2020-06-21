package com.ebc43.bc_backend.TaskManagement.Marca;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;

@Entity
@Table(name="marca")
public class Marca extends IntegerIdAbstractEntity {
	@Column(nullable=false)
	@Size(max=45)
	private String nome;

	public Marca() {
		super();
	}

	public Marca(Integer id, Date createdAt, Date updatedAt, Date deleted,
			String nome) {
		super(id, createdAt, updatedAt, deleted);
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
