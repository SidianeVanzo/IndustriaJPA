package br.upf.ads.industria.model.testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.upf.ads.industria.model.beans.estoque.Grupo;
import br.upf.ads.industria.model.beans.estoque.MateriaPrima;
import br.upf.ads.industria.model.beans.estoque.Recebimento;
import br.upf.ads.industria.model.beans.estoque.RecebimentoItem;
import br.upf.ads.industria.model.beans.geral.Cidade;
import br.upf.ads.industria.model.beans.geral.PessoaJuridica;
import br.upf.ads.industria.model.uteis.FabricaConexao;

public class TesteCriarRecebimento {

	@Test
	public void criarUmaCidade() {
		Cidade o = new Cidade(null, "Chapecó", "SC");
		EntityManager em = FabricaConexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}	

	@Test
	public void criarPJ() {
		EntityManager em = FabricaConexao.getEntityManager();
		PessoaJuridica o = new PessoaJuridica();
		o.setCnpj("00.485.542/0005-25");
		o.setNome("Fornecedor um");
		o.setEmail("fornecedor@teste.com");
		o.setCidade(em.find(Cidade.class, 2));
		o.setIe("23452352354");
		o.setEndereco("rua x");
		Date d = new Date();
		d.setTime(new Date().getTime()-1000);
		o.setDataConstituicao(d);
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}	
	
	@Test
	public void criarGrupo() {
		EntityManager em = FabricaConexao.getEntityManager();
		Grupo o = new Grupo(null, "Grupo um");
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}
	
	@Test
	public void criarMateriaPrima() {
		EntityManager em = FabricaConexao.getEntityManager();
		MateriaPrima o = new MateriaPrima();
		o.setNome("Prego");
		o.setGrupo(em.find(Grupo.class, 1));
		o.setUnidadeEstoque("Un");
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}		
	
	@Test
	public void criarRecebimento() {
		EntityManager em = FabricaConexao.getEntityManager();
		Recebimento o = new Recebimento();
		Date d = new Date();
		d.setTime(new Date().getTime()-1000);
		o.setData(d);
		o.setNumeroNota("1234");
		o.setTotalProdutos(123F);
		o.setValorFrete(1F);
		o.setTotalCompra(124F);
		o.setFornecedor(em.find(PessoaJuridica.class, 2));
		
		// itens
		o.setItensRecebidos(new ArrayList());
		RecebimentoItem item = new RecebimentoItem();
		item.setRecebimento(o);
		item.setMateriaPrima(em.find(MateriaPrima.class, 1));
		item.setQuantidade(10F);
		item.setValorUnitario(50F);
		item.setTotal(500F);
		
		o.getItensRecebidos().add(item);
		

		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}	
	
}
