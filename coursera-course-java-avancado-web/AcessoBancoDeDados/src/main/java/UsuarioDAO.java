import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Usuario> todosUsuarios() {
		List<Usuario> todos = new ArrayList<>();
		
		try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/usuarios", "postgres", "postgres")) {
			String sql = "SELECT login, nome, email FROM usuario";
			PreparedStatement stm = c.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setLogin(rs.getString("login"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				
				todos.add(usuario);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível preparar o acesso");
		}
		
		return todos;
	}
	
	public static void inserirUsuario(Usuario usuario) {
		try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/usuarios", "postgres", "postgres")) {
			String sql = "INSERT INTO public.usuario(login, nome, email) VALUES (?, ?, ?)";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setString(1, usuario.getLogin());
			stm.setString(2, usuario.getNome());
			stm.setString(3, usuario.getEmail());
		
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
