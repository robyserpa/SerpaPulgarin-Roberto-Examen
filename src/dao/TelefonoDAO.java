package dao;

import java.util.List;

import entidades.Telefono;

public interface TelefonoDAO extends GenericDAO<Telefono, Integer>{
	
	public List<Telefono> findTelefonosByUsuId(int usuId);
	
}
