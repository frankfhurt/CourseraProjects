import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.tarefa.dao.ComentarioDAO;
import br.com.tarefa.model.Comentario;

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
		jdt.setDataSet(loader.load("/setUp.xml"));
		jdt.onSetup();
	}
	
	@Test
	public void inserirComentario() throws Exception {
		Comentario comentario = new Comentario();
		comentario.setComentario("Teste de comentário do Fernando no Tópico do Pedro");
		comentario.setIdTopico(2);
		comentario.setLogin("fernando");
		
		comentDao.inserir(comentario);
		
		IDataSet currentDataset = jdt.getConnection().createDataSet();
		ITable currentTable = currentDataset.getTable("COMENTARIO");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataset = loader.load("/validacaoDeInsertComentario.xml");
		ITable expectedTable = expectedDataset.getTable("COMENTARIO");
		
		Assertion.assertEquals(expectedTable, currentTable);
	}

	@Test
	public void listarComentarios() throws Exception {
		
		IDataSet currentDataset = jdt.getConnection().createDataSet();
		ITable currentTable = currentDataset.getTable("COMENTARIO");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataset = loader.load("/validacaoComentario.xml");
		ITable expectedTable = expectedDataset.getTable("COMENTARIO");
		
		Assertion.assertEquals(expectedTable, currentTable);
	}
}
