package com.ebc43.bc_backend.BoatManagement.EstadoFederacao;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;

@Entity
@Table(name="estado_federacao")
@AttributeOverride(name="id", column=@Column(name="codigo_uf"))
public class EstadoFederacao extends IntegerIdAbstractEntity {
	@Column(nullable = false)
	@Size(max=45)
	private String nome;
	@Column(name="uf",nullable=false)
	private String sigla;
	
	EstadoFederacao() {
		super();
	}

	public EstadoFederacao(Integer id, @Size(max = 45) String nome, String sigla, Date createdAt, Date updatedAt,
			Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.nome = nome;
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
}
