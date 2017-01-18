package br.com.coursera.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.coursera.dao.UsuarioDAO;
import br.com.coursera.exception.ErroAoInserirUsuarioException;
import br.com.coursera.exception.ErroDeAutenticacaoException;
import br.com.coursera.model.Livro;
import br.com.coursera.model.Usuario;

public class UsuarioService {
	private UsuarioDAO usuarioDao = UsuarioDAO.getInstance();

	public UsuarioService() {}
	
	public boolean cadastrarUsuario(Usuario usuario) {
		try {
			usuarioDao.inserir(usuario);
			return true;
		} catch (ErroAoInserirUsuarioException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean verificarLeitura(String email, Livro livro) {
		Usuario usuario = usuarioDao.getByEmail(email);
		
		return usuario.getLivros().contains(livro);
	}
	
	public Usuario efetuarLogin(String login, String senha) throws ErroDeAutenticacaoException {
		Optional<Usuario> usuario = Optional.ofNullable(usuarioDao.autenticar(login, senha));
		return usuario.orElseThrow(() -> new ErroDeAutenticacaoException("Erro ao autenticar Usuario"));
	}
	
	public Usuario update(Usuario u) {
		return usuarioDao.update(u);
	}
	
	public List<Usuario> getRanking() {
		List<Usuario> usuarios = usuarioDao.getRanking();
		
		return usuarios.stream().
				filter(u -> u.getPontos() > 0).
				collect(Collectors.toList());
	}
	
	public Usuario buscarPorEmail(String email) {
		return usuarioDao.getByEmail(email);
	}
}
