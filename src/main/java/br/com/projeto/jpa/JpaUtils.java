/**
 * 
 */
package br.com.projeto.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.projeto.utils.Constantes;

/**
 * @author carlos
 *
 */
public class JpaUtils {

	private static EntityManagerFactory factory;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(Constantes.PERSISTENCE_UNIT_NAME);
		}
		return factory;
	}

	public static void shutdown() {
		if (factory != null) {
			factory.close();
		}
	}
}
