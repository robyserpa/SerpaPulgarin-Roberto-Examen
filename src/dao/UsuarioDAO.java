package dao;

import entidades.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario, Integer>{
	
	public Usuario findUsuarioByCedulaByTelefono(String key);
	
}
