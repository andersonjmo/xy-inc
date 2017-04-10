package dao;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	private static final Logger logger = Logger.getLogger(ConnectionFactory.class.getName());
	private static EntityManagerFactory emf = null;
	private static EntityManager manager;
	
	public static EntityManager getConnection() {
		
		if (emf==null) {
			emf = Persistence.createEntityManagerFactory("xy");
			manager = emf.createEntityManager();
		}
		manager = emf.createEntityManager();
		return manager;
	}
	
	public void closeConnection() {
		try { 
			emf.close();
			manager.close();
		} catch (Exception ex) {
			logger.log(Level.SEVERE, "Erro: banco " +  ". {0}", ex);
		}
	}
}