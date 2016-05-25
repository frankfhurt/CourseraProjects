package br.com.cdsoft.pizzaria;

import java.util.Set;

public class Principal {

	public static void main(String[] args) {
		Pizza pizza1 = new Pizza();
		pizza1.adicionaIngrediente("Presunto");
		pizza1.adicionaIngrediente("Azeitonas verdes");

		Pizza pizza2 = new Pizza();
		pizza2.adicionaIngrediente("Frango desfiado");
		pizza2.adicionaIngrediente("Catupiry");
		pizza2.adicionaIngrediente("Cebola");
		pizza2.adicionaIngrediente("Orégano");

		Pizza pizza3 = new Pizza();
		pizza3.adicionaIngrediente("Calabresa moída");
		pizza3.adicionaIngrediente("Cebola");
		pizza3.adicionaIngrediente("Pimentão");
		pizza3.adicionaIngrediente("Champignon");
		pizza3.adicionaIngrediente("Mussarela de búfala");
		pizza3.adicionaIngrediente("Damasco");

		CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
		carrinhoDeCompras.adicionarPizza(pizza1);
		carrinhoDeCompras.adicionarPizza(pizza2);
		carrinhoDeCompras.adicionarPizza(pizza3);

		System.out.println("Total do carrinho de Compras "
				+ carrinhoDeCompras.totalDoCarrinho());

		Set<String> ingredientes = Pizza.INGREDIENTES.keySet();

		for (String keyString : ingredientes) {
			System.out.println(keyString + " - "
					+ Pizza.INGREDIENTES.get(keyString));
		}

	}

}
