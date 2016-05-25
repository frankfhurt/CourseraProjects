package br.com.jogo.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FabricaEmbaralhadores {

	private List<Embaralhador> embaralhadores;
	
	public FabricaEmbaralhadores() {
		super();

		embaralhadores = new ArrayList<>();
		embaralhadores.add(new InverterString());
		embaralhadores.add(new TrocarLetras());
	}

	public Embaralhador getEmbaralhador(){
		
		Random random = new Random();
		
		return embaralhadores.get(random.nextInt(2));
		
	}
	
}
