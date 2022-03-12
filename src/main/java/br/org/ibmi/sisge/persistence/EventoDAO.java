package br.org.ibmi.sisge.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import br.org.ibmi.sisge.domain.Evento;

@PersistenceController
public class EventoDAO extends JPACrud<Evento, Long> {

	private static final long serialVersionUID = 1L;
	

}
