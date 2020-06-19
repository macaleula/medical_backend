package com.ebc43.bc_backend.BoatManagement.EmbarcacaoProprietario;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;
import com.ebc43.bc_backend.BoatManagement.Embarcacao.Embarcacao;
import com.ebc43.bc_backend.UserManagement.Usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="embarcacao_proprietario")
public class EmbarcacaoProprietario extends IntegerIdAbstractEntity {
	@ManyToOne
	@JoinColumn(name="proprietario_id",nullable=false)
	private Usuario proprietario;
	@ManyToOne
	@JoinColumn(name="embarcacao_id",nullable=false)
	@JsonBackReference
	private Embarcacao embarcacao;
	
	public EmbarcacaoProprietario() {
	}

	public EmbarcacaoProprietario(Integer id, Usuario proprietario, Embarcacao embarcacao, Date createdAt,
			Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.proprietario = proprietario;
		this.embarcacao = embarcacao;
	}

	public Usuario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Usuario proprietario) {
		this.proprietario = proprietario;
	}

	public Embarcacao getEmbarcacao() {
		return embarcacao;
	}

	public void setEmbarcacao(Embarcacao embarcacao) {
		this.embarcacao = embarcacao;
	}
}
