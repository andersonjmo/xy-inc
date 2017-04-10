package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.Atributos;
import model.Classes;
import model.GenericModel;
import enumType.Tipos;

public class JpaUtil {
	
	

	public static void criarTabelaDinamicamente(Classes classes, List<Atributos> lista) {
		String sql = "CREATE TABLE " +  classes.getNomeClasse() + "(";
		int x=0;
		for(Atributos l : lista){
			
			x++;
			if(x==lista.size()){
				sql = sql + l.getNomeAtributo() + " " + Tipos.valueOf(l.getTipoAtributo()).getTipoBanco() + ")";
			}else{
				sql = sql + l.getNomeAtributo() + " " + Tipos.valueOf(l.getTipoAtributo()).getTipoBanco() + ",";	
			}
			
		}
		Connection conexao;
		try {
			conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","amatsu22");
		
		
		Statement stm = conexao.createStatement();
		
			int ret = stm.executeUpdate(sql);
			stm.close();
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void persistObject(GenericModel model){
		
		String sql = "insert into " + model.getNome() + "( ";
		 int vtotalChaves = model.getAtributos().size();
		 int vcont = 0;
		 String valores = "('";
		for(String chave : model.getAtributos().keySet()){
			sql = sql + chave.toString();
			valores = valores + model.getAtributos(chave);
			vcont++;
			if (vtotalChaves == vcont){
				sql = sql + ") values";
				valores = valores + "')";
			}else{
				System.out.println(vtotalChaves + " - " + vcont);
			sql = sql + ",";
			valores = valores + "','";
			
			}
		}
		sql = sql + valores;
		System.out.println(sql);
		Connection conexao;
		try {
			conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","amatsu22");
		
		
		Statement stm = conexao.createStatement();
		
			int ret = stm.executeUpdate(sql);
			stm.close();
			conexao.close();
			System.out.println("Persistiu sem erros");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
