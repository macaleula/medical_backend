package com.ebc43.bc_backend.UserManagement.BeaconUsuario;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;
import com.ebc43.bc_backend.UserManagement.Usuario.Usuario;

@Entity
@Table(name="beacon_usuario")
public class BeaconUsuario extends IntegerIdAbstractEntity {
	@OneToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	@Column(name="data_beacon")
	private Date dataBeacon;
	
	public BeaconUsuario() {
	}

	public BeaconUsuario(Integer id, Usuario usuario, Date dataBeacon, Date createdAt, Date updatedAt,
			Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.usuario = usuario;
		this.dataBeacon = dataBeacon;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getDataBeacon() {
		return dataBeacon;
	}

	public void setDataBeacon(Date dataBeacon) {
		this.dataBeacon = dataBeacon;
	}

}
