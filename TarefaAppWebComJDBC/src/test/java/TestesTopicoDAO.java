import static org.junit.Assert.assertEquals;

import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import br.com.tarefa.dao.TopicoDAO;
import br.com.tarefa.model.Topico;

public class TestesTopicoDAO {

	private JdbcDatabaseTester jdt;
	private static final String CON_URL = "jdbc:postgresql://localhost:5432/TarefaSemana4";
	private static final String USER = "postgres";
	private static final String PASS = "postgres";
	private static final TopicoDAO topicoDao = new TopicoDAO();
	
	@Before
	public void setUp() throws Exception {
		jdt = new JdbcDatabaseTester("org.postgresql.Driver", CON_URL, USER, PASS);
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jdt.setDataSet(loader.load("/setUpUsuarios.xml"));
		jdt.setDataSet(loader.load("/setUpTopicos.xml"));
		jdt.onSetup();
	}
	
	@Test
	public void inserirTopico() throws Exception {
		
		Topico topico = new Topico();
		
		topico.setLogin("flavia");
		topico.setTitulo("Tópico da Flavia");
		topico.setConteudo("Conteúdo do tópico da Flavia");
		
		topicoDao.inserir(topico);
		

		IDataSet currentDataset = jdt.getConnection().createDataSet();
		ITable currentTable = currentDataset.getTable("TOPICO");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataset = loader.load("/validacaoDeRecuperacaoDeTopicos.xml");
		ITable expectedTable = expectedDataset.getTable("TOPICO");
		
		Assertion.assertEquals(expectedTable, currentTable);
	}
	
	@Test
	public void recuperaTopicos() throws Exception {
		List<Topico> topicos = topicoDao.recuperarTopicos();
		assertEquals(2, topicos.size());
	}
}
