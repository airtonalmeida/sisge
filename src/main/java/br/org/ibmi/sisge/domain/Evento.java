package br.org.ibmi.sisge.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table (name="evento")
public class Evento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_evento")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column (name="descricao")
	private String descricao;
	
	@Column (name="abreviatura")
	private String abreviatura;

	@Column (name="local")
	private String local;
	
	@Column (name="dataInicial")
	@Temporal(TemporalType.DATE)
	private Date dataInicial;

	@Column (name="dataFinal")
	@Temporal(TemporalType.DATE)
	private Date dataFinal;
		
	@ManyToOne
	@JoinColumn(name = "id_responsavel", nullable=false)
	private Responsavel responsavel;
	
	@Column (name="custoEstimado")
	private String custoEstimado;
	
	@Column (name="formaDeCusteio")
	private String formaDeCusteio;
	
	@Column (name="observacao")
	private String observacao;
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((abreviatura == null) ? 0 : abreviatura.hashCode());
		result = prime * result
				+ ((custoEstimado == null) ? 0 : custoEstimado.hashCode());
		result = prime * result
				+ ((dataFinal == null) ? 0 : dataFinal.hashCode());
		result = prime * result
				+ ((dataInicial == null) ? 0 : dataInicial.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((formaDeCusteio == null) ? 0 : formaDeCusteio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result
				+ ((responsavel == null) ? 0 : responsavel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (abreviatura == null) {
			if (other.abreviatura != null)
				return false;
		} else if (!abreviatura.equals(other.abreviatura))
			return false;
		if (custoEstimado == null) {
			if (other.custoEstimado != null)
				return false;
		} else if (!custoEstimado.equals(other.custoEstimado))
			return false;
		if (dataFinal == null) {
			if (other.dataFinal != null)
				return false;
		} else if (!dataFinal.equals(other.dataFinal))
			return false;
		if (dataInicial == null) {
			if (other.dataInicial != null)
				return false;
		} else if (!dataInicial.equals(other.dataInicial))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (formaDeCusteio == null) {
			if (other.formaDeCusteio != null)
				return false;
		} else if (!formaDeCusteio.equals(other.formaDeCusteio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (responsavel == null) {
			if (other.responsavel != null)
				return false;
		} else if (!responsavel.equals(other.responsavel))
			return false;
		return true;
	}

	public String getCustoEstimado() {
		return custoEstimado;
	}

	public void setCustoEstimado(String custoEstimado) {
		this.custoEstimado = custoEstimado;
	}

	public String getFormaDeCusteio() {
		return formaDeCusteio;
	}

	public void setFormaDeCusteio(String formaDeCusteio) {
		this.formaDeCusteio = formaDeCusteio;
	}

	
	
	
	
	

}
