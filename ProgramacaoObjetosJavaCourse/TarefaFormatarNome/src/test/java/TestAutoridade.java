import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestAutoridade {

	private Autoridade autoridade;
	
	@Test
	public void testTratamentoInformal() {
		autoridade = new Autoridade("João", "Silva", new Informal());
		assertEquals("João", autoridade.getTratamento());
		
	}
	
	@Test
	public void testTratamentoRespeitosoMasc() {
		autoridade = new Autoridade("João", "Silva", new Respeitoso("masculino"));
		assertEquals("Sr. Silva", autoridade.getTratamento());
		
	}

	@Test
	public void testTratamentoRespeitosoFem() {
		autoridade = new Autoridade("Maria", "Silva", new Respeitoso("feminino"));
		assertEquals("Sra. Silva", autoridade.getTratamento());
		
	}
	
	@Test
	public void testTratamentoComTitulo() {
		autoridade = new Autoridade("João", "Silva", new ComTitulo("Excelentíssimo"));
		assertEquals("Excelentíssimo João Silva", autoridade.getTratamento());
		
	}
}
