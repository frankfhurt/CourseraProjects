import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteProdutoComTamanho {

	ProdutoComTamanho prod;

	@Before
	public void inicializaProd(){
		prod = new ProdutoComTamanho();
		prod.setCodigo(1234);
		prod.setTamanho(2);
	}
	
	@Test
	public void testProdutosComCodigosIguaisETamanhosIguais() {
		ProdutoComTamanho prod2 = new ProdutoComTamanho();
		prod2.setCodigo(1234);
		prod2.setTamanho(2);
		
		assertEquals(prod, prod2);
	}

	@Test
	public void testProdutosComCodigosIguaisETamanhosDiferentes() {
		ProdutoComTamanho prod2 = new ProdutoComTamanho();
		prod2.setCodigo(1234);
		prod2.setTamanho(5);
		
		assertNotEquals(prod, prod2);
	}

	@Test
	public void testProdutosComCodigosDiferentesETamanhosDiferentes() {
		ProdutoComTamanho prod2 = new ProdutoComTamanho();
		prod2.setCodigo(1234567);
		prod2.setTamanho(5);
		
		assertNotEquals(prod, prod2);
	}

	@Test
	public void testProdutosComCodigosDiferentesETamanhosIguais() {
		ProdutoComTamanho prod2 = new ProdutoComTamanho();
		prod2.setCodigo(1234567);
		prod2.setTamanho(2);
		
		assertNotEquals(prod, prod2);
	}
	
}
