package br.com.cdsoft.pizzaria;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de teste para o {@link CarrinhoDeCompras}
 * 
 * @author Cleber da Silveira.
 *
 */
public class CarrinhoDeComprasTest {

	private CarrinhoDeCompras carrinhoDeCompras;

	@Before
	public void setup() {
		carrinhoDeCompras = new CarrinhoDeCompras();
	}

	@After
	public void tearDown() {
		carrinhoDeCompras = null;
	}

	@Test(expected = RuntimeException.class)
	public void adicionaPizzaSemIngredientes() {
		carrinhoDeCompras.adicionarPizza(new Pizza());
	}

	@Test
	public void totalDuasPizzasComDoisIngredientes() {
		carrinhoDeCompras.adicionarPizza(criarPizzaComIngredientes(2));
		carrinhoDeCompras.adicionarPizza(criarPizzaComIngredientes(2));
		assertThat(30d, is(carrinhoDeCompras.totalDoCarrinho()));

	}

	@Test
	public void totalDuasPizzasComDoisETresIngredientes() {
		carrinhoDeCompras.adicionarPizza(criarPizzaComIngredientes(2));
		carrinhoDeCompras.adicionarPizza(criarPizzaComIngredientes(3));
		assertThat(35d, is(carrinhoDeCompras.totalDoCarrinho()));

	}

	@Test
	public void totalTresPizzasComTresEQuatroIngredientes() {
		carrinhoDeCompras.adicionarPizza(criarPizzaComIngredientes(3));
		carrinhoDeCompras.adicionarPizza(criarPizzaComIngredientes(4));
		carrinhoDeCompras.adicionarPizza(criarPizzaComIngredientes(4));
		assertThat(60d, is(carrinhoDeCompras.totalDoCarrinho()));

	}

	@Test
	public void totalQuatroPizzasComQuatroECincoIngredientes() {
		carrinhoDeCompras.adicionarPizza(criarPizzaComIngredientes(3));
		carrinhoDeCompras.adicionarPizza(criarPizzaComIngredientes(4));
		carrinhoDeCompras.adicionarPizza(criarPizzaComIngredientes(4));
		carrinhoDeCompras.adicionarPizza(criarPizzaComIngredientes(5));
		assertThat(80d, is(carrinhoDeCompras.totalDoCarrinho()));

	}

	@Test
	public void totalCincoPizzasComQuatroECincoIngredientes() {
		carrinhoDeCompras.adicionarPizza(criarPizzaComIngredientes(3));
		carrinhoDeCompras.adicionarPizza(criarPizzaComIngredientes(4));
		carrinhoDeCompras.adicionarPizza(criarPizzaComIngredientes(4));
		carrinhoDeCompras.adicionarPizza(criarPizzaComIngredientes(5));
		carrinhoDeCompras.adicionarPizza(criarPizzaComIngredientes(5));
		assertThat(100d, is(carrinhoDeCompras.totalDoCarrinho()));

	}

	private Pizza criarPizzaComIngredientes(final int numeroIngredientes) {
		Pizza pizza = new Pizza();
		for (int n = 0; n < numeroIngredientes; n++) {
			pizza.adicionaIngrediente(n + "");
		}
		return pizza;
	}
}
