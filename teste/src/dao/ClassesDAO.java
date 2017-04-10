package dao;

import javax.persistence.EntityManager;

import model.Classes;

public class ClassesDAO extends DaoGenericoImpl<Classes, Integer>{

	public ClassesDAO(EntityManager conexao) {
		this.conexao = conexao;
		this.criteria = conexao.getCriteriaBuilder();
	}
}
