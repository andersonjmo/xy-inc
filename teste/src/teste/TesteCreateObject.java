package teste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import model.Atributos;
import model.Classes;
import model.GenericModel;

import org.junit.Test;

import dao.BeanFactory;
import dao.ConnectionFactory;
import dao.DAOFactory;
import dao.DaoGenerico;
import dao.JpaUtil;

public class TesteCreateObject {
//	Classe de Teste para criação de um 
//	Objeto dinamico e sua respectiva Tabela para persistencia de dados no futuro
	
	
	@Test
	public void testCriarNovaClasse() throws SQLException {
		
		EntityManager conexao = ConnectionFactory.getConnection();

		DaoGenerico<Classes, Integer> dao = DAOFactory.getClassesDAO(conexao);
		DaoGenerico<Atributos, Integer> daoAt = DAOFactory
				.getAtributosDAO(conexao);
		Classes classes = new Classes();
		Atributos atributo1 = new Atributos(classes, "Inteiro", "id");
		Atributos atributo2 = new Atributos(classes, "String",
				"nome");
		Atributos atributo3 = new Atributos(classes, "String",
				"sexo");
		Atributos atributo4 = new Atributos(classes, "Double",
				"salario");

		List<Atributos> lista = new ArrayList<Atributos>();
		lista.add(atributo1);
		lista.add(atributo2);
		lista.add(atributo3);
		lista.add(atributo4);
		classes.setNomeClasse("Pessoa");
		dao.salvar(classes);

		daoAt.salvar(atributo1);

		daoAt.salvar(atributo2);
		daoAt.salvar(atributo3);
		daoAt.salvar(atributo4);

		JpaUtil.criarTabelaDinamicamente(classes, lista);

	}
	//Teste JUnit para instanciar um objeto dinamico a partir dos dados ja gravados no Banco
	@Test
	public void testeBeanFactory() throws ClassNotFoundException{
		
		try {
			GenericModel modelo = BeanFactory.novaInstancia("Pessoa");
			modelo.setAtributos("nome","Anderson Monteiro de Sousa");
			modelo.setAtributos("sexo", "M");
			modelo.setAtributos("salario", 1.000);
			modelo.setAtributos("id",1);
			JpaUtil jp = new JpaUtil();
			jp.persistObject(modelo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
