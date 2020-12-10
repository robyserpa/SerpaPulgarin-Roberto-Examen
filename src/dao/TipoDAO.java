package dao;

import java.util.List;

import entidades.Tipo;

public interface TipoDAO extends GenericDAO<Tipo, Integer>{
	
	public Tipo findTypoByTelId(int telId);
	
	public List<Tipo> findAll();
	
}
