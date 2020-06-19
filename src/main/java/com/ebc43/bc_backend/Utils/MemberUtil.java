package com.ebc43.bc_backend.Utils;

import java.util.List;

import com.ebc43.bc_backend.BoatManagement.Embarcacao.Embarcacao;
import com.ebc43.bc_backend.TaskManagement.Ambiente.Ambiente;

public class MemberUtil {
	public static boolean isEmbarcacaoMember(Integer embarcacaoId, List<Embarcacao> embarcacoes) {
		boolean isMember = false;
		for(Embarcacao e : embarcacoes) {
			if(e.getId() == embarcacaoId) {
				isMember = true;
			}
		}
		return isMember;
	}
	
	public static boolean isAmbienteMember(Integer ambienteId, List<Ambiente> ambientes) {
		boolean isMember = false;
		for(Ambiente a : ambientes) {
			if(a.getId() == ambienteId) {
				isMember = true;
			}
		}
		return isMember;
	}
}
