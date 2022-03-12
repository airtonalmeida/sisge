
package br.org.ibmi.sisge.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.ibmi.sisge.business.*;
import br.org.ibmi.sisge.domain.*;
import javax.faces.model.*;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;
import java.util.*;

// To remove unused imports press: Ctrl+Shift+o

@ViewController
@PreviousView("./sexo_list.jsf")
public class SexoEditMB extends AbstractEditPageBean<Sexo, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private SexoBC sexoBC;
	

	
	@Override
	@Transactional
	public String delete() {
		this.sexoBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.sexoBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.sexoBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected Sexo handleLoad(Long id) {
		return this.sexoBC.load(id);
	}	
}