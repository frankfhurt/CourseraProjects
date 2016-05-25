package br.com.jogo.controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BancoDePalavras {

	private List<String> palavrasDoJogo;

	public BancoDePalavras() throws IOException {
		super();
		populaListaPalavrasDoJogo();
	}
	
	/**
	 * método para popular a lista de palavras que será utilizada no jogo
	 * 
	 * @throws IOException
	 */
	private void populaListaPalavrasDoJogo() throws IOException {

		palavrasDoJogo = new ArrayList<>();
		String aux = "";

		// pega o arquivo da pasta resources
		InputStream input = getClass().getResourceAsStream("/resources/palavras");
		// cria um reader para ler o arquivo
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));

		// lê o arquivo linha a linha e adiciona o conteudo na lista palavrasDoJogo
		while ((aux = reader.readLine()) != null) {
			palavrasDoJogo.add(aux);
		}
	}

	public String getPalavraAleatoria() {
		
		Random random = new Random();
		int indice = random.nextInt(palavrasDoJogo.size());
		
		Collections.shuffle(palavrasDoJogo);
		
		return palavrasDoJogo.get(indice);
	}

}
