import javax.persistence.EntityManager;

public class Principal {
	
	public static void main(String[] args) {
		System.out.println("Inicio");

		EntityManager entityManager = JpaUtil.getEntityManager();
		
		Cachorro labrador;
		Cachorro poudle;
		Pessoa pessoa = null;
		
		// instancia objetos
//		labrador = new Cachorro("tomy", "labrador");
//		poudle = new Cachorro("pupi", "poudle");
//		pessoa = new Pessoa("Franklyn");
//		pessoa.adicionaCachorros(labrador, poudle);
		
		
		// persiste a pessoa e cachorro
//		try {
//			entityManager.getTransaction().begin();
//			entityManager.persist(pessoa);
//			entityManager.persist(labrador);
//			entityManager.persist(poudle);
//		} catch (Exception e) {
//			entityManager.getTransaction().rollback();
//			entityManager.close();
//		} finally {
//			entityManager.getTransaction().commit();
//			entityManager.close();
//		}

		// persiste a pessoa la.
		try {
			entityManager.getTransaction().begin();
			pessoa = entityManager.find(Pessoa.class, 2L);
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			entityManager.close();
		} finally {
			if (entityManager.isOpen())
				entityManager.close();
		}

		System.out.println(pessoa.toString());
		pessoa.setNome("Bruna");
		
	}
}
