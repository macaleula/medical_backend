package com.medical_app.bc_backend.Consulta;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.medical_app.bc_backend.AbstractEntity.EntidadeAbstrata;
import com.medical_app.bc_backend.Usuario.Usuario;

@Entity
@Table(name="consulta")
public class Consulta extends EntidadeAbstrata {
	@ManyToOne
	@JoinColumn(name="medico_id")
	private Usuario medico;
	@ManyToOne
	@JoinColumn(name="paciente_id")
	private Usuario paciente;
	@Column(name="data")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Date data;
	
	public Consulta() {
		
	}
	
	public Consulta(Integer id, Usuario medico, Usuario paciente,
			Date data) 
	{
		super(id);
		this.medico = medico;
		this.paciente = paciente;
		this.data = data;
	}

	public Usuario getMedico() {
		return medico;
	}

	public void setMedico(Usuario medico) {
		this.medico = medico;
	}

	public Usuario getPaciente() {
		return paciente;
	}

	public void setPaciente(Usuario paciente) {
		this.paciente = paciente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	
}
