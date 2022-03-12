package br.org.ibmi.sisge.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="responsavel")
public class Responsavel extends Pessoa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "id_base", nullable=false)
	private Base base;
	
	@ManyToOne
	@JoinColumn(name = "id_ministerio", nullable=false)
	private Ministerio ministerio;

	public Base getBase() {
		return base;
	}

	public void setBase(Base base) {
		this.base = base;
	}
	
	public Ministerio getMinisterio() {
		return ministerio;
	}

	public void setMinisterio(Ministerio ministerio) {
		this.ministerio = ministerio;
	}
		
	public Responsavel() {
		super();
		
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((base == null) ? 0 : base.hashCode());
		result = prime * result
				+ ((ministerio == null) ? 0 : ministerio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ministro other = (Ministro) obj;
		if (base == null) {
			if (other.base != null)
				return false;
		} else if (!base.equals(other.base))
			return false;
		if (ministerio == null) {
			if (other.ministerio != null)
				return false;
		} else if (!ministerio.equals(other.ministerio))
			return false;
		return true;
	}
*/
	
	

	
	

}
