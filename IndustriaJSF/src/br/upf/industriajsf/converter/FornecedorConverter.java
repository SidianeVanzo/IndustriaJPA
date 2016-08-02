package br.upf.industriajsf.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import br.upf.ads.industria.model.beans.geral.PessoaJuridica;
import br.upf.ads.industria.model.uteis.FabricaConexao;

@FacesConverter(value = "fornecedorConverter")
public class FornecedorConverter implements Converter {
	@Override
	public PessoaJuridica getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				EntityManager em = FabricaConexao.getEntityManager();
				PessoaJuridica ret = em.find(PessoaJuridica.class, Integer.parseInt(value));
				em.close();
				return ret;
			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro de Convers�o do Fornecedor", "Fornecedor inv�lido."));
			}
		} else
			return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			return String.valueOf(((PessoaJuridica) object).getId());
		} else
			return null;
	}
}