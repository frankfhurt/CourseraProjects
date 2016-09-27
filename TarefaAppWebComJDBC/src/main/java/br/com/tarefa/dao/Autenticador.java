package br.com.tarefa.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Autenticador {
	public String autenticar(String login, String senha) throws Exception {
		
		try (Connection c = ConnectionFactory.getConnection()) {
			PreparedStatement ps = c.prepareStatement("SELECT nome FROM usuario WHERE login = ? AND senha = ?");
			ps.setString(1, login);
			ps.setString(2, senha);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getString("nome");
			else
				throw new Exception("Não foi possível autenticar o usuário!");
		}
	}
}
