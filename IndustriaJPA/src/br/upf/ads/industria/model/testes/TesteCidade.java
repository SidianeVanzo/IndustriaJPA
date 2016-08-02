package br.upf.ads.industria.model.testes;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.upf.ads.industria.model.beans.geral.Cidade;
import br.upf.ads.industria.model.uteis.FabricaConexao;

public class TesteCidade {

	@Test
	public void testNomeUfVazio() {
		Cidade o = new Cidade(null, "", "");
		EntityManager em = FabricaConexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}
	
	@Test
	public void testTamanhoNomeUf() {
		Cidade o = new Cidade(null, "a", "b");
		EntityManager em = FabricaConexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	@Test
	public void testOpcoesUf() {
		Cidade o = new Cidade(null, "Passo Fundo", "RK");
		EntityManager em = FabricaConexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}	
	
	
}
