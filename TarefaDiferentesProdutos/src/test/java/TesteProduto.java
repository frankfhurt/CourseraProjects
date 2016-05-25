import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteProduto {

	Produto prod;
	
	@Before
	public void inicializaProd(){
		prod = new Produto();
		prod.setCodigo(1234);
	}

	@Test
	public void testProdutosIguais() {
		Produto prod2 = new Produto();
		prod2.setCodigo(1234);
		
		assertEquals(prod2, prod);
	}

	@Test
	public void testProdutosDiferentes() {
		Produto prod2 = new Produto();
		prod2.setCodigo(123456);
		
		assertNotEquals(prod2, prod);
	}

}
