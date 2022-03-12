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
@PreviousView("./ministerio_list.jsf")
public class MinisterioEditMB extends AbstractEditPageBean<Ministerio, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private MinisterioBC ministerioBC;

	@Inject
	private BaseBC baseBC;

	public List<Base> getBaseList() {
		return baseBC.findAll();
	}

	@Override
	@Transactional
	public String delete() {
		this.ministerioBC.delete(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {

		if (this.getBean().getDescricao() == ""){

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"AVISO", "Infome o Ministério!");

			RequestContext.getCurrentInstance().showMessageInDialog(message);

			return null;

		}else if(this.getBean().getBase()==null){
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"AVISO", "Infome a Base!");

			RequestContext.getCurrentInstance().showMessageInDialog(message);

			return null;
			
		}else {

			boolean ministerioExiste;

			ministerioExiste = this.verificaMinisterioExiste();

			if (ministerioExiste == false) {

				this.ministerioBC.insert(this.getBean());

				return getPreviousView();

			} else {

				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO, "AVISO",
						"Não foi possível inserir! Ministério já cadastrado.");

				RequestContext.getCurrentInstance()
						.showMessageInDialog(message);

				return null;
			}

		}

	}

	@Override
	@Transactional
	public String update() {

		if (this.getBean().getDescricao() == ""){

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"AVISO", "Infome o Ministério!");

			RequestContext.getCurrentInstance().showMessageInDialog(message);

			return null;

		}else if(this.getBean().getBase()==null){
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"AVISO", "Infome a Base!");

			RequestContext.getCurrentInstance().showMessageInDialog(message);

			return null;
			
		} else {

			boolean ministerioExiste;

			ministerioExiste = this.verificaMinisterioExiste();

			if (ministerioExiste == false) {

				this.ministerioBC.update(this.getBean());

				return getPreviousView();

			} else {

				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO, "AVISO",
						"Não foi possível inserir! Base já cadastrada.");

				RequestContext.getCurrentInstance()
						.showMessageInDialog(message);

				return null;
			}

		}
	}

	@Override
	protected Ministerio handleLoad(Long id) {
		return this.ministerioBC.load(id);
	}

	public Boolean verificaMinisterioExiste() {
		boolean resultado;

		Ministerio ministerioBD = this.ministerioBC
				.verificaMinisterioExiste(this.getBean());

		if (ministerioBD == null) {

			resultado = false;

		} else {

			resultado = true;
		}

		return resultado;
	}

	public String cancelar() {
		return getPreviousView();
	}

}