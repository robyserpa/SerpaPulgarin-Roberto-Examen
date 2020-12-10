package jpa;

import java.util.List;

import javax.persistence.Query;

import dao.TipoDAO;
import entidades.Tipo;

public class JPATipoDAO extends JPAGenericDAO<Tipo, Integer> implements TipoDAO {

	public JPATipoDAO() {
		super(Tipo.class);
	}

	@Override
	public Tipo findTypoByTelId(int telId) {
		String jpql = "SELECT t FROM tipo t WHERE t.telefono.telId = " + telId;
		Query query = em.createQuery(jpql, Tipo.class);
		return (Tipo) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tipo> findAll() {
		String jpql = "SELECT * FROM tipo";
		Query query = em.createQuery(jpql, Tipo.class);
		return (List<Tipo>) query.getResultList();
	}



}
