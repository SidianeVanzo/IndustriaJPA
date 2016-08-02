package br.upf.industriajsf.controle;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.upf.ads.industria.model.beans.geral.PessoaJuridica;
import br.upf.ads.industria.model.beans.estoque.MateriaPrima;
import br.upf.ads.industria.model.beans.estoque.Recebimento;
import br.upf.ads.industria.model.beans.estoque.RecebimentoItem;
import br.upf.ads.industria.model.uteis.FabricaConexao;

@ManagedBean
@SessionScoped
public class RecebimentoCrud {

	private List<Recebimento> lista;
	private Recebimento objeto;

	public RecebimentoCrud() {
		super();
	}

	public void inicializarLista() {
		EntityManager em = FabricaConexao.getEntityManager();
		lista = em.createQuery("from Recebimento").getResultList();
		em.close();
	}

	public String incluir() {
		objeto = new Recebimento();
		return "RecebimentoForm?faces-redirect=true";
	}

	public String gravar() {
		EntityManager em = FabricaConexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(objeto);
		em.getTransaction().commit();
		em.close();
		return "RecebimentoList?faces-redirect=true";
	}

	public String alterar(Integer id) {
		EntityManager em = FabricaConexao.getEntityManager();
		objeto = em.find(Recebimento.class, id);
		em.close();
		return "RecebimentoForm?faces-redirect=true";
	}

	public String excluir(Integer id) {
		try {
			EntityManager em = FabricaConexao.getEntityManager();
			objeto = em.find(Recebimento.class, id);
			em.getTransaction().begin();
			em.remove(objeto);
			em.getTransaction().commit();
			em.close();
			return "RecebimentoList?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Objeto não pode ser excluído!", "");
            FacesContext.getCurrentInstance().addMessage(null, mensagem);
            return "";
		}
	}

	public String cancelar() {
		return "RecebimentoList";
	}

	public List<PessoaJuridica> completeFornecedor(String query) {
		EntityManager em = FabricaConexao.getEntityManager();
		List<PessoaJuridica> results = em.createQuery("from PessoaJuridica where upper(nome) like " + "'"
				+ query.trim().toUpperCase() + "%' " + "order by nome").getResultList();
		em.close();
		return results;
	}
	
	public List<MateriaPrima> completeMateriaPrima(String query) {
		EntityManager em = FabricaConexao.getEntityManager();
		List<MateriaPrima> results = em.createQuery("from MateriaPrima where upper(nome) like " + "'"
				+ query.trim().toUpperCase() + "%' " + "order by nome").getResultList();
		em.close();
		return results;
	}
	
	public List<Recebimento> getLista() {
		return lista;
	}

	public void setLista(List<Recebimento> lista) {
		this.lista = lista;
	}

	public Recebimento getObjeto() {
		return objeto;
	}

	public void setObjeto(Recebimento objeto) {
		this.objeto = objeto;
	}

	private RecebimentoItem item; // item em edição, vinculado ao formulário
	private Integer rowIndex = null; // índice do item selecionado - alterar e
										// excluir

	public void incluirItem() {
		rowIndex = null;
		item = new RecebimentoItem();
	}

	public void alterarItem(Integer rowIndex) {
		this.rowIndex = rowIndex;
		item = objeto.getItensRecebidos().get(rowIndex); // pega item da coleção
	}

	public void excluirItem(Integer rowIndex) {
		objeto.getItensRecebidos().remove(rowIndex.intValue()); // exclui item da coleção
		calcularTotais();
	}

	public void gravarItem() {
		if (this.rowIndex == null) {
			item.setRecebimento(objeto);
			objeto.getItensRecebidos().add(item); // adiciona item na coleção
		} else {
			objeto.getItensRecebidos().set(rowIndex, item); // altera na coleção
		}
		calcularTotais();
		rowIndex = null;
		item = null;
	}

	public void cancelarItem() {
		rowIndex = null;
		item = null;
	}

	/**
	 * Método chamado por ajax para o cálculo do total do item ao digitar no
	 * formulário
	 */
	public void calcularTotalItem() {
		if (item.getValorUnitario() == null || item.getQuantidade() == null)
			return;
		item.setTotal(item.getValorUnitario() * item.getQuantidade());
	}

	/**
	 * Método que calcula o total do recebimento após as operações sobre itens
	 */
	public void calcularTotais() {
		Float valorProdutos = 0F;
		for (RecebimentoItem it : objeto.getItensRecebidos())
			valorProdutos += it.getTotal();
		objeto.setTotalProdutos(valorProdutos);
		if (objeto.getValorFrete() == null)
			objeto.setValorFrete(0F);
		objeto.setTotalCompra(objeto.getValorFrete() + objeto.getTotalProdutos());
	}

	public RecebimentoItem getItem() {
		return item;
	}

	public void setItem(RecebimentoItem item) {
		this.item = item;
	}

	public Integer getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(Integer rowIndex) {
		this.rowIndex = rowIndex;
	}
	
}
