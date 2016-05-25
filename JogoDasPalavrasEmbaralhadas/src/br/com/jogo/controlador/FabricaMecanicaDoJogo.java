package br.com.jogo.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FabricaMecanicaDoJogo {

	private List<MecanicaDoJogo> mecanicas;

	// Lançada exceção no construtor, pois as instruções dizem que só a classe Principal pode escrever no console.
	public FabricaMecanicaDoJogo() throws IOException {
		super();
		mecanicas = new ArrayList<>();
		mecanicas.add(new CincoPalavras());
		mecanicas.add(new ErrouTermina());
		mecanicas.add(new JogoComVidas());
	}
	
	public MecanicaDoJogo getMecanicaDoJogo(){
		
		Random random = new Random();
		
		return mecanicas.get(random.nextInt(3));
		
	}
	
}
