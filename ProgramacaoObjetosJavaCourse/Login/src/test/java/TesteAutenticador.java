import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class TesteAutenticador {

	@Test
	public void loginComSucesso() throws LoginException {
		
		Autenticador a = new Autenticador();
		Usuario u = a.loggar("frank", "senhadofrank");
		assertEquals("frank", u.getLogin());
		
	}

	@Test(expected=LoginException.class)
	public void loginFalha() throws LoginException {
		
		Autenticador a = new Autenticador();
		Usuario u = a.loggar("frank", "senhaerradadofrank");
		assertEquals("frank", u.getLogin());
		
	}
	
	@Test
	public void informacaoDoErro() {
		
		Autenticador a = new Autenticador();
		Usuario u;
		try {
			u = a.loggar("frank", "senhaerradadofrank");
			fail();
		} catch (LoginException e) {
			assertEquals("frank", e.getLogin());
		}
		
	}

	
}
