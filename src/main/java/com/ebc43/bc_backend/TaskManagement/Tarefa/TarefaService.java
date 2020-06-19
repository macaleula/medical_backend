package com.ebc43.bc_backend.TaskManagement.Tarefa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.ebc43.bc_backend.BoatManagement.Embarcacao.EmbarcacaoRepository;
import com.ebc43.bc_backend.Security.IAuthenticationFacade;
import com.ebc43.bc_backend.TaskManagement.Ambiente.AmbienteRepository;
import com.ebc43.bc_backend.TaskManagement.EtapaTarefa.EtapaTarefa;
import com.ebc43.bc_backend.TaskManagement.EtapaTarefa.EtapaTarefaRepository;
import com.ebc43.bc_backend.TaskManagement.EvidenciaTarefa.EvidenciaTarefaRepository;
import com.ebc43.bc_backend.TaskManagement.InterdicaoAmbiente.InterdicaoAmbiente;
import com.ebc43.bc_backend.TaskManagement.InterdicaoEquipamento.InterdicaoEquipamento;
import com.ebc43.bc_backend.TaskManagement.MarinheiroEscalado.MarinheiroEscaladoRepository;
import com.ebc43.bc_backend.Utils.AuthenticationUtil;

public abstract class TarefaService {
	@Autowired
    private IAuthenticationFacade authenticationFacade;
	
	private final TarefaRepository repository;
	private final EtapaTarefaRepository etapaTarefaRepository;
	private final EvidenciaTarefaRepository evidenciaTarefaRepository;
	private final MarinheiroEscaladoRepository marinheiroEscaladoRepository;
	private final EmbarcacaoRepository embarcacaoRepository;
	private final AmbienteRepository ambienteRepository;

	public TarefaService(TarefaRepository repository, EtapaTarefaRepository etapaTarefaRepository,
			EvidenciaTarefaRepository evidenciaTarefaRepository,
			MarinheiroEscaladoRepository marinheiroEscaladoRepository, EmbarcacaoRepository embarcacaoRepository,
			AmbienteRepository ambienteRepository) {
		this.repository = repository;
		this.etapaTarefaRepository = etapaTarefaRepository;
		this.evidenciaTarefaRepository = evidenciaTarefaRepository;
		this.marinheiroEscaladoRepository = marinheiroEscaladoRepository;
		this.embarcacaoRepository = embarcacaoRepository;
		this.ambienteRepository = ambienteRepository;
	}

	List<Tarefa> all() {
		return (List<Tarefa>) repository.findAll();
	}
	
	List<Tarefa> allByEmbarcacaoId(Integer embarcacaoId) {
		return (List<Tarefa>) repository.findAllByEmbarcacao(embarcacaoId);
	}
	
	List<Tarefa> operantesByEmbarcacaoId(Integer embarcacaoId) {
		List<Tarefa> tarefas = repository.findAllByEmbarcacao(embarcacaoId);
		List<Tarefa> tarefasEmExecucao = (ArrayList<Tarefa>) getTarefasEmExecucao(tarefas);
		tarefasEmExecucao = getTarefasNaoInterditadas(tarefasEmExecucao);
		
		return tarefasEmExecucao;
	}
	
	List<Tarefa> historicoByEmbarcacaoId(Integer embarcacaoId) {
		List<Tarefa> tarefas = repository.findAllByEmbarcacao(embarcacaoId);
		List<Tarefa> tarefasFinalizadasOuCanceladas = getTarefasFinalizadasOuCanceladas(tarefas);
		
		return tarefasFinalizadasOuCanceladas;
	}

	List<Tarefa> allByAmbienteId(Integer ambienteId) {
		return (List<Tarefa>) repository.findAllByAmbiente(ambienteId);
	}
	
	List<Tarefa> operantesByAmbienteId(Integer ambienteId) {
		ArrayList<Tarefa> tarefas = (ArrayList<Tarefa>) repository.findAllByAmbiente(ambienteId);
		List<Tarefa> tarefasEmExecucao = (ArrayList<Tarefa>) getTarefasEmExecucao(tarefas);
		tarefasEmExecucao = getTarefasNaoInterditadas(tarefasEmExecucao);
		
		return tarefasEmExecucao;
	}
	
	List<Tarefa> historicoByAmbienteId(Integer ambienteId) {
		ArrayList<Tarefa> tarefas = (ArrayList<Tarefa>) repository.findAllByAmbiente(ambienteId);
		List<Tarefa> tarefasFinalizadasOuCanceladas = (ArrayList<Tarefa>) getTarefasFinalizadasOuCanceladas(tarefas);
		
		return tarefasFinalizadasOuCanceladas;
	}
	
