package com.edutecno.modelo.dao;

import java.util.List;

public interface DAO <ClaseMapear, TipoID>{
	
	public List<ClaseMapear> listar();
	public ClaseMapear buscarPorId(TipoID id);
	public int insert(ClaseMapear objetos);
	public int update(ClaseMapear objeto);
	public int delete(TipoID id);

}
