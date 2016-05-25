package br.com.jogo.testes;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import br.com.jogo.controlador.Embaralhador;
import br.com.jogo.controlador.TrocarLetras;

public class TesteTrocarLetras {

	private Embaralhador embaralhador;
	
	@Test
	public void trocarLetras() {
		
		String palavra;
		embaralhador = new TrocarLetras();
		palavra = embaralhador.embaralhar("computador");
		
		assertNotEquals("computador", palavra);
		
	}
}
