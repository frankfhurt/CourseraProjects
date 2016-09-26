package br.com.tarefa.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String CON_URL = "jdbc:postgresql://localhost:5432/TarefaSemana4";
	private static final String USER = "postgres";
	private static final String PASS = "postgres";
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(CON_URL, USER, PASS);
	}
}
