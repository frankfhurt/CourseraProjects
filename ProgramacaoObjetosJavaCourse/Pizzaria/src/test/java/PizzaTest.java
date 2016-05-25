import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

public class PizzaTest {

	@After
	public void zeraIngredientes(){
		Pizza.zerarRegistroIngredientes();
	}
	
	@Test
	public void testesPrecoPizza() {
		// cria as pizzas
		Pizza pizza0 = new Pizza();
		Pizza pizza1 = new Pizza();
		Pizza pizza2 = new Pizza();
		Pizza pizza3 = new Pizza();

		// adiciona uma quantidade de ingredientes para cada pizza
		pizza1.adicionaIngrediente("mussarela");
		pizza1.adicionaIngrediente("bacon");

		pizza2.adicionaIngrediente("mussarela");
		pizza2.adicionaIngrediente("bacon");
		pizza2.adicionaIngrediente("calabresa");
		pizza2.adicionaIngrediente("ovo");

		pizza3.adicionaIngrediente("mussarela");
		pizza3.adicionaIngrediente("bacon");
		pizza3.adicionaIngrediente("calabresa");
		pizza3.adicionaIngrediente("ovo");
		pizza3.adicionaIngrediente("pimentao");
		pizza3.adicionaIngrediente("oregano");

		// testa o valor de cada pizza
		assertEquals(0, pizza0.getPreco());
		assertEquals(15, pizza1.getPreco());
		assertEquals(20, pizza2.getPreco());
		assertEquals(23, pizza3.getPreco());
	}

	@Test
	public void testeRegistroIngredientes() {
		// cria as pizzas
		Pizza pizza1 = new Pizza();
		Pizza pizza2 = new Pizza();
		Pizza pizza3 = new Pizza();

		// adiciona uma quantidade de ingredientes para cada pizza
		pizza1.adicionaIngrediente("mussarela");
		pizza1.adicionaIngrediente("bacon");

		pizza2.adicionaIngrediente("mussarela");
		pizza2.adicionaIngrediente("bacon");
		pizza2.adicionaIngrediente("calabresa");
		pizza2.adicionaIngrediente("ovo");

		pizza3.adicionaIngrediente("mussarela");
		pizza3.adicionaIngrediente("bacon");
		pizza3.adicionaIngrediente("calabresa");
		pizza3.adicionaIngrediente("ovo");
		pizza3.adicionaIngrediente("pimentao");
		pizza3.adicionaIngrediente("oregano");

		// testa a quantidade de cada ingrediente
		assertEquals(new Integer(3), Pizza.ingredientesGastos.get("mussarela"));
		assertEquals(new Integer(3), Pizza.ingredientesGastos.get("bacon"));
		assertEquals(new Integer(2), Pizza.ingredientesGastos.get("calabresa"));
		assertEquals(new Integer(2), Pizza.ingredientesGastos.get("ovo"));
		assertEquals(new Integer(1), Pizza.ingredientesGastos.get("pimentao"));
		assertEquals(new Integer(1), Pizza.ingredientesGastos.get("oregano"));
	}
	

	@Test
	public void valorTotalCarrinhoTeste() {
		
		// cria um carrinho de compras
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		
		// cria as pizzas
		Pizza pizza1 = new Pizza();
		Pizza pizza2 = new Pizza();
		Pizza pizza3 = new Pizza();

		// adiciona uma quantidade de ingredientes para cada pizza
		pizza1.adicionaIngrediente("mussarela");
		pizza1.adicionaIngrediente("bacon");

		pizza2.adicionaIngrediente("mussarela");
		pizza2.adicionaIngrediente("bacon");
		pizza2.adicionaIngrediente("calabresa");
		pizza2.adicionaIngrediente("ovo");

		pizza3.adicionaIngrediente("mussarela");
		pizza3.adicionaIngrediente("bacon");
		pizza3.adicionaIngrediente("calabresa");
		pizza3.adicionaIngrediente("ovo");
		pizza3.adicionaIngrediente("pimentao");
		pizza3.adicionaIngrediente("oregano");
		
		// adiciona as pizzas no carrinho
		carrinho.adicionarPizza(pizza1);
		carrinho.adicionarPizza(pizza2);
		carrinho.adicionarPizza(pizza3);

		// testa se o valor total do carrinho esta ok
		assertEquals(58, carrinho.getValorTotal());
	}
	
	@Test
	public void pizzaVaziaCarrinho(){

		// cria carrinho de compras
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		
		// cria pizza
		Pizza pizza = new Pizza();

		// testa se o retorno é falso
		// falso significa que a pizza não tinha ingredientes e por isso não pode ser adicionada no carrinho
		assertEquals(false, carrinho.adicionarPizza(pizza));
	}

}
