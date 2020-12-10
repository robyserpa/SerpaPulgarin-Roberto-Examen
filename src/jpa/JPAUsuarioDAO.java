package jpa;

import javax.persistence.Query;

import dao.UsuarioDAO;
import entidades.Usuario;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, Integer> implements UsuarioDAO {

	public JPAUsuarioDAO() {
		super(Usuario.class);
	}

	@Override
	public Usuario findUsuarioByCedulaByTelefono(String key) {
		String jpql = "SELECT u FROM Usuarios u "
				+ "WHERE (u.usuCedula LIKE '" + key + "' OR u.usuTel.telNumero LIKE '" + key + "') ";
		em.clear();
		Query query = em.createQuery(jpql);
		Usuario usuario = (Usuario)query.getSingleResult();
		em.refresh(usuario);
		return usuario;
	}

}