	abstract Tarefa findUltimaFinalizadaByModeloTarefa(Integer modeloTarefaId);

	Tarefa newTarefa(Tarefa newTarefa) {
		newTarefa.setCreatedAt(new Date());
	    return repository.save(newTarefa);
    }

	Tarefa one(UUID id) {
		return repository.findById(id)
				.orElseThrow(() -> new TarefaNotFoundException(id));
	}

	Tarefa replaceTarefa(Tarefa entity, UUID id) {
		Optional<Tarefa> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteTarefa(UUID id) {
		repository.deleteById(id);
	}
	
	protected IAuthenticationFacade getAuthenticationFacade() {
		return authenticationFacade;
	}

	protected TarefaRepository getRepository() {
		return repository;
	}

	protected EtapaTarefaRepository getEtapaTarefaRepository() {
		return etapaTarefaRepository;
	}

	protected EvidenciaTarefaRepository getEvidenciaTarefaRepository() {
		return evidenciaTarefaRepository;
	}

	protected MarinheiroEscaladoRepository getMarinheiroEscaladoRepository() {
		return marinheiroEscaladoRepository;
	}
	
	public EmbarcacaoRepository getEmbarcacaoRepository() {
		return embarcacaoRepository;
	}

	public AmbienteRepository getAmbienteRepository() {
		return ambienteRepository;
	}
	
	protected List<Tarefa> getTarefasFinalizadasOuCanceladas(List<Tarefa> tarefas) {
		ArrayList<Tarefa> FinalizadasOuCanceladas = new ArrayList<Tarefa>();
		boolean isFound;
		for(Tarefa t : tarefas) {
			isFound = false;
			for(EtapaTarefa et: t.getEtapaTarefa()) {
				if((et.getEstadoTarefa().getId() == 13 || et.getEstadoTarefa().getId() == 14) && !isFound) {
					FinalizadasOuCanceladas.add(t);
					isFound = true;
				}
			}
		}
		return FinalizadasOuCanceladas;
	}
	
	protected List<Tarefa> getTarefasEmExecucao(List<Tarefa> tarefas) {
		ArrayList<Tarefa> tarefasEmExecucao = new ArrayList<Tarefa>();
		boolean finished;
		for(Tarefa t : tarefas) {
			finished = false;
			for(EtapaTarefa et: t.getEtapaTarefa()) {
				if(et.getEstadoTarefa().getId() == 13 || et.getEstadoTarefa().getId() == 14) {
					finished = true;
				}
			}
			if(!finished) {
				tarefasEmExecucao.add(t);
			}
		}
		return tarefasEmExecucao;
	}
	
	protected List<Tarefa> getTarefasNaoInterditadas(List<Tarefa> tarefas) {
		ArrayList<Tarefa> tarefasEmExecucao = new ArrayList<Tarefa>();
		List<InterdicaoAmbiente> interdicoesAmbiente;
		List<InterdicaoEquipamento> interdicoesEquipamento;
		for(Tarefa t : tarefas) {
			interdicoesAmbiente = t.getEquipamento().getAmbiente().getInterdicoesAmbiente();
			interdicoesEquipamento = t.getEquipamento().getInterdicoesEquipamento();
			
			if(!isUltimaInterdicaoAmbiente(interdicoesAmbiente)) {
				if(!isUltimaInterdicaoEquipamento(interdicoesEquipamento)) {
					tarefasEmExecucao.add(t);
				}
			}
		}
		return tarefasEmExecucao;
	}

	private boolean isUltimaInterdicaoAmbiente(List<InterdicaoAmbiente> interdicoesAmbiente) {
		if(interdicoesAmbiente.size() == 0) {
			return false;
		} else {
			return interdicoesAmbiente.get(interdicoesAmbiente.size() - 1).getInterditado();
		}
	}
	
	private boolean isUltimaInterdicaoEquipamento(List<InterdicaoEquipamento> interdicoesEquipamento) {
		if(interdicoesEquipamento.size() == 0) {
			return false;
		} else {
			return interdicoesEquipamento.get(interdicoesEquipamento.size() - 1).getInterditado();
		}
	}

	String getPrincipalUsername() {
		return AuthenticationUtil.getPrincipalUsername(authenticationFacade);
	}
}
