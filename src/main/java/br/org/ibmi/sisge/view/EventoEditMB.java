
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
@PreviousView("./evento_list.jsf")
public class EventoEditMB extends AbstractEditPageBean<Evento, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EventoBC eventoBC;
	

	@Inject
	private ResponsavelBC responsavelBC;
	
	public List<Responsavel> getResponsavelList(){
		return responsavelBC.findAll();
	}
			
	
	@Override
	@Transactional
	public String delete() {
		this.eventoBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
				
		this.eventoBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.eventoBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected Evento handleLoad(Long id) {
		return this.eventoBC.load(id);
	}
	
	public List<Responsavel> completeText(String string) {
        List<Responsavel> results = new ArrayList<Responsavel>();
       
        results = this.responsavelBC.completeText(string);
        
        return results;
    }
	
}