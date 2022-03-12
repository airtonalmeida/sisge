package br.org.ibmi.sisge.persistence;

import java.util.List;

import javax.persistence.Query;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.ibmi.sisge.domain.Base;
import br.org.ibmi.sisge.domain.Ministerio;
import br.org.ibmi.sisge.domain.Responsavel;

@PersistenceController
public class ResponsavelDAO extends JPACrud<Responsavel, Long> {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<Responsavel> completeText(String string) {

		Query query = getEntityManager().createQuery(
				"select r from Responsavel r where r.nome like :string");
		query.setParameter("string", string + "%");
		List<Responsavel> result = query.getResultList();
		return result;
	}

	public Responsavel verificaResponsavelExiste(Responsavel responsavel) {

		Responsavel result = null;

		Query query = getEntityManager()
				.createQuery(
						"select r from Responsavel r where r.nome = :nome and r.ministerio.descricao = :ministerio");
		query.setParameter("nome", responsavel.getNome());
		query.setParameter("ministerio", responsavel.getMinisterio()
				.getDescricao());
		try {
			result = (Responsavel) query.getSingleResult();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return null;
		}

		return result;
	}

}
