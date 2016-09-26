package br.com.tarefa.repositorio;

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
}
