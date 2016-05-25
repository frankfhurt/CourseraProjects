import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TesteCarrinhoDeCompras {

	CarrinhoDeCompras carrinho;
	
	@Before
	public void inicializaCarrinho(){
		carrinho = new CarrinhoDeCompras();
	}
	

	@Test
	public void testInsereUmProdutoNoCarrinho() {
		Produto produto = new Produto();
		produto.setCodigo(123);
		produto.setNome("Carne");
		produto.setPreco(10);
		
		carrinho.adicionaProduto(produto, 1);
		
		assertEquals(10, carrinho.getValorTotal());
		assertEquals(1, carrinho.getQtdeProdutosDiferentesNoCarrinho());
	}

	@Test
	public void testInsereTresProdutosDiferentesNoCarrinho() {
		Produto produto1 = new Produto();
		produto1.setCodigo(123);
		produto1.setNome("Carne");
		produto1.setPreco(10);
		
		Produto produto2 = new Produto();
		produto2.setCodigo(1234);
		produto2.setNome("Bolacha");
		produto2.setPreco(5);
		
		Produto produto3 = new Produto();
		produto3.setCodigo(12345);
		produto3.setNome("Arroz");
		produto3.setPreco(7);
		
		carrinho.adicionaProduto(produto1, 1);
		carrinho.adicionaProduto(produto2, 1);
		carrinho.adicionaProduto(produto3, 1);
		
		assertEquals(22, carrinho.getValorTotal());
		assertEquals(3, carrinho.getQtdeProdutosDiferentesNoCarrinho());
	}
	
	@Test
	public void testInsereMaisQuantidadeDoProduto(){
		Produto produto = new Produto();
		produto.setCodigo(123);
		produto.setNome("Carne");
		produto.setPreco(10);
		
		carrinho.adicionaProduto(produto, 3);
		carrinho.adicionaProduto(produto, 2);
		
		assertEquals(50, carrinho.getValorTotal());
		assertEquals(1, carrinho.getQtdeProdutosDiferentesNoCarrinho());
		
	}
	
	@Test
	public void testInsereProdutoComTamanho(){
		ProdutoComTamanho produto = new ProdutoComTamanho();
		produto.setCodigo(123);
		produto.setNome("Carne");
		produto.setPreco(10);
		produto.setTamanho(2);
		
		carrinho.adicionaProduto(produto, 1);
		
		assertEquals(10, carrinho.getValorTotal());
		assertEquals(1, carrinho.getQtdeProdutosDiferentesNoCarrinho());
		
	}
	
	@Test
	public void testRemoveProduto(){
		Produto produto1 = new Produto();
		produto1.setCodigo(123);
		produto1.setNome("Carne");
		produto1.setPreco(10);
		
		Produto produto2 = new Produto();
		produto2.setCodigo(1234);
		produto2.setNome("Bolacha");
		produto2.setPreco(5);
		
		Produto produto3 = new Produto();
		produto3.setCodigo(12345);
		produto3.setNome("Arroz");
		produto3.setPreco(7);
		
		// adiciona 3 produtos
		carrinho.adicionaProduto(produto1, 1);
		carrinho.adicionaProduto(produto2, 1);
		carrinho.adicionaProduto(produto3, 1);
		
		// remove 1 produto
		carrinho.removeProduto(produto1, 1);
		
		assertEquals(12, carrinho.getValorTotal());
		assertEquals(2, carrinho.getQtdeProdutosDiferentesNoCarrinho());
	}

}
