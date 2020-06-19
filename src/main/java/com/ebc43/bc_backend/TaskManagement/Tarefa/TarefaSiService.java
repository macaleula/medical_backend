package com.ebc43.bc_backend.TaskManagement.Tarefa;

import org.springframework.stereotype.Service;

import com.ebc43.bc_backend.BoatManagement.Embarcacao.EmbarcacaoRepository;
import com.ebc43.bc_backend.TaskManagement.Ambiente.AmbienteRepository;
import com.ebc43.bc_backend.TaskManagement.EtapaTarefa.EtapaTarefaRepository;
import com.ebc43.bc_backend.TaskManagement.EvidenciaTarefa.EvidenciaTarefaRepository;
import com.ebc43.bc_backend.TaskManagement.MarinheiroEscalado.MarinheiroEscaladoRepository;

@Service
public class TarefaSiService extends TarefaService {
	
	public TarefaSiService(TarefaRepository repository, EtapaTarefaRepository etapaTarefaRepository,
			EvidenciaTarefaRepository evidenciaTarefaRepository,
			MarinheiroEscaladoRepository marinheiroEscaladoRepository, EmbarcacaoRepository embarcacaoRepository,
			AmbienteRepository ambienteRepository) {
		super(repository, etapaTarefaRepository, evidenciaTarefaRepository, marinheiroEscaladoRepository, embarcacaoRepository,
				ambienteRepository);
	}

	@Override
	Tarefa findUltimaFinalizadaByModeloTarefa(Integer modeloTarefaId) {
		// TODO Auto-generated method stub
		return null;
	}


}
