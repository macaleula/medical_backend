package com.ebc43.bc_backend.RoutineSaylor.DiaSemana;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;

@Entity
@Table(name="dia_semana")
public class DiaSemana extends IntegerIdAbstractEntity {
	@Column(nullable=false)
	@Size(max=45)
	private String nome;
	
	public DiaSemana() {
	}

	public DiaSemana(Integer id, @Size(max = 45) String nome, Date createdAt, Date updatedAt, Date deletedAt) {
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