import java.util.List;

public class PrincipalAcessoAoBancoDeDados {

	public static void main(String[] args) {
		
		List<Usuario> lista  = UsuarioDAO.todosUsuarios();
		
		lista.forEach(System.out::println);
		
		Usuario usuario = new Usuario();
		usuario.setLogin("duda");
		usuario.setNome("Maria Eduarda");
		usuario.setEmail("duda@gmail.com");

		UsuarioDAO.inserirUsuario(usuario);
		
		System.out.println("-----------------------------------------------------------------------");
		
		lista  = UsuarioDAO.todosUsuarios();

		lista.forEach(System.out::println);
	}
}
