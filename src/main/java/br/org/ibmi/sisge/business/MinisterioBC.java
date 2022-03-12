
package br.org.ibmi.sisge.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.org.ibmi.sisge.domain.*;

import java.util.*;

import javax.faces.model.*;
import javax.persistence.Query;

import br.org.ibmi.sisge.persistence.MinisterioDAO;

// To remove unused imports press: Ctrl+Shift+o

@BusinessController
public class MinisterioBC extends DelegateCrud<Ministerio, Long, MinisterioDAO> {
	private static final long serialVersionUID = 1L;
	
	public List<Ministerio> consultarMinisterioPorBaseBC(Base base){
		
		List<Ministerio> listaMinisterios = getDelegate()
				.consultarMinisterioPorBase(base);
		
		return listaMinisterios;
	
	}
	
	
	public Ministerio verificaMinisterioExiste(Ministerio ministerio){
		
		Ministerio ministerioBD = getDelegate().
				verificaMinisterioExiste(ministerio);
	
		return ministerioBD;
	}
}
