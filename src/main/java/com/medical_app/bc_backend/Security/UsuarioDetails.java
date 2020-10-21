package com.medical_app.bc_backend.Security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.medical_app.bc_backend.TipoUsuario.TipoUsuario;
import com.medical_app.bc_backend.Usuario.Usuario;

public class UsuarioDetails implements UserDetails{
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private TipoUsuario tipoUsuario;
	private List<GrantedAuthority> authorities;
	
	public UsuarioDetails() {
	}
	
	public UsuarioDetails(Usuario usuario) {
		this.userName = usuario.getUsername();
		this.password = usuario.getPassword();
		this.tipoUsuario = usuario.getTipoUsuario();
		this.authorities = Arrays.stream(usuario.getTipoUsuario().getNome().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
	
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
}
