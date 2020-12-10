package jpa;

import java.util.List;

import javax.persistence.Query;

import dao.TelefonoDAO;
import entidades.Telefono;

public class JPATelefonoDAO extends JPAGenericDAO<Telefono, Integer> implements TelefonoDAO {

	public JPATelefonoDAO() {
		super(Telefono.class);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Telefono> findTelefonosByUsuId(int usuId) {
		String jpql = "SELECT t FROM Telefonos t WHERE t.usuario.usuId = " + usuId;
		Query query = em.createQuery(jpql, Telefono.class);
		return (List<Telefono>) query.getResultList();
	}

}
