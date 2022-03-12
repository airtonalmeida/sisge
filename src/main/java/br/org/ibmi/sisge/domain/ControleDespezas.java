package br.org.ibmi.sisge.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "controleDespezas")
public class ControleDespezas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_controleDespezas")
	private Long id;

	@Column(name = "valorTotalAtual")
	private String valorTotalAtual;

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_evento", nullable = false)
	private Evento evento;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_controleDespezas")
	private List<Material> materiais = new ArrayList<Material>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_controleDespezas")
	private List<Hospedagem> hospedagens = new ArrayList<Hospedagem>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_controleDespezas")
	private List<Servico> servicos = new ArrayList<Servico>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_controleDespezas")
	private List<Transporte> transportes = new ArrayList<Transporte>();

	@Column(name = "valorTotalMateriais")
	private String valorTotalMateriais;

	@Column(name = "valorTotalHospedagens")
	private String valorTotalHospedagens;

	@Column(name = "valorTotalServicos")
	private String valorTotalServicos;
	
	@Column(name = "valorTotalTransportes")
	private String valorTotalTransportes;

	@Column(name = "percentual")
	private String percentual;
	
	@Column(name = "percentualMaterial")
	private String percentualMaterial;
	
	@Column(name = "percentualHospedagem")
	private String percentualHospedagem;
	
	@Column(name = "percentualServico")
	private String percentualServico;
	
	@Column(name = "percentualTransporte")
	private String percentualTransporte;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public List<Material> getMateriais() {
		return materiais;
	}

	public void setMateriais(List<Material> materiais) {
		this.materiais = materiais;
	}

	public String getValorTotalMateriais() {
		return valorTotalMateriais;
	}

	public void setValorTotalMateriais(String valorTotalMateriais) {
		this.valorTotalMateriais = valorTotalMateriais;
	}

	public List<Hospedagem> getHospedagens() {
		return hospedagens;
	}

	public void setHospedagens(List<Hospedagem> hospedagens) {
		this.hospedagens = hospedagens;
	}

	public String getValorTotalHospedagens() {
		return valorTotalHospedagens;
	}

	public void setValorTotalHospedagens(String valorTotalHospedagens) {
		this.valorTotalHospedagens = valorTotalHospedagens;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public String getValorTotalServicos() {
		return valorTotalServicos;
	}

	public void setValorTotalServicos(String valorTotalServicos) {
		this.valorTotalServicos = valorTotalServicos;
	}

	public String getValorTotalAtual() {
		return valorTotalAtual;
	}

	public void setValorTotalAtual(String valorTotalAtual) {
		this.valorTotalAtual = valorTotalAtual;
	}

	public String getPercentual() {
		return percentual;
	}

	public void setPercentual(String percentual) {
		this.percentual = percentual;
	}

	public String getPercentualMaterial() {
		return percentualMaterial;
	}

	public void setPercentualMaterial(String percentualMaterial) {
		this.percentualMaterial = percentualMaterial;
	}

	public String getPercentualHospedagem() {
		return percentualHospedagem;
	}

	public void setPercentualHospedagem(String percentualHospedagem) {
		this.percentualHospedagem = percentualHospedagem;
	}

	public String getPercentualServico() {
		return percentualServico;
	}

	public void setPercentualServico(String percentualServico) {
		this.percentualServico = percentualServico;
	}

	public List<Transporte> getTransportes() {
		return transportes;
	}

	public void setTransportes(List<Transporte> transportes) {
		this.transportes = transportes;
	}

	public String getValorTotalTransportes() {
		return valorTotalTransportes;
	}

	public void setValorTotalTransportes(String valorTotalTransportes) {
		this.valorTotalTransportes = valorTotalTransportes;
	}

	public String getPercentualTransporte() {
		return percentualTransporte;
	}

	public void setPercentualTransporte(String percentualTransporte) {
		this.percentualTransporte = percentualTransporte;
	}

}
