package br.upf.ads.industria.model.testes;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.upf.ads.industria.model.beans.geral.Cidade;
import br.upf.ads.industria.model.beans.rh.Funcionario;
import br.upf.ads.industria.model.uteis.FabricaConexao;

public class TesteFuncionario {

	@Test
	public void novo() {
		EntityManager em = FabricaConexao.getEntityManager();
		
		Funcionario o = new Funcionario();
		o.setNome("Funcionário Dois");
		o.setSexo('M');
		o.setCpf("883.253.106-26");
		o.setRg("3452352354");
		o.setEndereco("Rua xxx");
		try {
			o.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("15/05/1985"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		o.setCidade(em.find(Cidade.class, 1));
		
		o.setLogin("dois");
		o.setSenha("dois");
		
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}
	

	
}
