package br.com.jogo.controlador;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TrocarLetras implements Embaralhador {

	public TrocarLetras() {
		super();
	}

	@Override
	public String embaralhar(String palavra) {

		// Cria uma lista em que cada posição é uma letra
		List<String> letras = (List<String>) Arrays.asList(palavra.split(""));
		
		// Usa o Collections.shuffle para embaralhar a lista
		Collections.shuffle(letras);
		
		// Cria string e a preenche com as letras da lista embaralhada
		String embaralhado = "";
		
		for (String l : letras) {
			embaralhado += l;
		}
		
		return embaralhado;
	}

	@Override
	public int getDificuldade() {
		return 3;
	}

}
