package br.com.tarefa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tarefa.model.Topico;
import br.com.tarefa.model.TopicoUsuario;
import br.com.tarefa.model.Usuario;

public class TopicoDAO {

	public void inserir(Topico topico) {
		try (Connection c = ConnectionFactory.getConnection()) {
			
			String sql = "INSERT INTO topico(titulo, conteudo, login) VALUES (?, ?, ?)";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setString(1, topico.getTitulo());
			stm.setString(2, topico.getConteudo());
			stm.setString(3, topico.getLogin());
			
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Topico> recuperarTopicos() {
		
		List<Topico> topicos = new ArrayList<>();
		
		try (Connection c = ConnectionFactory.getConnection()) {
			String sql = "SELECT * FROM topico";
			PreparedStatement stm = c.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				Topico topico = new Topico();
				
				topico.setId(rs.getInt("id_topico"));
				topico.setTitulo(rs.getString("titulo"));
				topico.setLogin(rs.getString("login"));
				topico.setConteudo(rs.getString("conteudo"));
				
				topicos.add(topico);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return topicos;
	}
	
	public List<TopicoUsuario> getTopicos() {

		List<TopicoUsuario> topicos = new ArrayList<>();
		
		try (Connection c = ConnectionFactory.getConnection()) {
			String sql = "SELECT t.*, u.nome FROM topico t INNER JOIN usuario u ON t.login = u.login;";
			PreparedStatement stm = c.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				Topico topico = new Topico();
				topico.setId(rs.getInt("id_topico"));
				topico.setTitulo(rs.getString("titulo"));
				topico.setLogin(rs.getString("login"));
				topico.setConteudo(rs.getString("conteudo"));
				
				Usuario usuario = new Usuario();
				usuario.setNome(rs.getString("nome"));
				
				TopicoUsuario topicoUsuario = new TopicoUsuario(topico, usuario);
				
				topicos.add(topicoUsuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return topicos;
	}
	
	public TopicoUsuario getTopicoUsuario(long id) {
		
		TopicoUsuario tp = null;
		
		try (Connection c = ConnectionFactory.getConnection()) {
			String sql = "SELECT t.*, u.nome, u.email, u.pontos FROM topico t INNER JOIN usuario u ON t.login = u.login WHERE t.id_topico = ?";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setLong(1, id);
			ResultSet rs = stm.executeQuery();
			
			if (rs.next()) {
				Usuario usr = new Usuario();
				Topico topico = new Topico();
				
				usr.setLogin(rs.getString("login"));
				usr.setEmail(rs.getString("email"));
				usr.setNome(rs.getString("nome"));
				usr.setPontos(rs.getInt("pontos"));
				
				topico.setId(rs.getInt("id_topico"));
				topico.setConteudo(rs.getString("conteudo"));
				topico.setTitulo(rs.getString("titulo"));
				topico.setLogin(rs.getString("login"));
				
				tp = new TopicoUsuario(topico, usr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tp;
	}
}
