package com.ebc43.bc_backend.TaskManagement.UnidadeMedida;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;
import com.ebc43.bc_backend.TaskManagement.Grandeza.Grandeza;

@Entity
@Table(name="unidade_medida")
public class UnidadeMedida extends IntegerIdAbstractEntity {
	@ManyToOne
	@JoinColumn(name="grandeza_id", nullable=false)
	private Grandeza grandeza;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String simbolo;
	
	public UnidadeMedida() {
	}

	public UnidadeMedida(Integer id, Grandeza grandeza, String nome, String simbolo, Date createdAt, Date updatedAt,
			Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.grandeza = grandeza;
		this.nome = nome;
		this.simbolo = simbolo;
	}

	public Grandeza getGrandeza() {
		return grandeza;
	}

	public void setGrandeza(Grandeza grandeza) {
		this.grandeza = grandeza;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

}
