/**
 * 
 */
package br.com.projeto.empresa.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.projeto.empresa.model.Empresa;
import br.com.projeto.jpa.JpaUtils;

/**
 * @author carlos
 *
 */
public class EmpresasImpl implements Empresas {
	
	EntityManagerFactory emf = JpaUtils.getEntityManagerFactory();
	EntityManager factory = null;

	@Override
	public Empresa findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Empresa instance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Empresa> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Empresa empresa) throws Exception {
		this.factory = emf.createEntityManager();
		try {
			this.factory.getTransaction().begin();
			if(empresa.getId() == null) {
				this.factory.persist(empresa);
			}else {
				this.factory.merge(empresa);
			}
			this.factory.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage();
			this.factory.getTransaction().rollback();
		}finally{
			this.factory.close();
		}
	}

}
