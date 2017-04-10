package dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;

import enumType.Tipos;
import model.Atributos;
import model.Classes;
import model.GenericAtribute;
import model.GenericModel;

public class BeanFactory {

	public BeanFactory() {

	}

	public static GenericModel novaInstancia(String nomeObjeto) throws SQLException, ClassNotFoundException {

		GenericModel modelo = null;
		Tipos teste;
		HashMap<String, GenericAtribute> atributos = new HashMap();

		EntityManager conexao = ConnectionFactory.getConnection();
		DaoGenerico<Classes, Integer> dao = DAOFactory.getClassesDAO(conexao);
		DaoGenerico<Atributos, Integer> daoAt = DAOFactory
				.getAtributosDAO(conexao);
		Classes classe = dao.PesqString("Select T from Classes T where nomeClasse = '" + nomeObjeto + "'");
		if (!(classe.getId() == null)){
			List<Atributos> listaAtributos = daoAt.listPesq("Select A from Atributos A where classe = " + classe.getId() );
			for(Atributos a : listaAtributos){
				String tipo = Tipos.valueOf(a.getTipoAtributo()).getTipoJava();
				GenericAtribute ga = new GenericAtribute(a.getNomeAtributo(),Class.forName(tipo));
				atributos.put(a.getNomeAtributo(), ga);
			}
			modelo = new GenericModel(nomeObjeto, atributos);
		}
		
		return modelo;
	}

}
