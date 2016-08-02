package br.upf.industriajsf.controle;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.upf.ads.industria.model.beans.geral.Cidade;
import br.upf.ads.industria.model.uteis.FabricaConexao;

@ManagedBean
@SessionScoped
public class CidadeCrud {

	private List<Cidade> lista;
	private Cidade objeto;
	private String[] listaUF = { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MT", "MS", "PA",
			"PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" };


	public CidadeCrud() {
		super();
	}
	
	public void inicializarLista() {
		EntityManager em = FabricaConexao.getEntityManager();
		lista = em.createQuery("from Cidade").getResultList();
		em.close();
	}

	public String incluir() {
		objeto = new Cidade();
		return "CidadeForm?faces-redirect=true";
	}

	public String gravar() {
		EntityManager em = FabricaConexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(objeto);
		em.getTransaction().commit();
		em.close();
		return "CidadeList?faces-redirect=true";
	}

	public String alterar(Integer id) {
		EntityManager em = FabricaConexao.getEntityManager();
		objeto = em.find(Cidade.class, id);
		em.close();
		return "CidadeForm?faces-redirect=true";
	}

	public String excluir(Integer id) {
		try {
			EntityManager em = FabricaConexao.getEntityManager();
			objeto = em.find(Cidade.class, id);
			em.getTransaction().begin();
			em.remove(objeto);
			em.getTransaction().commit();
			em.close();
			return "CidadeList?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Objeto não pode ser excluído!", "");
            FacesContext.getCurrentInstance().addMessage(null, mensagem);
            return "";
		}
	}

	public String cancelar() {
		return "CidadeList";
	}

	public List<Cidade> getLista() {
		return lista;
	}

	public void setLista(List<Cidade> lista) {
		this.lista = lista;
	}

	public Cidade getObjeto() {
		return objeto;
	}

	public void setObjeto(Cidade objeto) {
		this.objeto = objeto;
	}

	public String[] getListaUF() {
		return listaUF;
	}

	public void setListaUF(String[] listaUF) {
		this.listaUF = listaUF;
	}

}
