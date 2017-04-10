package teste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import model.Atributos;
import model.Classes;
import model.GenericModel;

import org.junit.Test;
import org.primefaces.context.RequestContext;

import dao.BeanFactory;
import dao.ConnectionFactory;
import dao.DAOFactory;
import dao.DaoGenerico;
import dao.JpaUtil;

public class TestePersisteObjectRest {

	private static String SALVAR_PATH = "http://localhost:8080/teste/rest/generic";

	
	//Método testa a criação de uma nova classe e persiste os dados no banco
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
				"login");
		Atributos atributo4 = new Atributos(classes, "String",
				"password");
		List<Atributos> lista = new ArrayList<Atributos>();
		lista.add(atributo1);
		lista.add(atributo2);
		lista.add(atributo3);
		lista.add(atributo4);
		classes.setNomeClasse("Usuario");
		dao.salvar(classes);

		daoAt.salvar(atributo1);

		daoAt.salvar(atributo2);
		daoAt.salvar(atributo3);
		daoAt.salvar(atributo4);

		JpaUtil.criarTabelaDinamicamente(classes, lista);
		
		
	}
	

	//Método de teste JUnit, chama o metodo de criação do objeto e em seguida faz a resquisição via REST 
	//para salvar dados no modelo Generico Criado
	@Test
	public void testPersistirClasse() throws SQLException, ClassNotFoundException {
		Client client = ClientBuilder.newClient();
		Response response;
		testCriarNovaClasse();
				
		GenericModel modelo = BeanFactory.novaInstancia("Usuario");
		modelo.setAtributos("id",1);
		modelo.setAtributos("nome","Anderson");
		modelo.setAtributos("login","andersonms");
		modelo.setAtributos("password","123456");
		
		
		
			response = client.target(SALVAR_PATH).request("application/json").post(Entity.json(modelo));
			if (response.getStatus() != 200) {
				System.out.println("Erro ao cadastrar!");
				System.out.println(response.getStatusInfo());
			} else {
				System.out.println("cadastrada com sucesso!");
			}
	}
}
