package com.ebc43.bc_backend.BoatManagement.Marina;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;
import com.ebc43.bc_backend.BoatManagement.Municipio.Municipio;

@Entity
@Table(name="marina")
public class Marina extends IntegerIdAbstractEntity {
	@ManyToOne
	@JoinColumn(name="municipio_id", nullable=false)
	private Municipio municipio;
	@Column(nullable = false)
	@Size(max=45)
	private String nome;
	@Size(max=255)
	private String endereco;
	@Size(max=15)
	private String telefone;
	@Size(max=255)
	private String email;
	
	public Marina() {
		super();
	}

	public Marina(Integer id, Municipio municipio, @Size(max = 45) String nome, @Size(max = 255) String endereco,
			@Size(max = 15) String telefone, @Size(max = 255) String email, Date createdAt, Date updatedAt,
			Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.municipio = municipio;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}
	
	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
