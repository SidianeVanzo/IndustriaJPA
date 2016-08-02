package br.upf.industriajsf.controle;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.upf.ads.industria.model.beans.geral.Cidade;
import br.upf.ads.industria.model.beans.geral.PessoaJuridica;
import br.upf.ads.industria.model.uteis.FabricaConexao;

@ManagedBean
@SessionScoped
public class PessoaJuridicaCrud {

	private List<PessoaJuridica> lista;
	private PessoaJuridica objeto;

	public PessoaJuridicaCrud() {
		super();
	}
	
	public void inicializarLista() {
		EntityManager em = FabricaConexao.getEntityManager();
		lista = em.createQuery("from PessoaJuridica").getResultList();
		em.close();
	}

	public String incluir() {
		objeto = new PessoaJuridica();
		return "PessoaJuridicaForm?faces-redirect=true";
	}

	public String gravar() {
		EntityManager em = FabricaConexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(objeto);
		em.getTransaction().commit();
		em.close();
		return "PessoaJuridicaList?faces-redirect=true";
	}

	public String alterar(Integer id) {
		EntityManager em = FabricaConexao.getEntityManager();
		objeto = em.find(PessoaJuridica.class, id);
		em.close();
		return "PessoaJuridicaForm?faces-redirect=true";
	}

	public String excluir(Integer id) {
		try {
			EntityManager em = FabricaConexao.getEntityManager();
			objeto = em.find(PessoaJuridica.class, id);
			em.getTransaction().begin();
			em.remove(objeto);
			em.getTransaction().commit();
			em.close();
			return "PessoaJuridicaList?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Objeto não pode ser excluído!", "");
            FacesContext.getCurrentInstance().addMessage(null, mensagem);
            return "";
		}
	}

	public String cancelar() {
		return "PessoaJuridicaList";
	}

	 public List<Cidade> completeCidade(String query) {
		 EntityManager em = FabricaConexao.getEntityManager();
		  List<Cidade> results = em.createQuery(
		  "from Cidade where upper(nome) like "+
		 "'"+query.trim().toUpperCase()+"%' "+
		  "order by nome").getResultList();
		  em.close();
		  return results;
	 }
	
	public List<PessoaJuridica> getLista() {
		return lista;
	}

	public void setLista(List<PessoaJuridica> lista) {
		this.lista = lista;
	}

	public PessoaJuridica getObjeto() {
		return objeto;
	}

	public void setObjeto(PessoaJuridica objeto) {
		this.objeto = objeto;
	}

}
