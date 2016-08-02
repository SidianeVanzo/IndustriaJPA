package br.upf.industriajsf.controle;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.upf.ads.industria.model.beans.estoque.MateriaPrima;
import br.upf.ads.industria.model.uteis.FabricaConexao;

@ManagedBean
@SessionScoped
public class MateriaPrimaCrud {

	private List<MateriaPrima> lista;
	private MateriaPrima objeto;

	public MateriaPrimaCrud() {
		super();
	}
	
	public void inicializarLista() {
		EntityManager em = FabricaConexao.getEntityManager();
		lista = em.createQuery("from MateriaPrima").getResultList();
		em.close();
	}

	public String incluir() {
		objeto = new MateriaPrima();
		return "MateriaPrimaForm?faces-redirect=true";
	}

	public String gravar() {
		EntityManager em = FabricaConexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(objeto);
		em.getTransaction().commit();
		em.close();
		return "MateriaPrimaList?faces-redirect=true";
	}

	public String alterar(Integer id) {
		EntityManager em = FabricaConexao.getEntityManager();
		objeto = em.find(MateriaPrima.class, id);
		em.close();
		return "MateriaPrimaForm?faces-redirect=true";
	}

	public String excluir(Integer id) {
		try {
			EntityManager em = FabricaConexao.getEntityManager();
			objeto = em.find(MateriaPrima.class, id);
			em.getTransaction().begin();
			em.remove(objeto);
			em.getTransaction().commit();
			em.close();
			return "MateriaPrimaList?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Objeto n�o pode ser exclu�do!", "");
            FacesContext.getCurrentInstance().addMessage(null, mensagem);
            return "";
		}
	}

	public String cancelar() {
		return "MateriaPrimaList";
	}
	
	public List<MateriaPrima> getLista() {
		return lista;
	}

	public void setLista(List<MateriaPrima> lista) {
		this.lista = lista;
	}

	public MateriaPrima getObjeto() {
		return objeto;
	}

	public void setObjeto(MateriaPrima objeto) {
		this.objeto = objeto;
	}

}
