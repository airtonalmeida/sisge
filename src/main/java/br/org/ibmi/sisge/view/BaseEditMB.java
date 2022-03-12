
package br.org.ibmi.sisge.view;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.ibmi.sisge.business.*;
import br.org.ibmi.sisge.domain.*;

import javax.faces.application.FacesMessage;
import javax.faces.model.*;

import org.primefaces.context.RequestContext;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import java.util.*;

// To remove unused imports press: Ctrl+Shift+o

@ViewController
@PreviousView("./base_list.jsf")
public class BaseEditMB extends AbstractEditPageBean<Base, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private BaseBC baseBC;
	

	private DataModel<Ministerio> ministerioList;
	
	public void addMinisterio() {
		this.getBean().getMinisterios().add(new Ministerio());
	}
	public void deleteMinisterio() {
	   this.getBean().getMinisterios().remove(getMinisterioList().getRowData());
	}
	public DataModel<Ministerio> getMinisterioList() {
	   if (ministerioList == null) {
		   ministerioList = new ListDataModel<Ministerio>(this.getBean().getMinisterios());
	   }
	   return ministerioList;
	} 
	
	@Override
	@Transactional
	public String delete() {
		this.baseBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
				
		if(this.getBean().getDescricao()==""){
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO", "Infome a Base!");
			
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			
			return null;
			
		}else{
		
			boolean baseExiste;
			
			baseExiste = this.verificaBaseExiste();
			
			if(baseExiste == false){
								
				this.baseBC.insert(this.getBean());
				
				return getPreviousView();
									
			}else{
				
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO", "Não foi possível inserir! Base já cadastrada.");
				
				RequestContext.getCurrentInstance().showMessageInDialog(message);
				
				return null;
			}
		
		}
	}
	
	@Override
	@Transactional
	public String update() {
				
		if(this.getBean().getDescricao()==""){
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO", "Infome a Base!");
			
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			
			return null;
			
		}else{
		
			boolean baseExiste;
			
			baseExiste = this.verificaBaseExiste();
			
			if(baseExiste == false){
								
				this.baseBC.update(this.getBean());
				
				return getPreviousView();
									
			}else{
				
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO", "Não foi possível inserir! Base já cadastrada.");
				
				RequestContext.getCurrentInstance().showMessageInDialog(message);
				
				return null;
			}
		
		}
	}
	
	@Override
	protected Base handleLoad(Long id) {
		return this.baseBC.load(id);
	}	
	
	public Boolean verificaBaseExiste(){
		boolean resultado;
		
		Base baseBD = this.baseBC.verificaBaseExiste(this.getBean());
		
		if(baseBD==null){
			
			resultado = false;
			
		}else{
			
			resultado = true;
		}
		
		return resultado;
	}
	
	public String cancelar() {
		return getPreviousView();
	}
	
}