package br.upf.industriajsf.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

import br.upf.ads.industria.model.beans.estoque.Grupo;
import br.upf.ads.industria.model.beans.estoque.ProdutoAcabado;
import br.upf.ads.industria.model.uteis.FabricaConexao;


@ManagedBean
@SessionScoped
public class ProdutoAcabadoCrud {

	private ProdutoAcabado objeto;
	private List<ProdutoAcabado> produtosAcabados;
	
	public List<Grupo> completeGrupo(String query) {
		EntityManager em = FabricaConexao.getEntityManager();
		 List<Grupo> results = em.createQuery(
		 "from Grupo where upper(nome) like "+
		"'"+query.trim().toUpperCase()+"%' "+
		 "order by nome").getResultList();
		 em.close();
		 return results;
		 }

	
	public void inicializarLista() {
		EntityManager em = FabricaConexao.getEntityManager();
		produtosAcabados = em.createQuery("from ProdutoAcabado").getResultList();
		em.close();
	}

	public String incluir() {
		objeto = new ProdutoAcabado();
		return "ProdutoAcabadoForm?faces-redirect=true";

	}

	public String gravar() {
		EntityManager em = FabricaConexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(objeto);
		em.getTransaction().commit();
		em.close();
		return "ProdutoAcabadoList?faces-redirect=true";
	}

	public String cancelar() {
		return "ProdutoAcabadoList";
	}

	public String alterar(Integer id) {
		EntityManager em = FabricaConexao.getEntityManager();
		objeto = em.find(ProdutoAcabado.class, id);
		em.close();
		return "ProdutoAcabadoForm?faces-redirect=true";
	}

	public String excluir(Integer id) {
		EntityManager em = FabricaConexao.getEntityManager();
		objeto = em.find(ProdutoAcabado.class, id);
		em.getTransaction().begin();
		em.remove(objeto);
		em.getTransaction().commit();
		em.close();
		return "ProdutoAcabadoList?faces-redirect=true";
	}

	public ProdutoAcabadoCrud() {
		super();
		objeto = new ProdutoAcabado();
		EntityManager em = FabricaConexao.getEntityManager();
		produtosAcabados = em.createQuery("from ProdutoAcabado").getResultList();
		em.close();
	}


	public ProdutoAcabado getObjeto() {
		return objeto;
	}


	public void setObjeto(ProdutoAcabado objeto) {
		this.objeto = objeto;
	}


	public List<ProdutoAcabado> getProdutosAcabados() {
		return produtosAcabados;
	}


	public void setProdutosAcabados(List<ProdutoAcabado> produtosAcabados) {
		this.produtosAcabados = produtosAcabados;
	}
	
	

}
