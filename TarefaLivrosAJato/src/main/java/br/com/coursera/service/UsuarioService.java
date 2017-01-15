package br.com.coursera.service;

import java.util.Optional;

import br.com.coursera.dao.UsuarioDAO;
import br.com.coursera.exception.ErroAoInserirUsuarioException;
import br.com.coursera.exception.ErroDeAutenticacaoException;
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
	
	public Usuario efetuarLogin(String login, String senha) throws ErroDeAutenticacaoException {
		Optional<Usuario> usuario = Optional.ofNullable(usuarioDao.recuperar(login, senha));
		return usuario.orElseThrow(() -> new ErroDeAutenticacaoException("Erro ao autenticar Usuario"));
	}
}
