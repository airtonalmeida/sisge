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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="base")
public class Base implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name="id_base")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column (name="descricao")
	private String descricao;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_base")
	private List<Ministerio> ministerios = new ArrayList<Ministerio>();
	
		
	public Base() {
		super();
	}


	public Base(String descricao) {
		super();
		this.descricao = descricao;
		
	}


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


	public List<Ministerio> getMinisterios() {
		return ministerios;
	}


	public void setMinisterios(List<Ministerio> ministerios) {
		this.ministerios = ministerios;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((ministerios == null) ? 0 : ministerios.hashCode());
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
		Base other = (Base) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ministerios == null) {
			if (other.ministerios != null)
				return false;
		} /*else if (!ministerios.equals(other.ministerios))
			return false;*/
		return true;
	}

	

}
