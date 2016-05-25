
public class Principal {

	public static void main(String[] args) {
		
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		
		// Cria 3 pizzas com ingredientes diferentes
		Pizza pizza1 = new Pizza();
		Pizza pizza2 = new Pizza();
		Pizza pizza3 = new Pizza();
		
		pizza1.adicionaIngrediente("Mussarela");
		pizza1.adicionaIngrediente("Calabresa");

		pizza2.adicionaIngrediente("Mussarela");
		pizza2.adicionaIngrediente("Calabresa");
		pizza2.adicionaIngrediente("Cebola");

		pizza3.adicionaIngrediente("Mussarela");
		pizza3.adicionaIngrediente("Calabresa");
		pizza3.adicionaIngrediente("Cebola");
		pizza3.adicionaIngrediente("Catupiry");
		pizza3.adicionaIngrediente("Bacon");
		pizza3.adicionaIngrediente("Ovo");
		
		// Adiciona essas Pizzas em um CarrinhoDeCompra
		carrinho.adicionarPizza(pizza1);
		carrinho.adicionarPizza(pizza2);
		carrinho.adicionarPizza(pizza3);

		// Imprime o total do CarrinhoDeCompra
		System.out.println("Valor total do carrinho: " + carrinho.getValorTotal());

		// Imprime a quantidade utilizada de cada ingrediente
		System.out.println("Total de ingredientes gastos:");
		System.out.println(Pizza.ingredientesGastos);

	}

}