package br.com.cdsoft.pizzaria;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de carrinho de compras para adicionar as pizzas.
 * 
 * @author Cleber da Silveira
 * 
 */
public class CarrinhoDeCompras {
	private List<Pizza> pizzas = new ArrayList<Pizza>();

	/**
	 * Método responsável por adicionar uma {@link Pizza}
	 * 
	 * @param pizza
	 *            {@link Pizza}
	 */
	public void adicionarPizza(final Pizza pizza) {
		if (pizza.getQuantidadeIngredientes() > 0) {
			pizzas.add(pizza);
		} else {
			throw new RuntimeException("Pizza não possui ingredientes");
		}
	}

	/**
	 * Método que retornar o total do carrinho.
	 * 
	 * @return
	 */
	public double totalDoCarrinho() {
		double total = 0D;

		for (Pizza pizza : pizzas) {
			total += pizza.getPreco();
		}
		return total;
	}

	/**
	 * Método que retornar o total de pizzas adicionadas.
	 * 
	 * @return
	 */
	public int totalPizzasAdicionadas() {
		return pizzas.size();
	}
}
