package com.ebc43.bc_backend.TaskManagement.Grandeza;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;

@Entity
@Table(name="grandeza")
public class Grandeza extends IntegerIdAbstractEntity {
	@Column(nullable=false)
	private String nome;
	
	public Grandeza() {
	}

	public Grandeza(Integer id, String nome, Date createdAt, Date updatedAt, Date deletedAt) {
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
