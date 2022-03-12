package br.org.ibmi.sisge.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.ibmi.sisge.business.ControleDespezasBC;
import br.org.ibmi.sisge.business.EventoBC;
import br.org.ibmi.sisge.domain.ControleDespezas;
import br.org.ibmi.sisge.domain.Evento;
import br.org.ibmi.sisge.domain.Hospedagem;
import br.org.ibmi.sisge.domain.Material;
import br.org.ibmi.sisge.domain.Servico;
import br.org.ibmi.sisge.domain.Transporte;
import br.org.ibmi.sisge.util.Util;

// To remove unused imports press: Ctrl+Shift+o

@ViewController
@PreviousView("./controleDespezas_list.jsf")
public class ControleDespezasEditMB extends
		AbstractEditPageBean<ControleDespezas, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ControleDespezasBC controleDespezasBC;

	@Inject
	private EventoBC eventoBC;

	@Inject
	private Util util;
	
	private PieChartModel graficoPizza;
	
	private BarChartModel graficoBarra;
	
	public PieChartModel getGraficoPizza() {
		return graficoPizza;
	}
	
	public BarChartModel getGraficoBarra() {
		return graficoBarra;
	}
	
	@PostConstruct
    public void init() {
		criarGraficoPizza();
		criarGraficoBarra();
		
    }
		
	private void criarGraficoPizza() {
		graficoPizza = new PieChartModel();
		
		if (this.getBean().getValorTotalMateriais() == null) {

			this.getBean().setValorTotalMateriais("0");
		}
		if (this.getBean().getValorTotalHospedagens() == null) {

			this.getBean().setValorTotalHospedagens("0");
		}
		if (this.getBean().getValorTotalServicos() == null) {

			this.getBean().setValorTotalServicos("0");
		}
		if (this.getBean().getValorTotalTransportes() == null) {

			this.getBean().setValorTotalTransportes("0");
		}
		
		double material = util.converteStringDouble(this.getBean().getValorTotalMateriais());
		double hospedagem = util.converteStringDouble(this.getBean().getValorTotalHospedagens());
		double servico = util.converteStringDouble(this.getBean().getValorTotalServicos());
		double transporte = util.converteStringDouble(this.getBean().getValorTotalTransportes());
         
		graficoPizza.set("Material", material);
		graficoPizza.set("Hospedagem", hospedagem);
		graficoPizza.set("Serviço", servico);
		graficoPizza.set("Transporte", transporte);
       
         
		graficoPizza.setTitle("Gráfico Pizza");
		graficoPizza.setLegendPosition("w");
		graficoPizza.setMouseoverHighlight(true);
		graficoPizza.setShowDataLabels(true);
		
		
    }
	
	private void criarGraficoBarra() {
		
		double valorEvento = 0;
		
		graficoBarra = initBarModel();
        
		graficoBarra.setTitle("Gráfico de Barra");
		graficoBarra.setLegendPosition("ne");
         
        Axis xAxis = graficoBarra.getAxis(AxisType.X);
        xAxis.setLabel("Itens");
        
        if(this.getBean().getEvento()==null){
        	
        	valorEvento = 0;
        	
        }else{
        
        	valorEvento = util.converteStringDouble(this.getBean().getEvento().getCustoEstimado());
         
        }
        
        Axis yAxis = graficoBarra.getAxis(AxisType.Y);
        yAxis.setLabel("Valores(R$)");
        yAxis.setMin(0);
        yAxis.setMax(valorEvento);
				
    }
	
	private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        
        if (this.getBean().getValorTotalMateriais() == null) {

			this.getBean().setValorTotalMateriais("0");
		}
		if (this.getBean().getValorTotalHospedagens() == null) {

			this.getBean().setValorTotalHospedagens("0");
		}
		if (this.getBean().getValorTotalServicos() == null) {

			this.getBean().setValorTotalServicos("0");
		}
		if (this.getBean().getValorTotalTransportes() == null) {

			this.getBean().setValorTotalTransportes("0");
		}
		
		double material = util.converteStringDouble(this.getBean().getValorTotalMateriais());
		double hospedagem = util.converteStringDouble(this.getBean().getValorTotalHospedagens());
		double servico = util.converteStringDouble(this.getBean().getValorTotalServicos());
		double transporte = util.converteStringDouble(this.getBean().getValorTotalTransportes());
 
        ChartSeries materiais = new ChartSeries();
        materiais.setLabel("Materiais");
       	materiais.set("", material);
       	             
        ChartSeries hospedagens = new ChartSeries();
        hospedagens.setLabel("Hospedagens");
        hospedagens.set("", hospedagem);
              
        ChartSeries servicos = new ChartSeries();
        servicos.setLabel("Serviços");
        servicos.set("", servico);
      
        ChartSeries transportes = new ChartSeries();
        transportes.setLabel("Transportes");
        transportes.set("", transporte);
        
        model.addSeries(materiais);
        model.addSeries(hospedagens);
        model.addSeries(servicos);
        model.addSeries(transportes);
         
        return model;
    }
	
	public List<Evento> getEventoList() {
		return eventoBC.findAll();
	}

	private DataModel<Material> materialList;

	public void addMaterial() {
		this.getBean().getMateriais().add(new Material());
	}

	public void deleteMaterial() {

		ControleDespezas cd = new ControleDespezas();

		cd = this.controleDespezasBC.calculaValorTotalMateriaisSubtrair(
				this.getBean(), getMaterialList().getRowData().getValor());

		this.getBean().setValorTotalMateriais(cd.getValorTotalMateriais());

		this.getBean().setValorTotalAtual(cd.getValorTotalAtual());

		double percentual = 0;

		percentual = ((util.converteStringDouble(this.getBean()
				.getValorTotalAtual())
				/ (util.converteStringDouble(this.getBean().getEvento()
						.getCustoEstimado())) * 100));

		this.getBean().setPercentual(util.converteDoubleString(percentual));

		this.getBean().getMateriais().remove(getMaterialList().getRowData());
		
		
		criarGraficoBarra();
	}

	public DataModel<Material> getMaterialList() {
		if (materialList == null) {
			materialList = new ListDataModel<Material>(this.getBean()
					.getMateriais());
		}
		return materialList;
	}

	private DataModel<Hospedagem> hospedagemList;

	public void addHospedagem() {
		this.getBean().getHospedagens().add(new Hospedagem());
	}

	public void deleteHospedagem() {

		ControleDespezas cd = new ControleDespezas();

		cd = this.controleDespezasBC.calculaValorTotalHospedagensSubtrair(
				this.getBean(), getHospedagemList().getRowData().getValor());

		this.getBean().setValorTotalHospedagens(cd.getValorTotalHospedagens());

		this.getBean().setValorTotalAtual(cd.getValorTotalAtual());

		double percentual = 0;

		percentual = ((util.converteStringDouble(this.getBean()
				.getValorTotalAtual())
				/ (util.converteStringDouble(this.getBean().getEvento()
						.getCustoEstimado())) * 100));

		this.getBean().setPercentual(util.converteDoubleString(percentual));

		this.getBean().getHospedagens()
				.remove(getHospedagemList().getRowData());
		
		
		criarGraficoBarra();
	}

	public DataModel<Hospedagem> getHospedagemList() {
		if (hospedagemList == null) {
			hospedagemList = new ListDataModel<Hospedagem>(this.getBean()
					.getHospedagens());
		}
		return hospedagemList;
	}

	private DataModel<Servico> servicoList;

	public void addServico() {
		this.getBean().getServicos().add(new Servico());
	}

	public void deleteServico() {

		ControleDespezas cd = new ControleDespezas();

		cd = this.controleDespezasBC.calculaValorTotalServicosSubtrair(
				this.getBean(), getServicoList().getRowData().getValor());

		this.getBean().setValorTotalServicos(cd.getValorTotalServicos());

		this.getBean().setValorTotalAtual(cd.getValorTotalAtual());

		double percentual = 0;

		percentual = ((util.converteStringDouble(this.getBean()
				.getValorTotalAtual())
				/ (util.converteStringDouble(this.getBean().getEvento()
						.getCustoEstimado())) * 100));

		this.getBean().setPercentual(util.converteDoubleString(percentual));

		this.getBean().getServicos().remove(getServicoList().getRowData());
		
		
		criarGraficoBarra();
	}

	public DataModel<Servico> getServicoList() {
		if (servicoList == null) {
			servicoList = new ListDataModel<Servico>(this.getBean()
					.getServicos());
		}
		return servicoList;
	}
	
	private DataModel<Transporte> transporteList;

	public void addTransporte() {
		this.getBean().getTransportes().add(new Transporte());
	}

	public void deleteTransporte() {

		ControleDespezas cd = new ControleDespezas();

		cd = this.controleDespezasBC.calculaValorTotalTransportesSubtrair(
				this.getBean(), getTransporteList().getRowData().getValor());

		this.getBean().setValorTotalTransportes(cd.getValorTotalTransportes());

		this.getBean().setValorTotalAtual(cd.getValorTotalAtual());

		double percentual = 0;

		percentual = ((util.converteStringDouble(this.getBean()
				.getValorTotalAtual())
				/ (util.converteStringDouble(this.getBean().getEvento()
						.getCustoEstimado())) * 100));

		this.getBean().setPercentual(util.converteDoubleString(percentual));

		this.getBean().getTransportes().remove(getTransporteList().getRowData());
		
		
		criarGraficoBarra();
	}

	public DataModel<Transporte> getTransporteList() {
		if (transporteList == null) {
			transporteList = new ListDataModel<Transporte>(this.getBean()
					.getTransportes());
		}
		return transporteList;
	}

	@Override
	@Transactional
	public String delete() {
		this.controleDespezasBC.delete(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		this.controleDespezasBC.insert(this.getBean());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		this.controleDespezasBC.update(this.getBean());
		return getPreviousView();
	}

	@Override
	protected ControleDespezas handleLoad(Long id) {
		return this.controleDespezasBC.load(id);
	}

	public void calculaValorTotalMateriais() {

		ControleDespezas cd = new ControleDespezas();

		cd = this.controleDespezasBC.calculaValorTotalMateriais(this.getBean());

		this.getBean().setValorTotalMateriais(cd.getValorTotalMateriais());

		this.getBean().setValorTotalAtual(cd.getValorTotalAtual());

		double percentual = 0;

		percentual = ((util.converteStringDouble(this.getBean()
				.getValorTotalAtual())
				/ (util.converteStringDouble(this.getBean().getEvento()
						.getCustoEstimado())) * 100));

		this.getBean().setPercentual(util.converteDoubleString(percentual));
				
		criarGraficoBarra();
		
		calculaPercentualMaterial();
	}

	public void calculaValorTotalHospedagens() {

		ControleDespezas cd = new ControleDespezas();

		cd = this.controleDespezasBC.calculaValorTotalHospedagens(this
				.getBean());

		this.getBean().setValorTotalHospedagens(cd.getValorTotalHospedagens());

		this.getBean().setValorTotalAtual(cd.getValorTotalAtual());

		double percentual = 0;

		percentual = ((util.converteStringDouble(this.getBean()
				.getValorTotalAtual())
				/ (util.converteStringDouble(this.getBean().getEvento()
						.getCustoEstimado())) * 100));

		this.getBean().setPercentual(util.converteDoubleString(percentual));
		
		
		criarGraficoBarra();
		
		calculaPercentualHospedagem();

	}

	public void calculaValorTotalServicos() {

		ControleDespezas cd = new ControleDespezas();

		cd = this.controleDespezasBC.calculaValorTotalServicos(this.getBean());

		this.getBean().setValorTotalServicos(cd.getValorTotalServicos());

		this.getBean().setValorTotalAtual(cd.getValorTotalAtual());

		double percentual = 0;

		percentual = ((util.converteStringDouble(this.getBean()
				.getValorTotalAtual())
				/ (util.converteStringDouble(this.getBean().getEvento()
						.getCustoEstimado())) * 100));

		this.getBean().setPercentual(util.converteDoubleString(percentual));
		
		
		criarGraficoBarra();
		
		calculaPercentualServico();

	}
	
	public void calculaValorTotalTransportes() {

		ControleDespezas cd = new ControleDespezas();

		cd = this.controleDespezasBC.calculaValorTotalTransportes(this.getBean());

		this.getBean().setValorTotalTransportes(cd.getValorTotalTransportes());

		this.getBean().setValorTotalAtual(cd.getValorTotalAtual());

		double percentual = 0;

		percentual = ((util.converteStringDouble(this.getBean()
				.getValorTotalAtual())
				/ (util.converteStringDouble(this.getBean().getEvento()
						.getCustoEstimado())) * 100));

		this.getBean().setPercentual(util.converteDoubleString(percentual));
				
		criarGraficoBarra();
		
		calculaPercentualTransporte();
	}
	
	public void calculaPercentual() {
		
		double percentual = 0;
		
		if(this.getBean().getValorTotalAtual()==null){
			
			this.getBean().setValorTotalAtual("0");
			
		}
			

		percentual = ((util.converteStringDouble(this.getBean()
				.getValorTotalAtual())
				/ (util.converteStringDouble(this.getBean().getEvento()
						.getCustoEstimado())) * 100));

		this.getBean().setPercentual(util.converteDoubleString(percentual));

		criarGraficoBarra();
	}
	
	public void calculaPercentualMaterial() {
		
		double percentual = 0;
		
		if(this.getBean().getValorTotalAtual()==null){
			
			this.getBean().setValorTotalAtual("0");
			
		}
			
		percentual = ((util.converteStringDouble(this.getBean()
				.getValorTotalMateriais())
				/ (util.converteStringDouble(this.getBean().getEvento()
						.getCustoEstimado())) * 100));

		this.getBean().setPercentualMaterial(util.converteDoubleString(percentual));

		
	}
	
	public void calculaPercentualHospedagem(){
		
		double percentual = 0;
		
		if(this.getBean().getValorTotalAtual()==null){
			
			this.getBean().setValorTotalAtual("0");
			
		}
			
		percentual = ((util.converteStringDouble(this.getBean()
				.getValorTotalHospedagens())
				/ (util.converteStringDouble(this.getBean().getEvento()
						.getCustoEstimado())) * 100));

		this.getBean().setPercentualHospedagem(util.converteDoubleString(percentual));

		
	}
	
	public void calculaPercentualServico(){
		
		double percentual = 0;
		
		if(this.getBean().getValorTotalAtual()==null){
			
			this.getBean().setValorTotalAtual("0");
			
		}
			
		percentual = ((util.converteStringDouble(this.getBean()
				.getValorTotalServicos())
				/ (util.converteStringDouble(this.getBean().getEvento()
						.getCustoEstimado())) * 100));

		this.getBean().setPercentualServico(util.converteDoubleString(percentual));
		
		
	}

	public void calculaPercentualTransporte() {
		
		double percentual = 0;
		
		if(this.getBean().getValorTotalAtual()==null){
			
			this.getBean().setValorTotalAtual("0");
			
		}
			
		percentual = ((util.converteStringDouble(this.getBean()
				.getValorTotalTransportes())
				/ (util.converteStringDouble(this.getBean().getEvento()
						.getCustoEstimado())) * 100));

		this.getBean().setPercentualTransporte(util.converteDoubleString(percentual));

		
	}


	


}