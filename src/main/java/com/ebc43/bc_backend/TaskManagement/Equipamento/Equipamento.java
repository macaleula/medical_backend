package com.ebc43.bc_backend.TaskManagement.Equipamento;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.Where;

import com.ebc43.bc_backend.AbstractEntity.UUIDAbstractEntity;
import com.ebc43.bc_backend.TaskManagement.Ambiente.Ambiente;
import com.ebc43.bc_backend.TaskManagement.AtributoEquipamento.AtributoEquipamento;
import com.ebc43.bc_backend.TaskManagement.InterdicaoEquipamento.InterdicaoEquipamento;
import com.ebc43.bc_backend.TaskManagement.ModeloEquipamento.ModeloEquipamento;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="equipamento")
public class Equipamento extends UUIDAbstractEntity {
	@ManyToOne
	@JoinColumn(name="modelo_equipamento_id", nullable=false)
	private ModeloEquipamento modelo;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Ambiente ambiente;
	@OneToMany
	@JoinColumn(name="equipamento_id")
	@OrderBy("dataMudanca ASC")
	@JsonManagedReference
	@SQLDelete(sql="update interdicao_equipamento set deleted_at = now() where equipamento_id=? and id=?")
	@SQLDeleteAll(sql="update interdicao_equipamento set deleted_at = now() where equipamento_id=?")
	@Where(clause="deleted_at is null")
	private List<InterdicaoEquipamento> interdicoesEquipamento;
	@OneToMany
	@JoinColumn(name="equipamento_id")
	@JsonManagedReference
	@SQLDelete(sql="update atributo_equipamento set deleted_at = now() where equipamento_id=? and id=?")
	@SQLDeleteAll(sql="update atributo_equipamento set deleted_at = now() where equipamento_id=?")
	@Where(clause="deleted_at is null")
	private List<AtributoEquipamento> atributosEquipamento;
	
	public Equipamento() {
	}

	public Equipamento(UUID id, ModeloEquipamento modelo, Ambiente ambiente,
			List<InterdicaoEquipamento> interdicoesEquipamento, List<AtributoEquipamento> atributosEquipamento,
			Date createdAt, Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.modelo = modelo;
		this.ambiente = ambiente;
		this.interdicoesEquipamento = interdicoesEquipamento;
		this.atributosEquipamento = atributosEquipamento;
	}

	public ModeloEquipamento getModelo() {
		return modelo;
	}

	public void setModelo(ModeloEquipamento modelo) {
		this.modelo = modelo;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public List<InterdicaoEquipamento> getInterdicoesEquipamento() {
		return interdicoesEquipamento;
	}

	public void setInterdicoesEquipamento(List<InterdicaoEquipamento> interdicoesEquipamento) {
		this.interdicoesEquipamento = interdicoesEquipamento;
	}

	public List<AtributoEquipamento> getAtributosEquipamento() {
		return atributosEquipamento;
	}

	public void setAtributosEquipamento(List<AtributoEquipamento> atributosEquipamento) {
		this.atributosEquipamento = atributosEquipamento;
	}

}	
