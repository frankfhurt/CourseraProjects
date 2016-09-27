import static org.junit.Assert.fail;

import org.dbunit.JdbcDatabaseTester;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import br.com.tarefa.dao.ComentarioDAO;

public class TestesComentarioDAO {

	private JdbcDatabaseTester jdt;
	private static final String CON_URL = "jdbc:postgresql://localhost:5432/TarefaSemana4";
	private static final String USER = "postgres";
	private static final String PASS = "postgres";
	private static final ComentarioDAO comentDao = new ComentarioDAO();
	
	@Before
	public void setUp() throws Exception {
		jdt = new JdbcDatabaseTester("org.postgresql.Driver", CON_URL, USER, PASS);
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jdt.setDataSet(loader.load("/setUpUsuarios.xml"));
		jdt.setDataSet(loader.load("/setUpComentarios.xml"));
		jdt.onSetup();
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
