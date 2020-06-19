package com.ebc43.bc_backend.TaskManagement.ModeloEvidenciaTarefa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;
import com.ebc43.bc_backend.TaskManagement.TipoEvidenciaTarefa.TipoEvidenciaTarefa;

@Entity
@Table(name="modelo_evidencia_tarefa")
public class ModeloEvidenciaTarefa extends IntegerIdAbstractEntity {
	@ManyToOne
	@JoinColumn(name="tipo_evidencia_tarefa_id", nullable=false)
	private TipoEvidenciaTarefa tipoEvidenciaTarefa;
	@Column(nullable=false)
	@Size(max=45)
	private String nome;
	@Column(nullable=false)
	@Size(max=500)
	private String descricao;
	@Column(name="duracao")
	private Integer duracao;
	@Column(name="necessita_observacao",nullable=false)
	private Boolean necessitaObservacao;
	@Column(name="endereco_instrucao", nullable=false)
	private String enderecoInstrucao;
	
	public ModeloEvidenciaTarefa() {
		super();
	}

	public ModeloEvidenciaTarefa(Integer id, TipoEvidenciaTarefa tipoEvidenciaTarefa, @Size(max = 45) String nome,
			@Size(max = 500) String descricao, Integer duracao, Boolean necessitaObservacao, String enderecoInstrucao,
			Date createdAt, Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.tipoEvidenciaTarefa = tipoEvidenciaTarefa;
		this.nome = nome;
		this.descricao = descricao;
		this.duracao = duracao;
		this.necessitaObservacao = necessitaObservacao;
		this.enderecoInstrucao = enderecoInstrucao;
	}

	public TipoEvidenciaTarefa getTipoEvidenciaTarefa() {
		return tipoEvidenciaTarefa;
	}

	public void setTipoEvidenciaTarefa(TipoEvidenciaTarefa tipoEvidenciaTarefa) {
		this.tipoEvidenciaTarefa = tipoEvidenciaTarefa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Boolean getNecessitaObservacao() {
		return necessitaObservacao;
	}

	public void setNecessitaObservacao(Boolean necessitaObservacao) {
		this.necessitaObservacao = necessitaObservacao;
	}

	public String getEnderecoInstrucao() {
		return enderecoInstrucao;
	}

	public void setEnderecoInstrucao(String enderecoInstrucao) {
		this.enderecoInstrucao = enderecoInstrucao;
	}
	
}
