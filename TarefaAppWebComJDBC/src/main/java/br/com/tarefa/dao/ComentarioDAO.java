package br.com.tarefa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tarefa.model.Comentario;

public class ComentarioDAO {

	public void inserir(Comentario comentario) {
		
		try (Connection c = ConnectionFactory.getConnection()) {
			String sql = "INSERT INTO comentario(comentario, login, id_topico) VALUES (?, ?, ?)";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setString(1, comentario.getComentario());
			stm.setString(2, comentario.getLogin());
			stm.setLong(3, comentario.getIdTopico());
			
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Comentario> getComentarios(long idTopico) {
		
		List<Comentario> comentarios = new ArrayList<>();
		
		try (Connection c = ConnectionFactory.getConnection()) {
			String sql = "SELECT * FROM comentario WHERE id_topico = ?";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setLong(1, idTopico);
			
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				Comentario comentario = new Comentario();
				comentario.setComentario(rs.getString("comentario"));
				comentario.setId(rs.getLong("id_comentario"));
				comentario.setIdTopico(rs.getLong("id_topico"));
				
				comentarios.add(comentario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comentarios;
	}
}
