package br.com.tarefa.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tarefa.exception.ErroAoInserirUsuarioException;
import br.com.tarefa.model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	public void inserir(Usuario u) throws ErroAoInserirUsuarioException {
		try (Connection c = ConnectionFactory.getConnection()) {
			String sql = "INSERT INTO usuario(login, email, nome, senha, pontos) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setString(1, u.getLogin());
			stm.setString(2, u.getEmail());
			stm.setString(3, u.getNome());
			stm.setString(4, u.getSenha());
			stm.setInt(5, u.getPontos());
		
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ErroAoInserirUsuarioException("Erro ao inserir o usuario no banco de dados");
		}
	}

	public Usuario recuperar(String login) {
		
		Usuario usuario = new Usuario();
		
		try (Connection c = ConnectionFactory.getConnection()) {
			String sql = "SELECT * FROM usuario WHERE login = ?";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setString(1, login);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				usuario.setLogin(rs.getString("login"));
				usuario.setEmail(rs.getString("email"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setPontos(rs.getInt("pontos"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public void adicionarPontos(String login, int pontos) {

		try (Connection c = ConnectionFactory.getConnection()) {
			String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setInt(1, pontos);
			stm.setString(2, login);
			
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Usuario> ranking() {
		List<Usuario> usuarios = new ArrayList<>();
		
		try (Connection c = ConnectionFactory.getConnection()) {
			String sql = "SELECT * FROM usuario ORDER BY pontos DESC";
			PreparedStatement stm = c.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setLogin(rs.getString("login"));
				usuario.setEmail(rs.getString("email"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setPontos(rs.getInt("pontos"));
				
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
}
