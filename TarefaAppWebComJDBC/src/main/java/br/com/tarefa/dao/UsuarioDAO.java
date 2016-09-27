package br.com.tarefa.dao;

import java.util.List;

import br.com.tarefa.exception.ErroAoInserirUsuarioException;
import br.com.tarefa.model.Usuario;

public interface UsuarioDAO {

	// insere um novo usuário no banco de dados
	public void inserir(Usuario u) throws ErroAoInserirUsuarioException;

	// recupera o usuário pelo seu login
	public Usuario recuperar(String login);

	// adiciona os pontos para o usuário no banco
	public void adicionarPontos(String login, int pontos);

	// retorna a lista de usuários ordenada por pontos (maior primeiro)
	public List<Usuario> ranking();
}
