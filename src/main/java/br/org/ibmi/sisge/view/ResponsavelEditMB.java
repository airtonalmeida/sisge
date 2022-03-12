
package br.org.ibmi.sisge.view;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.ibmi.sisge.domain.Base;
import br.org.ibmi.sisge.domain.Ministerio;
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
@PreviousView("./responsavel_list.jsf")
public class ResponsavelEditMB extends AbstractEditPageBean<Responsavel, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ResponsavelBC responsavelBC;
	
	private List<Ministerio> ministerios = new ArrayList<Ministerio>();	

	@Inject
	private BaseBC baseBC;
	
	public List<Base> getBaseList(){
		return baseBC.findAll();
	}
			
	@Inject
	private MinisterioBC ministerioBC;
	
	/*public List<Ministerio> getMinisterioList(){
		return ministerioBC.findAll();
	}*/
			
	@Inject
	private SexoBC sexoBC;
	
	public List<Sexo> getSexoList(){
		return sexoBC.findAll();
	}
			
	
	@Override
	@Transactional
	public String delete() {
		this.responsavelBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		
		if (this.getBean().getNome() == ""){

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"AVISO", "Infome o nome!");

			RequestContext.getCurrentInstance().showMessageInDialog(message);

			return null;

		}else if(this.getBean().getMinisterio()==null){
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"AVISO", "Infome o Ministério!");

			RequestContext.getCurrentInstance().showMessageInDialog(message);

			return null;
			
		}else {

			boolean responsavelExiste;

			responsavelExiste = this.verificaResponsavelExiste();

			if (responsavelExiste == false) {

				this.responsavelBC.insert(this.getBean());
				
				return getPreviousView();
				

			} else {

				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO, "AVISO",
						"Não foi possível inserir! Responsável já cadastrado.");

				RequestContext.getCurrentInstance()
						.showMessageInDialog(message);

				return null;
			}

		}
	}
	
	@Override
	@Transactional
	public String update() {
		
		
		if (this.getBean().getNome() == ""){

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"AVISO", "Infome o nome!");

			RequestContext.getCurrentInstance().showMessageInDialog(message);

			return null;

		}else if(this.getBean().getMinisterio()==null){
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"AVISO", "Infome o Ministério!");

			RequestContext.getCurrentInstance().showMessageInDialog(message);

			return null;
			
		}else {

			boolean responsavelExiste;

			responsavelExiste = this.verificaResponsavelExiste();

			if (responsavelExiste == false) {

				this.responsavelBC.update(this.getBean());
				
				return getPreviousView();
				

			} else {

				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO, "AVISO",
						"Não foi possível inserir! Responsável já cadastrado.");

				RequestContext.getCurrentInstance()
						.showMessageInDialog(message);

				return null;
			}

		}
	}
	
	@Override
	protected Responsavel handleLoad(Long id) {
		return this.responsavelBC.load(id);
	}	
	
	@Transactional
	public void atualizaMinisterio(){
		
		//setMinisteriosList(this.getBean().getBase().getMinisterios());
		this.getBean();
		setMinisteriosList(this.ministerioBC.consultarMinisterioPorBaseBC(this.getBean().getBase()));
			
	}
	
	public void setMinisteriosList(List<Ministerio> ministerios) {
		this.ministerios = ministerios;
	}
	
	public List<Ministerio> getMinisteriosList() {
		
		if (this.getBean().getMinisterio() != null) {
			
			atualizaMinisterio();
					
		}
		return ministerios;
	}
	
	
	public Boolean verificaResponsavelExiste(){
		boolean resultado;
		
		Responsavel responsavelBD = this.responsavelBC.verificaResponsavelExiste(this.getBean());
		
		if(responsavelBD==null){
			
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