package br.com.coursera.service;

import java.util.List;

import br.com.coursera.dao.LivroDAO;
import br.com.coursera.model.Livro;

public class LivroService {

	private LivroDAO livroDao = LivroDAO.getInstance();

	public LivroService() {
	}
	
	public List<Livro> listarLivros () {
		return livroDao.getAll();
	}
	
	public Livro buscarPorId(Long id) {
		return livroDao.findById(id);
	}
	
}
