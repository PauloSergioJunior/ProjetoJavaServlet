package br.com.projeto.jpa;

import java.io.Serializable;
import java.util.Collection;

import com.sun.xml.bind.v2.model.core.ID;

public interface GenericDao<T, ID extends Serializable> {


	public void save(T instance) throws Exception;
	
	public T findById(ID id) throws Exception;
	
	public void deleteById (ID id) throws Exception;
	
	public void update (T instance) throws Exception;
	
	public Collection<T> listAll() throws Exception;
	
}
