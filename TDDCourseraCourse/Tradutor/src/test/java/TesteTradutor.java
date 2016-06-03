import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesteTradutor {

	Tradutor t;
	
	@Before
	public void criarTradutor() {
		t = new Tradutor();
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void tradutorSemPalavras() {
		assertTrue(t.estaVazio());
	}
	
	@Test
	public void umaTraducao() {
		t.adicionaTraducao("bom", "good");
		
		assertFalse(t.estaVazio());
		assertEquals("good", t.traduzirPalavra("bom"));
	}

	@Test
	public void duasTraducoes() {
		t.adicionaTraducao("bom", "good");
		t.adicionaTraducao("mau", "bad");
		
		assertEquals("good", t.traduzirPalavra("bom"));
		assertEquals("bad", t.traduzirPalavra("mau"));
	}

	@Test
	public void duasTraducoesMesmaPalavra() {
		t.adicionaTraducao("bom", "good");
		t.adicionaTraducao("bom", "nice");
		
		assertEquals("good, nice", t.traduzirPalavra("bom"));
	}

	@Test
	public void traduzirFrase() {
		t.adicionaTraducao("guerra", "war");
		t.adicionaTraducao("é", "is");
		t.adicionaTraducao("ruim", "bad");
		
		assertEquals("war is bad", t.traduzirFrase("guerra é ruim"));
	}

	@Test
	public void traduzirFraseComDuasTraducoesMesmaPalavra() {
		t.adicionaTraducao("paz", "peace");
		t.adicionaTraducao("é", "is");
		t.adicionaTraducao("bom", "good");
		t.adicionaTraducao("bom", "nice");
		
		assertEquals("peace is good", t.traduzirFrase("paz é bom"));
	}
	
}
