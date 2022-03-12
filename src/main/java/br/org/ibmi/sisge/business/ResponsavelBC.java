
package br.org.ibmi.sisge.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.org.ibmi.sisge.domain.*;

import java.util.*;

import javax.faces.model.*;

import br.org.ibmi.sisge.persistence.ResponsavelDAO;

// To remove unused imports press: Ctrl+Shift+o

@BusinessController
public class ResponsavelBC extends DelegateCrud<Responsavel, Long, ResponsavelDAO> {
	private static final long serialVersionUID = 1L;
	
	
	public List<Responsavel> completeText(String string){
		
		List<Responsavel> listaResponsaveis = getDelegate()
				.completeText(string);
		
		return listaResponsaveis;
	
	}
	
	public Responsavel verificaResponsavelExiste(Responsavel responsavel){
		
		Responsavel responsavelBD = getDelegate().
				verificaResponsavelExiste(responsavel);
	
		return responsavelBD;
	}
	
	
}
