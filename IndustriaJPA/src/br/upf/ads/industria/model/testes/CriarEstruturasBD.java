package br.upf.ads.industria.model.testes;

import javax.persistence.Persistence;

import org.junit.Test;

public class CriarEstruturasBD {

	@Test
	public void test() {
		//fail("Not yet implemented");
		Persistence.createEntityManagerFactory("IndustriaJPA");
	}

}
