package com.ebc43.bc_backend.TaskManagement.ModeloEquipamento;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.Where;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;
import com.ebc43.bc_backend.TaskManagement.ModeloAtributoEquipamento.ModeloAtributoEquipamento;
import com.ebc43.bc_backend.TaskManagement.PropriedadeModeloEquipamento.PropriedadeModeloEquipamento;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="modelo_equipamento")
public class ModeloEquipamento extends IntegerIdAbstractEntity {
	@Column(nullable=false)
	@Size(max=45)
	private String marca;
	@Column(nullable=false)
	@Size(max=45)
	private String modelo;
	@Column(name="precisa_horimetro",nullable=false)
	private Boolean precisaHorimetro;
	@OneToMany
	@JoinColumn(name="modelo_equipamento_id")
	@JsonManagedReference
	@SQLDelete(sql="update modelo_atributo_equipamento set deleted_at = now() where modelo_equipamento_id=? and id=?")
	@SQLDeleteAll(sql="update modelo_atributo_equipamento set deleted_at = now() where modelo_equipamento_id=?")
	@Where(clause="deleted_at is null")
	private List<ModeloAtributoEquipamento> modelosAtributosEquipamento;
	@OneToMany
	@JoinColumn(name="modelo_equipamento_id")
	@JsonManagedReference
	@SQLDelete(sql="update propriedade_modelo_equipamento set deleted_at = now() where modelo_equipamento_id=? and id=?")
	@SQLDeleteAll(sql="update propriedade_modelo_equipamento set deleted_at = now() where modelo_equipamento_id=?")
	@Where(clause="deleted_at is null")
	private List<PropriedadeModeloEquipamento> propriedadesModeloEquipamento;
	
	public ModeloEquipamento() {
	}

	public ModeloEquipamento(Integer id, @Size(max = 45) String marca, @Size(max = 45) String modelo,
			Boolean precisaHorimetro, List<ModeloAtributoEquipamento> modelosAtributosEquipamento,
			List<PropriedadeModeloEquipamento> propriedadesModeloEquipamento, Date createdAt, Date updatedAt,
			Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.marca = marca;
		this.modelo = modelo;
		this.precisaHorimetro = precisaHorimetro;
		this.modelosAtributosEquipamento = modelosAtributosEquipamento;
		this.propriedadesModeloEquipamento = propriedadesModeloEquipamento;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Boolean getPrecisaHorimetro() {
		return precisaHorimetro;
	}

	public void setPrecisaHorimetro(Boolean precisaHorimetro) {
		this.precisaHorimetro = precisaHorimetro;
	}

	public List<ModeloAtributoEquipamento> getModelosAtributosEquipamento() {
		return modelosAtributosEquipamento;
	}

	public void setModelosAtributosEquipamento(List<ModeloAtributoEquipamento> modelosAtributosEquipamento) {
		this.modelosAtributosEquipamento = modelosAtributosEquipamento;
	}

	public List<PropriedadeModeloEquipamento> getPropriedadesModeloEquipamento() {
		return propriedadesModeloEquipamento;
	}

	public void setPropriedadesModeloEquipamento(List<PropriedadeModeloEquipamento> propriedadesModeloEquipamento) {
		this.propriedadesModeloEquipamento = propriedadesModeloEquipamento;
	}
		
}