package br.org.ibmi.sisge.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.ibmi.sisge.business.ResponsavelBC;
import br.org.ibmi.sisge.domain.Responsavel;

@ViewController
@NextView("./responsavel_edit.jsf")
@PreviousView("./responsavel_list.jsf")
public class ResponsavelListMB extends AbstractListPageBean<Responsavel, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ResponsavelBC responsavelBC;
	
	@Override
	protected List<Responsavel> handleResultList() {
		return this.responsavelBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				responsavelBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}