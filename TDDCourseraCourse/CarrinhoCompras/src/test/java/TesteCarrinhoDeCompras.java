import static org.junit.Assert.*;

import org.junit.Test;

public class TesteCarrinhoDeCompras {

	@Test
	public void totalCarrinho() {
		CarrinhoDeCompras c = new CarrinhoDeCompras();
		c.adicionaProduto(new Produto("tenis", 100));
		c.adicionaProduto(new Produto("camiseta", 50));
		c.adicionaProduto(new Produto("bermuda", 70));
		assertEquals(220, c.total());
	}

	@Test
	public void escutaAdicaoDeProduto() {
		CarrinhoDeCompras c = new CarrinhoDeCompras();
		MockObservadorCarrinho mock = new MockObservadorCarrinho();
		c.adicionarObservador(mock);
		c.adicionaProduto(new Produto("tenis", 100));
		mock.verificaRecebimentoProduto("tenis", 100);
	}
	
	@Test
	public void adicionarDoisObservadores() {
		CarrinhoDeCompras c = new CarrinhoDeCompras();
		MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
		MockObservadorCarrinho mock2 = new MockObservadorCarrinho();
		c.adicionarObservador(mock1);
		c.adicionarObservador(mock2);
		c.adicionaProduto(new Produto("tenis", 100));
		mock1.verificaRecebimentoProduto("tenis", 100);
		mock2.verificaRecebimentoProduto("tenis", 100);
	}
	
	@Test
	public void continuaNotificandoComErroEmObservador() {
		CarrinhoDeCompras c = new CarrinhoDeCompras();
		MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
		ObservadorCarrinho mock2 = new MockObservadorComProblema();
		MockObservadorCarrinho mock3 = new MockObservadorCarrinho();
		c.adicionarObservador(mock1);
		c.adicionarObservador(mock2);
		c.adicionarObservador(mock3);
		c.adicionaProduto(new Produto("tenis", 100));
		mock1.verificaRecebimentoProduto("tenis", 100);
		mock3.verificaRecebimentoProduto("tenis", 100);
	}
	
}
