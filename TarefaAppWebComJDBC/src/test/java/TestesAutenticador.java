import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.dbunit.JdbcDatabaseTester;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import br.com.tarefa.dao.Autenticador;

public class TestesAutenticador {

	private JdbcDatabaseTester jdt;
	private static final String CON_URL = "jdbc:postgresql://localhost:5432/TarefaSemana4";
	private static final String USER = "postgres";
	private static final String PASS = "postgres";
	private static final Autenticador autDao = new Autenticador();
	
	@Before
	public void setUp() throws Exception {
		jdt = new JdbcDatabaseTester("org.postgresql.Driver", CON_URL, USER, PASS);
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jdt.setDataSet(loader.load("/setUpUsuarios.xml"));
		jdt.onSetup();
	}

	@Test
	public void autenticacao() {
		String login = "pedro";
		String senha = "senhaDoPedro";
		
		String nomeUsuario = null;
		String nomeEsperado = "Pedro Joao";
		
		try {
			nomeUsuario = autDao.autenticar(login, senha);
		} catch (Exception e) {
			fail();
		}
		
		assertEquals(nomeEsperado, nomeUsuario);
	}

}
