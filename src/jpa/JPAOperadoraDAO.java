package jpa;

import javax.persistence.Query;

import dao.OperadoraDAO;
import entidades.Operadora;

public class JPAOperadoraDAO extends JPAGenericDAO<Operadora, Integer> implements OperadoraDAO {

	public JPAOperadoraDAO() {
		super(Operadora.class);
	}

	@Override
	public Operadora findOperadoraByTelId(int telId) {
		String jpql = "SELECT o FROM Operadoras o WHERE o.telefono.telId = " + telId;
		Query query = em.createQuery(jpql, Operadora.class);
		return (Operadora) query.getSingleResult();
	}

}
