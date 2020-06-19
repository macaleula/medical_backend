package com.ebc43.bc_backend.BoatManagement.Municipio;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;
import com.ebc43.bc_backend.BoatManagement.EstadoFederacao.EstadoFederacao;

@Entity
@Table(name="municipio")
@AttributeOverride(name="id", column=@Column(name="codigo_ibge"))
public class Municipio extends IntegerIdAbstractEntity {
	@ManyToOne
	@JoinColumn(name="codigo_uf", nullable=false)
	private EstadoFederacao uf;
	@Column(nullable = false)
	@Size(max=45)
	private String nome;
	@Column(nullable = false)
	private Float latitude;
	@Column(nullable = false)
	private Float longitude;
	@Column(nullable = false)
	private Boolean capital;
	
	public Municipio() {
		super();
	}

	public Municipio(Integer codigoIbge, EstadoFederacao uf, @Size(max = 45) String nome, Float latitude,
			Float longitude, Boolean capital, Date createdAt, Date updatedAt, Date deletedAt) {
		super(codigoIbge, createdAt, updatedAt, deletedAt);
		this.uf = uf;
		this.nome = nome;
		this.latitude = latitude;
		this.longitude = longitude;
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

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Boolean getCapital() {
		return capital;
	}

	public void setCapital(Boolean capital) {
		this.capital = capital;
	}
	
}