package br.upf.ads.industria.model.uteis;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.jpa.HibernateEntityManager;

public class FabricaConexao {

	private static EntityManagerFactory fabrica;

	public static EntityManager getEntityManager() {

		if (fabrica == null) {

			fabrica = Persistence.createEntityManagerFactory("IndustriaJPA");
		}

		return fabrica.createEntityManager();

	}
	
	public static Connection getEntityManagerJDBCConnection() throws SQLException {
		  EntityManager em = getEntityManager(); 
	      /*
	      Session ses = (Session) em.getDelegate(); 
	      SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses.getSessionFactory(); 
	      Connection conexao = sessionFactory.getConnectionProvider().getConnection();
	      */
	      HibernateEntityManager hem = (HibernateEntityManager) em;
	      SessionImplementor sim = (SessionImplementor) hem.getSession();
	      Connection conexao = sim.connection();
	      em.close();
	      return conexao;  
    }  	
	

}
