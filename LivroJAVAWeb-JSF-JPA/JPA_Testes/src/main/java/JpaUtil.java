import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


/**
 * 
 * @author L01482 - Franklyn Vieira da Silva
 * Exemplo de JpaUtil retirado do Livro JPA Eficaz
 * @since 02/08/2016
 *
 */
public class JpaUtil {

	private static final String PERSISTENCE_UNIT = "JPA_TESTES_HIBERNATE";

	private static ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<>();

	private static EntityManagerFactory entityManagerFactory;

	public JpaUtil() {}

	/**
	 * @return Uma instância de <b>EntityManager</b>
	 */
	public static EntityManager getEntityManager() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		}
		
		EntityManager entityManager = threadEntityManager.get();
		
		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = entityManagerFactory.createEntityManager();
			JpaUtil.threadEntityManager.set(entityManager);
		}
		
		return entityManager;
	}
	
	/**
	 * Fecha o EntityManager. Ou seja, a conexão com o DB.
	 */
	public static void closeEntityManager() {
		EntityManager em = threadEntityManager.get();
		
		if (em != null) {
			EntityTransaction transaction = em.getTransaction();
			
			if (transaction.isActive()) {
				transaction.commit();
			}
			
			em.close();
			
			threadEntityManager.set(null);
		}
	}
	
	public static void closeEntityManagerFactory() {
		closeEntityManager();
		entityManagerFactory.close();
	}
}
