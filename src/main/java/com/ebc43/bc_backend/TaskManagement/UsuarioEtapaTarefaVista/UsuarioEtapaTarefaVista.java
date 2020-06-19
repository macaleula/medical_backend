package com.ebc43.bc_backend.TaskManagement.UsuarioEtapaTarefaVista;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ebc43.bc_backend.AbstractEntity.UUIDAbstractEntity;
import com.ebc43.bc_backend.TaskManagement.EtapaTarefa.EtapaTarefa;
import com.ebc43.bc_backend.UserManagement.Usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="usuario_etapa_tarefa_vista")
public class UsuarioEtapaTarefaVista extends UUIDAbstractEntity {
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name="etapa_tarefa_id")
	@JsonBackReference
	private EtapaTarefa etapaTarefa;
	
	public UsuarioEtapaTarefaVista() {
	}

	public UsuarioEtapaTarefaVista(UUID id, Usuario usuario, EtapaTarefa etapaTarefa, Date createdAt, Date updatedAt,
			Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.usuario = usuario;
		this.etapaTarefa = etapaTarefa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public EtapaTarefa getEtapaTarefa() {
		return etapaTarefa;
	}

	public void setEtapaTarefa(EtapaTarefa etapaTarefa) {
		this.etapaTarefa = etapaTarefa;
	}

}
