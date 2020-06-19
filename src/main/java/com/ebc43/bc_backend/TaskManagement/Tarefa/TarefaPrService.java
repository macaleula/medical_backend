package com.ebc43.bc_backend.TaskManagement.Tarefa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ebc43.bc_backend.BoatManagement.Embarcacao.Embarcacao;
import com.ebc43.bc_backend.BoatManagement.Embarcacao.EmbarcacaoRepository;
import com.ebc43.bc_backend.TaskManagement.Ambiente.Ambiente;
import com.ebc43.bc_backend.TaskManagement.Ambiente.AmbienteRepository;
import com.ebc43.bc_backend.TaskManagement.EtapaTarefa.EtapaTarefaRepository;
import com.ebc43.bc_backend.TaskManagement.EvidenciaTarefa.EvidenciaTarefaRepository; 
import com.ebc43.bc_backend.TaskManagement.MarinheiroEscalado.MarinheiroEscaladoRepository;
import com.ebc43.bc_backend.Utils.AuthenticationUtil;
import com.ebc43.bc_backend.Utils.MemberUtil;

@Service
public class TarefaPrService extends TarefaService {

	public TarefaPrService(TarefaRepository repository, EtapaTarefaRepository etapaTarefaRepository,
			EvidenciaTarefaRepository evidenciaTarefaRepository,
			MarinheiroEscaladoRepository marinheiroEscaladoRepository, EmbarcacaoRepository embarcacaoRepository,
			AmbienteRepository ambienteRepository) {
		super(repository, etapaTarefaRepository, evidenciaTarefaRepository, marinheiroEscaladoRepository, embarcacaoRepository,
				ambienteRepository);
	}

	@Override
	List<Tarefa> all() {
		ArrayList<Tarefa> tarefas = (ArrayList<Tarefa>) super.getRepository().findOperantesByPrUsername(AuthenticationUtil.getPrincipalUsername(super.getAuthenticationFacade()));
		List<Tarefa> tarefasEmExecucao = (ArrayList<Tarefa>) getTarefasEmExecucao(tarefas);
		tarefasEmExecucao = getTarefasNaoInterditadas(tarefasEmExecucao);
		return tarefasEmExecucao;
	}

	@Override
	protected List<Tarefa> operantesByEmbarcacaoId(Integer embarcacaoId) {
		List<Embarcacao> embarcacoes = super.getEmbarcacaoRepository()
				.findByPrUsername(AuthenticationUtil.getPrincipalUsername(super.getAuthenticationFacade()));
		if(MemberUtil.isEmbarcacaoMember(embarcacaoId, embarcacoes)) {	
			return super.operantesByEmbarcacaoId(embarcacaoId);
		} else {
			return null;
		}		
	}

	@Override
	List<Tarefa> historicoByEmbarcacaoId(Integer embarcacaoId) {
		List<Embarcacao> embarcacoes = super.getEmbarcacaoRepository()
				.findByPrUsername(AuthenticationUtil.getPrincipalUsername(super.getAuthenticationFacade()));
		if(MemberUtil.isEmbarcacaoMember(embarcacaoId, embarcacoes)) {	
			return super.historicoByEmbarcacaoId(embarcacaoId);
		} else {
			return null;
		}		
	}

	@Override
	protected List<Tarefa> operantesByAmbienteId(Integer ambienteId) {
		List<Ambiente> ambientes = super.getAmbienteRepository()
				.findByPrUsername(AuthenticationUtil.getPrincipalUsername(super.getAuthenticationFacade()));
		if(MemberUtil.isAmbienteMember(ambienteId, ambientes)) {
			return super.operantesByAmbienteId(ambienteId);
		} else {
			return null;
		}
	}
	
	@Override
	List<Tarefa> historicoByAmbienteId(Integer ambienteId) {
		List<Ambiente> ambientes = super.getAmbienteRepository()
				.findByPrUsername(AuthenticationUtil.getPrincipalUsername(super.getAuthenticationFacade()));
		if(MemberUtil.isAmbienteMember(ambienteId, ambientes)) {
			return super.historicoByAmbienteId(ambienteId);
		} else {
			return null;
		}
	}

	@Override
	Tarefa findUltimaFinalizadaByModeloTarefa(Integer modeloTarefaId) {
		String username = super.getPrincipalUsername();
		List<Tarefa> list = super.getRepository().findFinalizadasByModeloTarefaAndPrUsername(modeloTarefaId, username);
		return list.get(0);
	}
	
	
}
