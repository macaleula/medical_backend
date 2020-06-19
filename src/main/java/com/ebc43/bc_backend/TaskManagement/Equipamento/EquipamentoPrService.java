package com.ebc43.bc_backend.TaskManagement.Equipamento;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ebc43.bc_backend.BoatManagement.Embarcacao.Embarcacao;
import com.ebc43.bc_backend.BoatManagement.Embarcacao.EmbarcacaoRepository;
import com.ebc43.bc_backend.TaskManagement.Ambiente.Ambiente;
import com.ebc43.bc_backend.TaskManagement.Ambiente.AmbienteRepository;
import com.ebc43.bc_backend.Utils.AuthenticationUtil;
import com.ebc43.bc_backend.Utils.MemberUtil;

@Service
public class EquipamentoPrService extends EquipamentoService {

	public EquipamentoPrService(EquipamentoRepository repository, EmbarcacaoRepository embarcacaoRepository,
			AmbienteRepository ambienteRepository) {
		super(repository, embarcacaoRepository, ambienteRepository);
	}

	@Override
	List<Equipamento> all() {
		return super.getRepository().findAllByPrUsername(AuthenticationUtil.getPrincipalUsername(super.getAuthenticationFacade()));
	}

	@Override
	List<Equipamento> allByEmbarcacaoId(Integer embarcacaoId) {
		List<Embarcacao> embarcacoes = super.getEmbarcacaoRepository()
				.findByPrUsername(AuthenticationUtil.getPrincipalUsername(super.getAuthenticationFacade()));
		if(MemberUtil.isEmbarcacaoMember(embarcacaoId, embarcacoes)) {	
			return super.allByEmbarcacaoId(embarcacaoId);
		} else {
			return null;
		}		
	}

	@Override
	List<Equipamento> allByAmbienteId(Integer ambienteId) {
		List<Ambiente> ambientes = super.getAmbienteRepository()
				.findByPrUsername(AuthenticationUtil.getPrincipalUsername(super.getAuthenticationFacade()));
		if(MemberUtil.isAmbienteMember(ambienteId, ambientes)) {
			return super.allByAmbienteId(ambienteId);
		} else {
			return null;
		}
	}
	
	
	
}
