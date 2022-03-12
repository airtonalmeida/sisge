package br.org.ibmi.sisge.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.ibmi.sisge.business.SexoBC;
import br.org.ibmi.sisge.domain.Sexo;

@ViewController
@NextView("./sexo_edit.jsf")
@PreviousView("./sexo_list.jsf")
public class SexoListMB extends AbstractListPageBean<Sexo, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private SexoBC sexoBC;
	
	@Override
	protected List<Sexo> handleResultList() {
		return this.sexoBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				sexoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}