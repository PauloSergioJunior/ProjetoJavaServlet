/**
 * 
 */
package br.com.projeto.empresa.dao;

import br.com.projeto.empresa.model.Empresa;
import br.com.projeto.jpa.GenericDao;

/**
 * @author carlos
 *
 */
public interface Empresas extends GenericDao<Empresa, Long> {

	public void save(Empresa empresa) throws Exception;
}
