import static org.junit.Assert.assertEquals;

import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import br.com.tarefa.dao.UsuarioDAO;
import br.com.tarefa.dao.UsuarioDAOImpl;
import br.com.tarefa.model.Usuario;

public class TestesUsuarioDAO {

	private JdbcDatabaseTester jdt;
	private static final String CON_URL = "jdbc:postgresql://localhost:5432/coursera";
	private static final String USER = "postgres";
	private static final String PASS = "postgres";
	private static final UsuarioDAO usrDao = new UsuarioDAOImpl();
	
	@Before
	public void setUp() throws Exception {
		jdt = new JdbcDatabaseTester("org.postgresql.Driver", CON_URL, USER, PASS);
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jdt.setDataSet(loader.load("/setUp.xml"));
		jdt.onSetup();
	}
	
	@Test
	public void inserir() throws Exception {
		Usuario usuario = new Usuario();
		usuario.setLogin("gustavo");
		usuario.setEmail("gustavo@email.com.br");
		usuario.setNome("Gustavo dos Santos");
		usuario.setSenha("senhaDoGustavo");
		usuario.setPontos(17);
		
		usrDao.inserir(usuario);
		
		IDataSet currentDataset = jdt.getConnection().createDataSet();
		ITable currentTable = currentDataset.getTable("USUARIO");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataset = loader.load("/insertValidacao.xml");
		ITable expectedTable = expectedDataset.getTable("USUARIO");
		
		Assertion.assertEquals(expectedTable, currentTable);
	}
	
	@Test
	public void recuperar() {
		Usuario usuarioEsperado = new Usuario();
		usuarioEsperado.setLogin("flavia");
		usuarioEsperado.setNome("Flavia Fulana");
		usuarioEsperado.setEmail("flavia@email.com.br");
		usuarioEsperado.setSenha("senhaDaFlavia");
		usuarioEsperado.setPontos(5);

		Usuario usuarioRecuperado = usrDao.recuperar("flavia");
		
		assertEquals(usuarioEsperado, usuarioRecuperado);
	}
	
	@Test
	public void adicionarPontos() {
		usrDao.adicionarPontos("pedro", 5);
		
		Usuario usuario = usrDao.recuperar("pedro");
		
		assertEquals(15, usuario.getPontos());
	}
	
	@Test
	public void hanking() {
		List<Usuario> lista = usrDao.ranking();
		assertEquals(4, lista.size());
		assertEquals("fernando", lista.get(0).getLogin());
		assertEquals("pedro", lista.get(1).getLogin());
		assertEquals("liza", lista.get(2).getLogin());
		assertEquals("flavia", lista.get(3).getLogin());
	}
}
