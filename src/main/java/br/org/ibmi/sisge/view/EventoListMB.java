package br.org.ibmi.sisge.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.ibmi.sisge.business.EventoBC;
import br.org.ibmi.sisge.domain.Evento;

@ViewController
@NextView("./evento_edit.jsf")
@PreviousView("./evento_list.jsf")
public class EventoListMB extends AbstractListPageBean<Evento, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EventoBC eventoBC;
	
	@Override
	protected List<Evento> handleResultList() {
		return this.eventoBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				eventoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}