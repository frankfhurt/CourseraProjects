package br.com.coursera.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.coursera.exception.ErroAoInserirUsuarioException;
import br.com.coursera.model.Usuario;

public class UsuarioDAO {

	private static UsuarioDAO usuarioDAO;
	
	private UsuarioDAO() {}

	public static UsuarioDAO getInstance() {
		if (usuarioDAO == null)
			usuarioDAO = new UsuarioDAO();

		return usuarioDAO;
	}
	
	public void inserir(Usuario usuario) throws ErroAoInserirUsuarioException {
		EntityManager entityManager = JpaUtil.getEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			
			entityManager.persist(usuario);
		
			entityManager.getTransaction().commit();
		} catch (Exception e){
			e.printStackTrace();
			if(entityManager.isOpen()){
				entityManager.getTransaction().rollback();
			}
		} finally {
			JpaUtil.closeEntityManager();
		}
	}
	
	public Usuario autenticar(String email, String senha) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		String consulta = "select u from Usuario u where u.email = :email and u.senha = :senha";
		
		TypedQuery<Usuario> query = entityManager.createQuery(consulta, Usuario.class);
		query.setParameter("email", email);
		query.setParameter("senha", senha);
		
		return query.getSingleResult();
	}

	public List<Usuario> getRanking() {
		EntityManager entityManager = JpaUtil.getEntityManager();
		String consulta = "select u from Usuario u order by u.pontos desc";
		
		TypedQuery<Usuario> query = entityManager.createQuery(consulta, Usuario.class);
		
		return query.getResultList();
	}
	
	public Usuario getByEmail(String email) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		String consulta = "select u from Usuario u where u.email = :email";
		
		TypedQuery<Usuario> query = entityManager.createQuery(consulta, Usuario.class);
		query.setParameter("email", email);
		
		return query.getSingleResult();
	}

	public Usuario update(Usuario usuario) {
		Usuario usr = null;
		EntityManager entityManager = JpaUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			
			usr = entityManager.merge(usuario);
		
			entityManager.getTransaction().commit();
		} catch (Exception e){
			e.printStackTrace();
			if(entityManager.isOpen()){
				entityManager.getTransaction().rollback();
			}
		} finally {
			JpaUtil.closeEntityManager();
		}
		
		return usr;
	}
}
