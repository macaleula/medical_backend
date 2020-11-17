package com.medical_app.bc_backend.MedicoMunicipio;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.medical_app.bc_backend.AbstractEntity.EntidadeAbstrata;
import com.medical_app.bc_backend.Municipio.Municipio;
import com.medical_app.bc_backend.Usuario.Usuario;

@Entity
@Table(name="medico_municipio")
public class MedicoMunicipio extends EntidadeAbstrata {
	@ManyToOne
	@JoinColumn(name="medico_id", nullable=false)
	private Usuario medico;
	@ManyToOne
	@JoinColumn(name="municipio_id", nullable=false)
	private Municipio municipio;
	
	public MedicoMunicipio() {
		
	}
	
	public MedicoMunicipio(Integer id, Usuario medico, Municipio municipio) {
		super(id);
		this.medico = medico;
		this.municipio = municipio;
	}

	public Usuario getMedico() {
		return medico;
	}

	public void setMedico(Usuario medico) {
		this.medico = medico;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
}
