package com.medical_app.bc_backend.Municipio;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.medical_app.bc_backend.AbstractEntity.EntidadeAbstrata;
import com.medical_app.bc_backend.EstadoFederacao.EstadoFederacao;

@Entity
@Table(name="municipio")
@AttributeOverride(name="id", column=@Column(name="codigo_ibge"))
public class Municipio extends EntidadeAbstrata {
	@ManyToOne
	@JoinColumn(name="codigo_uf", nullable=false)
	private EstadoFederacao uf;
	@Column(nullable = false)
	@Size(max=45)
	private String nome;
	@Column(nullable = false)
	private Boolean capital;
	
	public Municipio() {
		super();
	}

	public Municipio(Integer codigoIbge, EstadoFederacao uf, @Size(max = 45) String nome, 
			Boolean capital) {
		super(codigoIbge);
		this.uf = uf;
		this.nome = nome;
		this.capital = capital;
	}

	public Integer getCodigoIbge() {
		return super.getId();
	}

	public void setCodigoIbge(Integer codigoIbge) {
		super.setId(codigoIbge);
	}

	public EstadoFederacao getUf() {
		return uf;
	}

	public void setUf(EstadoFederacao uf) {
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getCapital() {
		return capital;
	}

	public void setCapital(Boolean capital) {
		this.capital = capital;
	}
	
}