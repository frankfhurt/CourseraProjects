
public class Autenticador {

	public Usuario loggar(String login, String senha) throws LoginException {
		
		if (login.equals("frank") && senha.equals("senhadofrank")) {
			return new Usuario(login);
		}
		
		throw new LoginException("O usuario e senha não batem!", login);
		
	}
	
}
