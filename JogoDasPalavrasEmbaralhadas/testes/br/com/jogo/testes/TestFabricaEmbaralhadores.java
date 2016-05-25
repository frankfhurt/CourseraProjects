package br.com.jogo.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.jogo.controlador.Embaralhador;
import br.com.jogo.controlador.FabricaEmbaralhadores;

public class TestFabricaEmbaralhadores {

	@Test
	public void getEmbaralhadorTeste() {

		FabricaEmbaralhadores fabrica = new FabricaEmbaralhadores();

		assertTrue(fabrica.getEmbaralhador() instanceof Embaralhador);
		
	}

}
