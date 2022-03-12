package br.org.ibmi.sisge.business;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.org.ibmi.sisge.domain.*;
import br.org.ibmi.sisge.persistence.ControleDespezasDAO;
import br.org.ibmi.sisge.util.Util;

// To remove unused imports press: Ctrl+Shift+o

@BusinessController
public class ControleDespezasBC extends
		DelegateCrud<ControleDespezas, Long, ControleDespezasDAO> {
	private static final long serialVersionUID = 1L;

	@Inject
	private Util util;

	public ControleDespezas calculaValorTotalMateriais(ControleDespezas cd) {

		double valorTotalMateriais = 0;

		double valorTotalAtual = 0;

		for (Iterator<Material> iterator = cd.getMateriais().iterator(); iterator
				.hasNext();) {
			Material material = iterator.next();

			if (material.getValor() != null) {
				valorTotalMateriais = valorTotalMateriais
						+ util.converteStringDouble(material.getValor());
			}
		}

		cd.setValorTotalMateriais(util
				.converteDoubleString(valorTotalMateriais));

		if (cd.getValorTotalAtual() == null) {

			cd.setValorTotalAtual(util
					.converteDoubleString(valorTotalMateriais));

		} else {

			if (cd.getValorTotalHospedagens() == null) {

				cd.setValorTotalHospedagens("0");
			}
			if (cd.getValorTotalServicos() == null) {

				cd.setValorTotalServicos("0");
			}
			if (cd.getValorTotalTransportes() == null) {

				cd.setValorTotalTransportes("0");
			}

			valorTotalAtual = util.converteStringDouble(cd
					.getValorTotalMateriais())
					+ util.converteStringDouble(cd.getValorTotalHospedagens())
					+ util.converteStringDouble(cd.getValorTotalServicos())
					+ util.converteStringDouble(cd.getValorTotalTransportes());

			cd.setValorTotalAtual(util.converteDoubleString(valorTotalAtual));

		}

		return cd;
	}

	public ControleDespezas calculaValorTotalMateriaisSubtrair(
			ControleDespezas cd, String valorMaterial) {

		double valorTotalMaterial = 0;

		double valorTotalAtual = 0;

		valorTotalMaterial = util.converteStringDouble(cd
				.getValorTotalMateriais())
				- util.converteStringDouble(valorMaterial);

		cd.setValorTotalMateriais(util.converteDoubleString(valorTotalMaterial));

		valorTotalAtual = util.converteStringDouble(cd.getValorTotalAtual())
				- util.converteStringDouble(valorMaterial);

		cd.setValorTotalAtual(util.converteDoubleString(valorTotalAtual));

		return cd;

	}

	public ControleDespezas calculaValorTotalHospedagens(ControleDespezas cd) {

		double valorTotalHospedagens = 0;

		double valorTotalAtual = 0;

		for (Iterator<Hospedagem> iterator = cd.getHospedagens().iterator(); iterator
				.hasNext();) {
			Hospedagem hospedagem = iterator.next();

			if (hospedagem.getValor() != null) {
				valorTotalHospedagens = valorTotalHospedagens
						+ util.converteStringDouble(hospedagem.getValor());
			}
		}

		cd.setValorTotalHospedagens(util
				.converteDoubleString(valorTotalHospedagens));

		if (cd.getValorTotalAtual() == null) {

			cd.setValorTotalAtual(util
					.converteDoubleString(valorTotalHospedagens));

		} else {

			if (cd.getValorTotalMateriais() == null) {

				cd.setValorTotalMateriais("0");
			}
			if (cd.getValorTotalServicos() == null) {

				cd.setValorTotalServicos("0");
			}
			if (cd.getValorTotalTransportes() == null) {

				cd.setValorTotalTransportes("0");
			}

			valorTotalAtual = util.converteStringDouble(cd
					.getValorTotalMateriais())
					+ util.converteStringDouble(cd.getValorTotalHospedagens())
					+ util.converteStringDouble(cd.getValorTotalServicos())
					+ util.converteStringDouble(cd.getValorTotalTransportes());

			cd.setValorTotalAtual(util.converteDoubleString(valorTotalAtual));

		}

		return cd;
	}

	public ControleDespezas calculaValorTotalHospedagensSubtrair(
			ControleDespezas cd, String valorHospedagem) {

		double valorTotalHospedagem = 0;

		double valorTotalAtual = 0;

		valorTotalHospedagem = util.converteStringDouble(cd
				.getValorTotalHospedagens())
				- util.converteStringDouble(valorHospedagem);

		cd.setValorTotalHospedagens(util
				.converteDoubleString(valorTotalHospedagem));

		valorTotalAtual = util.converteStringDouble(cd.getValorTotalAtual())
				- util.converteStringDouble(valorHospedagem);

		cd.setValorTotalAtual(util.converteDoubleString(valorTotalAtual));

		return cd;
	}

	public ControleDespezas calculaValorTotalServicos(ControleDespezas cd) {

		double valorTotalServicos = 0;

		double valorTotalAtual = 0;

		for (Iterator<Servico> iterator = cd.getServicos().iterator(); iterator
				.hasNext();) {
			Servico servico = iterator.next();

			if (servico.getValor() != null) {
				valorTotalServicos = valorTotalServicos
						+ util.converteStringDouble(servico.getValor());
			}
		}

		cd.setValorTotalServicos(util.converteDoubleString(valorTotalServicos));

		if (cd.getValorTotalAtual() == null) {

			cd.setValorTotalAtual(util.converteDoubleString(valorTotalServicos));

		} else {

			if (cd.getValorTotalMateriais() == null) {

				cd.setValorTotalMateriais("0");
			}
			if (cd.getValorTotalHospedagens() == null) {

				cd.setValorTotalHospedagens("0");
			}
			if (cd.getValorTotalTransportes() == null) {

				cd.setValorTotalTransportes("0");
			}

			valorTotalAtual = util.converteStringDouble(cd
					.getValorTotalMateriais())
					+ util.converteStringDouble(cd.getValorTotalHospedagens())
					+ util.converteStringDouble(cd.getValorTotalServicos())
					+ util.converteStringDouble(cd.getValorTotalTransportes());

			cd.setValorTotalAtual(util.converteDoubleString(valorTotalAtual));

		}

		return cd;
	}

	public ControleDespezas calculaValorTotalServicosSubtrair(
			ControleDespezas cd, String valorServico) {

		double valorTotalServico = 0;

		double valorTotalAtual = 0;

		valorTotalServico = util.converteStringDouble(cd
				.getValorTotalServicos())
				- util.converteStringDouble(valorServico);

		cd.setValorTotalServicos(util.converteDoubleString(valorTotalServico));

		valorTotalAtual = util.converteStringDouble(cd.getValorTotalAtual())
				- util.converteStringDouble(valorServico);

		cd.setValorTotalAtual(util.converteDoubleString(valorTotalAtual));

		return cd;
	}
	
	public ControleDespezas calculaValorTotalTransportes(ControleDespezas cd) {

		double valorTotalTransportes = 0;

		double valorTotalAtual = 0;

		for (Iterator<Transporte> iterator = cd.getTransportes().iterator(); iterator
				.hasNext();) {
			Transporte transporte = iterator.next();

			if (transporte.getValor() != null) {
				valorTotalTransportes = valorTotalTransportes
						+ util.converteStringDouble(transporte.getValor());
			}
		}

		cd.setValorTotalTransportes(util.converteDoubleString(valorTotalTransportes));

		if (cd.getValorTotalAtual() == null) {

			cd.setValorTotalAtual(util.converteDoubleString(valorTotalTransportes));

		} else {

			if (cd.getValorTotalMateriais() == null) {

				cd.setValorTotalMateriais("0");
			}
			if (cd.getValorTotalHospedagens() == null) {

				cd.setValorTotalHospedagens("0");
			}
			if (cd.getValorTotalServicos() == null) {

				cd.setValorTotalServicos("0");
			}

			valorTotalAtual = util.converteStringDouble(cd
					.getValorTotalMateriais())
					+ util.converteStringDouble(cd.getValorTotalHospedagens())
					+ util.converteStringDouble(cd.getValorTotalServicos())
					+ util.converteStringDouble(cd.getValorTotalTransportes());

			cd.setValorTotalAtual(util.converteDoubleString(valorTotalAtual));

		}

		return cd;
	}

	public ControleDespezas calculaValorTotalTransportesSubtrair(
			ControleDespezas cd, String valorTransporte) {

		double valorTotalTransporte = 0;

		double valorTotalAtual = 0;

		valorTotalTransporte = util.converteStringDouble(cd
				.getValorTotalTransportes())
				- util.converteStringDouble(valorTransporte);

		cd.setValorTotalTransportes(util.converteDoubleString(valorTotalTransporte));

		valorTotalAtual = util.converteStringDouble(cd.getValorTotalAtual())
				- util.converteStringDouble(valorTransporte);

		cd.setValorTotalAtual(util.converteDoubleString(valorTotalAtual));

		return cd;
	}

	
}
