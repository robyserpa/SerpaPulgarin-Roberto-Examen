package jpa;

import dao.DAOFactory;
import dao.OperadoraDAO;
import dao.TelefonoDAO;
import dao.TipoDAO;
import dao.UsuarioDAO;

public class JPADAOFactory extends DAOFactory {

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new JPAUsuarioDAO();
	}

	@Override
	public TelefonoDAO getTelefonoDAO() {
		return new JPATelefonoDAO();
	}

	@Override
	public OperadoraDAO getOperadoraDAO() {
		return new JPAOperadoraDAO();
	}

	@Override
	public TipoDAO getTipoDAO() {
		return new JPATipoDAO();
	}

	
}
