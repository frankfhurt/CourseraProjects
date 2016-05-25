package br.com.cdsoft.pizzaria;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe Pizza
 * 
 * @author Cléber da Silveira
 * 
 */
public class Pizza {

	private int quantidadeIngredientes = 0;
	public static Map<String, Integer> INGREDIENTES = new HashMap<String, Integer>();

	/**
	 * Método responsável por adicionar ingredientes.
	 * 
	 * @param ingrediente
	 *            nome do ingrediente.
	 */
	public void adicionaIngrediente(final String ingrediente) {
		quantidadeIngredientes++;
		contabilizaIngrediente(ingrediente);
	}

	public void contabilizaIngrediente(final String ingrediente) {
		int quantidade = 0;
		if (INGREDIENTES.containsKey(ingrediente)) {
			quantidade = INGREDIENTES.get(ingrediente);
			INGREDIENTES.remove(ingrediente);
		}
		quantidade++;
		INGREDIENTES.put(ingrediente, quantidade);

	}

	public static void limparIngredientes() {
		INGREDIENTES.clear();
	}

	/**
	 * Método responsável por retornar o preçpo da pizza com base na quantidade
	 * de ingredientes.
	 * 
	 * @return preço.
	 */
	public double getPreco() {

		return quantidadeIngredientes <= 2 ? 15D : quantidadeIngredientes >= 3
				&& quantidadeIngredientes <= 5 ? 20 : 23;
	}

	public int getQuantidadeIngredientes() {
		return quantidadeIngredientes;
	}
}
