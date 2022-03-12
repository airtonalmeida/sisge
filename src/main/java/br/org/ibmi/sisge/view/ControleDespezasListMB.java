package br.org.ibmi.sisge.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.ibmi.sisge.business.ControleDespezasBC;
import br.org.ibmi.sisge.domain.ControleDespezas;

@ViewController
@NextView("./controleDespezas_edit.jsf")
@PreviousView("./controleDespezas_list.jsf")
public class ControleDespezasListMB extends AbstractListPageBean<ControleDespezas, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ControleDespezasBC controleDespezasBC;
	
	@Override
	protected List<ControleDespezas> handleResultList() {
		return this.controleDespezasBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				controleDespezasBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}