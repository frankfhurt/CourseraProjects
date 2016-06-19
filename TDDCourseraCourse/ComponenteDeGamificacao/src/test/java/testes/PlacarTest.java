package testes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import gamificacao.Placar;

public class PlacarTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void registrarUmTipoDePontoParaUmUsuario() {
		ArmazenamentoMock mock = new ArmazenamentoMock();
		Placar placar = new Placar(mock);

		String retorno = placar.registrarPontuacao("guerra", "estrela", 10);
		assertEquals("O usuário guerra recebeu 10 pontos do tipo estrela", retorno);
	}

	@Test
	public void registrarUmTipoDePontoParaDoisUsuarios() {
		ArmazenamentoMock mock = new ArmazenamentoMock();
		Placar placar = new Placar(mock);

		String retorno = placar.registrarPontuacao("guerra", "estrela", 10);
		assertEquals("O usuário guerra recebeu 10 pontos do tipo estrela", retorno);

		String retorno2 = placar.registrarPontuacao("clovis", "estrela", 20);
		assertEquals("O usuário clovis recebeu 20 pontos do tipo estrela", retorno2);
	}

}
