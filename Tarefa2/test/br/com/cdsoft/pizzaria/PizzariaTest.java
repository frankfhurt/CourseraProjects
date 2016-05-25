package br.com.cdsoft.pizzaria;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de teste para {@link Pizza}
 * 
 * @author Cleber da Silveira
 */
public class PizzariaTest {

	private Pizza pizza;
	private static final double QUINZE = 15d;
	private static final double VINTE = 20d;
	private static final double VINTE_E_TRES = 23d;

	@Before
	public void setUp() throws Exception {
		Pizza.limparIngredientes();
		pizza = new Pizza();
	}

	@After
	public void tearDown() {
		pizza = null;
	}

	@Test
	public void pizzaComUmIngrediente() {
		pizza.adicionaIngrediente("Calabresa");
		assertThat(QUINZE, is(pizza.getPreco()));
	}

	@Test
	public void pizzaComUmIngredienteQtd() {
		pizza.adicionaIngrediente("Calabresa");
		assertThat(1, is(pizza.getQuantidadeIngredientes()));
	}

	@Test
	public void pizzaComDoisIngredientes() {
		pizza.adicionaIngrediente("Calabresa");
		pizza.adicionaIngrediente("Queijo");
		assertThat(QUINZE, is(pizza.getPreco()));
	}

	@Test
	public void pizzaComDoisIngredientesQtd() {
		pizza.adicionaIngrediente("Calabresa");
		pizza.adicionaIngrediente("Queijo");
		assertThat(2, is(pizza.getQuantidadeIngredientes()));
	}

	@Test
	public void pizzaComTresIngredientes() {
		pizza.adicionaIngrediente("Calabresa");
		pizza.adicionaIngrediente("Queijo");
		pizza.adicionaIngrediente("Tomate");
		assertThat(VINTE, is(pizza.getPreco()));
	}

	@Test
	public void pizzaComTresIngredientesQtd() {
		pizza.adicionaIngrediente("Calabresa");
		pizza.adicionaIngrediente("Queijo");
		pizza.adicionaIngrediente("Tomate");
		assertThat(3, is(pizza.getQuantidadeIngredientes()));
	}

	@Test
	public void pizzaComQuatroIngredientes() {
		pizza.adicionaIngrediente("Calabresa");
		pizza.adicionaIngrediente("Queijo");
		pizza.adicionaIngrediente("Tomate");
		pizza.adicionaIngrediente("Pimentão");
		assertThat(VINTE, is(pizza.getPreco()));
	}

	@Test
	public void pizzaComQuatroIngredientesQtd() {
		pizza.adicionaIngrediente("Calabresa");
		pizza.adicionaIngrediente("Queijo");
		pizza.adicionaIngrediente("Tomate");
		pizza.adicionaIngrediente("Pimentão");
		assertThat(4, is(pizza.getQuantidadeIngredientes()));
	}

	@Test
	public void pizzaComCincoIngredientesQtd() {
		pizza.adicionaIngrediente("Calabresa");
		pizza.adicionaIngrediente("Queijo");
		pizza.adicionaIngrediente("Tomate");
		pizza.adicionaIngrediente("Pimentão");
		pizza.adicionaIngrediente("Ovo");
		assertThat(5, is(pizza.getQuantidadeIngredientes()));
	}

	@Test
	public void pizzaComCincoIngredientes() {
		pizza.adicionaIngrediente("Calabresa");
		pizza.adicionaIngrediente("Queijo");
		pizza.adicionaIngrediente("Tomate");
		pizza.adicionaIngrediente("Pimentão");
		pizza.adicionaIngrediente("Ovo");
		assertThat(VINTE, is(pizza.getPreco()));
	}

	@Test
	public void pizzaComMaisDeCincoIngredientesQtd() {
		pizza.adicionaIngrediente("Calabresa");
		pizza.adicionaIngrediente("Queijo");
		pizza.adicionaIngrediente("Tomate");
		pizza.adicionaIngrediente("Pimentão");
		pizza.adicionaIngrediente("Ovo");
		pizza.adicionaIngrediente("Cebola");
		assertThat(6, is(pizza.getQuantidadeIngredientes()));
	}

	@Test
	public void pizzaComMaisDeCincoIngredientes() {
		pizza.adicionaIngrediente("Calabresa");
		pizza.adicionaIngrediente("Queijo");
		pizza.adicionaIngrediente("Tomate");
		pizza.adicionaIngrediente("Pimentão");
		pizza.adicionaIngrediente("Ovo");
		pizza.adicionaIngrediente("Cebola");
		assertThat(VINTE_E_TRES, is(pizza.getPreco()));
	}
}
