package br.com.coursera.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.coursera.model.Livro;

public class LivroDAO {

	private static LivroDAO livroDAO;
	
	private LivroDAO() {}

	public static LivroDAO getInstance() {
		if (livroDAO == null)
			livroDAO = new LivroDAO();

		return livroDAO;
	}
	
	public List<Livro> getAll() {
		
		EntityManager entityManager = JpaUtil.getEntityManager();
		String consulta = "select l from Livro l";
		
		TypedQuery<Livro> query = entityManager.createQuery(consulta, Livro.class);
		
		return query.getResultList();
	}
	
	public Livro findById(Long id) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		
		return entityManager.find(Livro.class, id);
	}
	
	
}
