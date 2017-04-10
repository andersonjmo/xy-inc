package dao;

import javax.persistence.EntityManager;

import model.Atributos;

public class AtributosDAO extends DaoGenericoImpl<Atributos, Integer>{

	public AtributosDAO(EntityManager conexao) {
		this.conexao = conexao;
		this.criteria = conexao.getCriteriaBuilder();
	}
}
