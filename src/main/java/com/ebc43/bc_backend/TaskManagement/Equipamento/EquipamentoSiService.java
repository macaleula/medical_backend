package com.ebc43.bc_backend.TaskManagement.Equipamento;

import org.springframework.stereotype.Service;

import com.ebc43.bc_backend.BoatManagement.Embarcacao.EmbarcacaoRepository;
import com.ebc43.bc_backend.TaskManagement.Ambiente.AmbienteRepository;

@Service
public class EquipamentoSiService extends EquipamentoService {

	public EquipamentoSiService(EquipamentoRepository repository, EmbarcacaoRepository embarcacaoRepository,
			AmbienteRepository ambienteRepository) {
		super(repository, embarcacaoRepository, ambienteRepository);
	}


}
