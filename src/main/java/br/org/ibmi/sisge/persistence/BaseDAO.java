package br.org.ibmi.sisge.persistence;

import javax.persistence.Query;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.ibmi.sisge.domain.Base;

@PersistenceController
public class BaseDAO extends JPACrud<Base, Long> {

	private static final long serialVersionUID = 1L;
	
	public Base verificaBaseExiste(Base base){
		
		Base result = null;
		
		Query query = getEntityManager().createQuery("select b from Base b where b.descricao = :base");
		query.setParameter("base", base.getDescricao());
		try {
			result = (Base)query.getSingleResult();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}
		
		return result;
	}
	
	
	

}
