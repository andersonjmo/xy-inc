package dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import model.Atributos;
import model.Classes;
import dao.ClassesDAO;



public class DAOFactory {
	
	public static  DaoGenerico<Classes, Integer> getClassesDAO(EntityManager conexao)
			throws SQLException {
		return new ClassesDAO(conexao);
	}		
	
	public static  DaoGenerico<Atributos, Integer> getAtributosDAO(EntityManager conexao)
			throws SQLException {
		return new AtributosDAO(conexao);
	}			
	
	
}