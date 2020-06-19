package com.ebc43.bc_backend.TaskManagement.Tarefa;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.Where;

import com.ebc43.bc_backend.AbstractEntity.UUIDAbstractEntity;
import com.ebc43.bc_backend.TaskManagement.ComplementoTarefaGenerica.ComplementoTarefaGenerica;
import com.ebc43.bc_backend.TaskManagement.Equipamento.Equipamento;
import com.ebc43.bc_backend.TaskManagement.EtapaTarefa.EtapaTarefa;
import com.ebc43.bc_backend.TaskManagement.MarinheiroEscalado.MarinheiroEscalado;
import com.ebc43.bc_backend.TaskManagement.ModeloTarefa.ModeloTarefa;
import com.ebc43.bc_backend.UserManagement.Usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="tarefa")
public class Tarefa extends UUIDAbstractEntity {
	@ManyToOne
	@JoinColumn(name="modelo_tarefa_id",nullable=false)
	private ModeloTarefa modeloTarefa;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Equipamento equipamento;
	@OneToMany
	@JoinColumn(name="tarefa_id")
	@OrderBy("estadoTarefa.id ASC")
	@JsonManagedReference
	@SQLDelete(sql="update etapa_tarefa set deleted_at = now() where tarefa_id=? and id=?")
	@SQLDeleteAll(sql="update etapa_tarefa set deleted_at = now() where tarefa_id=?")
	@Where(clause="deleted_at is null")
	private List<EtapaTarefa> etapaTarefa; 
	@Column(name="data_agendada",nullable=false)
	private Date dataAgendada;
	@Column(name="data_inicio_janela",nullable=false)
	private Date dataInicioJanela;
	@Column(name="data_conclusao_planejada",nullable=false)
	private Date dataConclusaoPlanejada;
	@ManyToOne
	@JoinColumn(name="responsavel_agendamento_id",nullable=false)
	private Usuario responsavelAgendamento;
	@OneToMany
	@JoinColumn(name="tarefa_id")
	@JsonManagedReference
	@SQLDelete(sql="update marinheiro_escalado set deleted_at = now() where tarefa_id=? and id=?")
	@SQLDeleteAll(sql="update marinheiro_escalado set deleted_at = now() where tarefa_id=?")
	@Where(clause="deleted_at is null")
	private List<MarinheiroEscalado> marinheirosEscalados;
	@OneToOne(mappedBy="tarefa")
	@JoinColumn
	@JsonManagedReference
	@SQLDelete(sql="update complemento_tarefa_generica set deleted_at = now() where tarefa_id=? and id=?")
	@SQLDeleteAll(sql="update complemento_tarefa_generica set deleted_at = now() where tarefa_id=?")
	@Where(clause="deleted_at is null")
	private ComplementoTarefaGenerica complementoTarefaGenerica;
	
	public Tarefa() {
		super();
	}

	public Tarefa(UUID id, ModeloTarefa modeloTarefa, Equipamento equipamento, List<EtapaTarefa> etapaTarefa,
			Date dataAgendada, Date dataInicioJanela, Date dataConclusaoPlanejada, Usuario responsavelAgendamento,
			List<MarinheiroEscalado> marinheirosEscalados, ComplementoTarefaGenerica complementoTarefaGenerica,
			Date createdAt, Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.modeloTarefa = modeloTarefa;
		this.equipamento = equipamento;
		this.etapaTarefa = etapaTarefa;
		this.dataAgendada = dataAgendada;
		this.dataInicioJanela = dataInicioJanela;
		this.dataConclusaoPlanejada = dataConclusaoPlanejada;
		this.responsavelAgendamento = responsavelAgendamento;
		this.marinheirosEscalados = marinheirosEscalados;
		this.complementoTarefaGenerica = complementoTarefaGenerica;
	}

	public ModeloTarefa getModeloTarefa() {
		return modeloTarefa;
	}

	public void setModeloTarefa(ModeloTarefa modeloTarefa) {
		this.modeloTarefa = modeloTarefa;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public List<EtapaTarefa> getEtapaTarefa() {
		return etapaTarefa;
	}

	public void setEtapaTarefa(List<EtapaTarefa> etapaTarefa) {
		this.etapaTarefa = etapaTarefa;
	}

	public Date getDataAgendada() {
		return dataAgendada;
	}

	public void setDataAgendada(Date dataAgendada) {
		this.dataAgendada = dataAgendada;
	}

	public Date getDataInicioJanela() {
		return dataInicioJanela;
	}

	public void setDataInicioJanela(Date dataInicioJanela) {
		this.dataInicioJanela = dataInicioJanela;
	}

	public Date getDataConclusaoPlanejada() {
		return dataConclusaoPlanejada;
	}

	public void setDataConclusaoPlanejada(Date dataConclusaoPlanejada) {
		this.dataConclusaoPlanejada = dataConclusaoPlanejada;
	}

	public Usuario getResponsavelAgendamento() {
		return responsavelAgendamento;
	}

	public void setResponsavelAgendamento(Usuario responsavelAgendamento) {
		this.responsavelAgendamento = responsavelAgendamento;
	}

	public List<MarinheiroEscalado> getMarinheirosEscalados() {
		return marinheirosEscalados;
	}

	public void setMarinheirosEscalados(List<MarinheiroEscalado> marinheirosEscalados) {
		this.marinheirosEscalados = marinheirosEscalados;
	}

	public ComplementoTarefaGenerica getComplementoTarefaGenerica() {
		return complementoTarefaGenerica;
	}

	public void setComplementoTarefaGenerica(ComplementoTarefaGenerica complementoTarefaGenerica) {
		this.complementoTarefaGenerica = complementoTarefaGenerica;
	}

}	
	
	