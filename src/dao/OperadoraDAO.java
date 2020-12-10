package dao;

import entidades.Operadora;

public interface OperadoraDAO extends GenericDAO<Operadora, Integer>{
	
	public Operadora findOperadoraByTelId(int telId);
	
}
