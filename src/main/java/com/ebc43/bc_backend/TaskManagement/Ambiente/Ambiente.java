package com.ebc43.bc_backend.TaskManagement.Ambiente;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.Where;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;
import com.ebc43.bc_backend.BoatManagement.Embarcacao.Embarcacao;
import com.ebc43.bc_backend.TaskManagement.InterdicaoAmbiente.InterdicaoAmbiente;
import com.ebc43.bc_backend.TaskManagement.ModeloAmbiente.ModeloAmbiente;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="ambiente")
public class Ambiente extends IntegerIdAbstractEntity {
	@ManyToOne
	@JoinColumn(name="modelo_ambiente_id", nullable=false)
	private ModeloAmbiente modelo;
	@ManyToOne
	@JoinColumn(nullable=false)
	@JsonBackReference
	private Embarcacao embarcacao;
	@OneToMany
	@JoinColumn(name="ambiente_id")
	@OrderBy("dataMudanca ASC")
	@JsonManagedReference
	@SQLDelete(sql="update interdicao_ambiente set deleted_at = now() where ambiente_id=? and id=?")
	@SQLDeleteAll(sql="update interdicao_ambiente set deleted_at = now() where ambiente_id=?")
	@Where(clause="deleted_at is null")
	private List<InterdicaoAmbiente> interdicoesAmbiente;
	
	public Ambiente() {
	}

	public Ambiente(Integer id, ModeloAmbiente modelo, Embarcacao embarcacao,
			List<InterdicaoAmbiente> interdicoesAmbiente, Date createdAt, Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.modelo = modelo;
		this.embarcacao = embarcacao;
		this.interdicoesAmbiente = interdicoesAmbiente;
	} 

	public ModeloAmbiente getModelo() {
		return modelo;
	}

	public void setModelo(ModeloAmbiente modelo) {
		this.modelo = modelo;
	}

	public Embarcacao getEmbarcacao() {
		return embarcacao;
	}

	public void setEmbarcacao(Embarcacao embarcacao) {
		this.embarcacao = embarcacao;
	}

	public List<InterdicaoAmbiente> getInterdicoesAmbiente() {
		return interdicoesAmbiente;
	}

	public void setInterdicoesAmbiente(List<InterdicaoAmbiente> interdicoesAmbiente) {
		this.interdicoesAmbiente = interdicoesAmbiente;
	}


}
	