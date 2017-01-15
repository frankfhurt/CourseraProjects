package br.com.coursera.dao;

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
			if(entityManager.isOpen()){
				entityManager.close();
			}
		}	
	}
	
	public Usuario recuperar(String login, String senha) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		Usuario usuario;
		
		String consulta = "select u from Usuario u where u.login = :login and u.senha = :senha";
		
		TypedQuery<Usuario> query = entityManager.createQuery(consulta, Usuario.class);
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		
		usuario = query.getSingleResult();
		
		return usuario;
	}
}
