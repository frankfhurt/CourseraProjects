import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Autenticador {

	private static final String CON_URL = "jdbc:postgresql://localhost:5432/usuarios";
	private static final String USER = "postgres";
	private static final String PASS = "postgres";
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String autenticar(String login, String senha) throws Exception {
		
		try (Connection c = DriverManager.getConnection(CON_URL, USER, PASS)) {
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
