package com.ebc43.bc_backend.BoatManagement.ModeloEmbarcacao;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;
import com.ebc43.bc_backend.TaskManagement.Marca.Marca;

@Entity
@Table(name="modelo_embarcacao")
public class ModeloEmbarcacao extends IntegerIdAbstractEntity {
	@ManyToOne
	@JoinColumn(name="marca_id",nullable=false)
	private Marca marca;
	@Column(nullable = false)
	@Size(max=45)
	private String nome;
	@Column(nullable = false)
	private Double tamanho_pes;
	
	public ModeloEmbarcacao() {
		super();
	}

	public ModeloEmbarcacao(Integer id, Marca marca, @Size(max = 45) String nome,
			Double tamanho_pes, Date createdAt, Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.marca = marca;
		this.nome = nome;
		this.tamanho_pes = tamanho_pes;
	}
	
	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getTamanho_pes() {
		return tamanho_pes;
	}

	public void setTamanho_pes(Double tamanho_pes) {
		this.tamanho_pes = tamanho_pes;
	}
	
}