package model;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class GenericModel {
	
	private String nome;
	private HashMap<String,GenericAtribute> atributos;

	public GenericModel(String nome, HashMap<String, GenericAtribute> atributos) {
		super();
		this.nome = nome;
		this.atributos = atributos;
	}
	
	@XmlTransient
	public Object getAtributos(String atributo) {
		return atributos.get(atributo).getValor();
	}

	public void setAtributos(String atributo, Object valor) {
		try{
			atributos.get(atributo).setValor(valor);	
		}catch(ClassCastException e){
			throw e;
		}
		
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	@XmlTransient
	public HashMap<String, GenericAtribute> getAtributos() {
		return atributos;
	}


	public void setAtributos(HashMap<String, GenericAtribute> atributos) {
		this.atributos = atributos;
	}
	
	
	

	

}
