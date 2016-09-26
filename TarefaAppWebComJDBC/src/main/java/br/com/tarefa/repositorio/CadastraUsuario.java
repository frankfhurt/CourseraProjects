package br.com.tarefa.repositorio;

import br.com.tarefa.exception.ErroAoInserirUsuarioException;
import br.com.tarefa.model.Usuario;

public class CadastraUsuario {

	private UsuarioDAO usuarioDao = new UsuarioDAOImpl();
	private final Usuario usuario;

	public CadastraUsuario(Usuario usuario) {
		super();
		this.usuario = usuario;
	}

	public boolean cadatrarUsuario() {
		try {
			usuarioDao.inserir(usuario);
			return true;
		} catch (ErroAoInserirUsuarioException e) {
			e.printStackTrace();
			return false;
		}
	}
}
