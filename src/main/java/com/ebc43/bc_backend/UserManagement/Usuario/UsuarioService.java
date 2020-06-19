package com.ebc43.bc_backend.UserManagement.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ebc43.bc_backend.BoatManagement.EmbarcacaoProprietario.EmbarcacaoProprietarioRepository;
import com.ebc43.bc_backend.RoutineSaylor.EmbarcacaoMarinheiro.EmbarcacaoMarinheiroRepository;
import com.ebc43.bc_backend.UserManagement.InformacoesSensiveis.InformacoesSensiveis;
import com.ebc43.bc_backend.UserManagement.InformacoesSensiveis.InformacoesSensiveisRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
	private final UsuarioRepository repository;
	private final InformacoesSensiveisRepository informacoesSensiveisRepository;
	private final EmbarcacaoProprietarioRepository embarcacaoProprietarioRepository;
	private final EmbarcacaoMarinheiroRepository embarcacaoMarinheiroRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UsuarioService(UsuarioRepository repository, InformacoesSensiveisRepository informacoesSensiveisRepository,
		EmbarcacaoProprietarioRepository embarcacaoProprietarioRepository,
		EmbarcacaoMarinheiroRepository embarcacaoMarinheiroRepository) {
		this.repository = repository;
		this.informacoesSensiveisRepository = informacoesSensiveisRepository;
		this.embarcacaoProprietarioRepository = embarcacaoProprietarioRepository;
		this.embarcacaoMarinheiroRepository = embarcacaoMarinheiroRepository;
	}

	List<Usuario> all() {
		return (List<Usuario>) repository.findAll();
	}

	Usuario newUsuario(Usuario newUsuario) {
		if(informacoesSensiveisRepository.findByUserName(newUsuario.getInformacoesSensiveis().getUsername()).isPresent()) {
			throw new UsernameAlreadyExistAuthenticationException(newUsuario.getInformacoesSensiveis().getUsername());
		}
		InformacoesSensiveis newInformacoesSensiveis = newUsuario.getInformacoesSensiveis();
		// PASSWORD ENCODER
		newInformacoesSensiveis.setPassword(passwordEncoder.encode(newInformacoesSensiveis.getPassword()));
		newInformacoesSensiveis.setCreatedAt(new Date());
		newUsuario.setInformacoesSensiveis(informacoesSensiveisRepository.save(newInformacoesSensiveis));
		newUsuario.setCreatedAt(new Date());
	    return repository.save(newUsuario);
    }

	Usuario one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new UsuarioNotFoundException(id));
	}
	
	Usuario one(String username) {
		return repository.findByUserName(username)
				.orElseThrow(() -> new UsuarioNotFoundException(username));
	}

	Usuario replaceUsuario(Usuario entity, Integer id) {
		Optional<Usuario> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteUsuario(Integer id) {
		Usuario u = repository.findById(id).get();
		informacoesSensiveisRepository.deleteById(u.getInformacoesSensiveis().getId());
		if(u.getTipo().getNome() == "PR") {
			embarcacaoProprietarioRepository.deleteByProprietarioId(id);
		} else if(u.getTipo().getNome() == "MR") {
			embarcacaoMarinheiroRepository.deleteByMarinheiroId(id);
		}
		repository.deleteById(id);
	}

}