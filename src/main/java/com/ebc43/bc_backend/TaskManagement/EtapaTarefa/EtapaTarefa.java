package com.ebc43.bc_backend.TaskManagement.EtapaTarefa;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.Where;

import com.ebc43.bc_backend.AbstractEntity.UUIDAbstractEntity;
import com.ebc43.bc_backend.TaskManagement.EstadoTarefa.EstadoTarefa;
import com.ebc43.bc_backend.TaskManagement.EvidenciaTarefa.EvidenciaTarefa;
import com.ebc43.bc_backend.TaskManagement.Tarefa.Tarefa;
import com.ebc43.bc_backend.TaskManagement.UsuarioEtapaTarefaVista.UsuarioEtapaTarefaVista;
import com.ebc43.bc_backend.UserManagement.Usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="etapa_tarefa")
public class EtapaTarefa extends UUIDAbstractEntity {
	@ManyToOne
	@JoinColumn(name="tarefa_id",nullable=false)
	@JsonBackReference
	private Tarefa tarefa;
	@ManyToOne
	@JoinColumn(name="estado_tarefa_id",nullable=false)
	private EstadoTarefa estadoTarefa;
	@Column(name="data_hora", nullable=false)
	private Date dataHora;
	@OneToMany
	@JoinColumn(name="etapa_tarefa_id")
	@JsonManagedReference
	@SQLDelete(sql="update evidencia_tarefa set deleted_at = now() where etapa_tarefa_id=? and id=?")
	@SQLDeleteAll(sql="update evidencia_tarefa set deleted_at = now() where etapa_tarefa_id=?")
	@Where(clause="deleted_at is null")
	private List<EvidenciaTarefa> evidenciasTarefa; 
	@OneToMany
	@JoinColumn(name="etapa_tarefa_id")
	@JsonManagedReference
	@SQLDelete(sql="update usuario_etapa_tarefa_vista set deleted_at = now() where etapa_tarefa_id=? and id=?")
	@SQLDeleteAll(sql="update usuario_etapa_tarefa_vista set deleted_at = now() where etapa_tarefa_id=?")
	@Where(clause="deleted_at is null")
	private List<UsuarioEtapaTarefaVista> usuarioEtapaTarefaVistas; 
	@ManyToOne
	@JoinColumn(name="usuario_responsavel_id", nullable=false)
	private Usuario usuarioResponsavel;
	@Column(columnDefinition = "boolean default false", nullable = false)
	private Boolean prioridade;
	@Column(name= "is_prioridade_modified", columnDefinition = "boolean default false", nullable = false)
	private Boolean isPrioridadeModified;
	@Column(nullable=false)
	@Size(max=500)
	private String observacao;
	
	public EtapaTarefa() {
	}

	public EtapaTarefa(UUID id, Tarefa tarefa, EstadoTarefa estadoTarefa, Date dataHora,
			List<EvidenciaTarefa> evidenciasTarefa, List<UsuarioEtapaTarefaVista> usuarioEtapaTarefaVistas,
			Usuario usuarioResponsavel, Boolean prioridade, Boolean isPrioridadeModified,
			@Size(max = 500) String observacao, Date createdAt, Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.tarefa = tarefa;
		this.estadoTarefa = estadoTarefa;
		this.dataHora = dataHora;
		this.evidenciasTarefa = evidenciasTarefa;
		this.usuarioEtapaTarefaVistas = usuarioEtapaTarefaVistas;
		this.usuarioResponsavel = usuarioResponsavel;
		this.prioridade = prioridade;
		this.isPrioridadeModified = isPrioridadeModified;
		this.observacao = observacao;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public EstadoTarefa getEstadoTarefa() {
		return estadoTarefa;
	}

	public void setEstadoTarefa(EstadoTarefa estadoTarefa) {
		this.estadoTarefa = estadoTarefa;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public List<EvidenciaTarefa> getEvidenciasTarefa() {
		return evidenciasTarefa;
	}

	public void setEvidenciasTarefa(List<EvidenciaTarefa> evidenciasTarefa) {
		this.evidenciasTarefa = evidenciasTarefa;
	}

	public List<UsuarioEtapaTarefaVista> getUsuarioEtapaTarefaVistas() {
		return usuarioEtapaTarefaVistas;
	}

	public void setUsuarioEtapaTarefaVistas(List<UsuarioEtapaTarefaVista> usuarioEtapaTarefaVistas) {
		this.usuarioEtapaTarefaVistas = usuarioEtapaTarefaVistas;
	}

	public Usuario getUsuarioResponsavel() {
		return usuarioResponsavel;
	}

	public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
		this.usuarioResponsavel = usuarioResponsavel;
	}

	public Boolean getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Boolean prioridade) {
		this.prioridade = prioridade;
	}

	public Boolean getIsPrioridadeModified() {
		return isPrioridadeModified;
	}

	public void setIsPrioridadeModified(Boolean isPrioridadeModified) {
		this.isPrioridadeModified = isPrioridadeModified;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
