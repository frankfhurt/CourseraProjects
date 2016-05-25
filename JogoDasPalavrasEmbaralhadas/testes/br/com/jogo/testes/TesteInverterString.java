package br.com.jogo.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.jogo.controlador.Embaralhador;
import br.com.jogo.controlador.InverterString;

public class TesteInverterString {

	private Embaralhador embaralhador;
	
	@Test
	public void inverterString() {
		
		String palavra;
		embaralhador = new InverterString();
		palavra = embaralhador.embaralhar("computador");
		
		assertEquals("rodatupmoc", palavra);
		
	}

}
