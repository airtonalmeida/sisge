
package br.org.ibmi.sisge.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.org.ibmi.sisge.domain.*;
import java.util.*;
import javax.faces.model.*;
import br.org.ibmi.sisge.persistence.BaseDAO;

// To remove unused imports press: Ctrl+Shift+o

@BusinessController
public class BaseBC extends DelegateCrud<Base, Long, BaseDAO> {
	private static final long serialVersionUID = 1L;
	
	public Base verificaBaseExiste(Base base){
		
		Base baseBD = getDelegate().
				verificaBaseExiste(base);
	
		return baseBD;
	}
	
	
}
