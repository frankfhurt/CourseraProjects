package br.com.jogo.testes;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import br.com.jogo.controlador.BancoDePalavras;

public class TesteBancoDePalavras {

	@Test
	public void pegarPalavras() {
		BancoDePalavras banco = null;

		try {
			banco = new BancoDePalavras();
		} catch (IOException e) {
			fail("Não conseguiu ler o arquivo");
		}
		
		assertNotNull(banco.getPalavraAleatoria());
	}

}
