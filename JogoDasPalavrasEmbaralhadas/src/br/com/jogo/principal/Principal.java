package br.com.jogo.principal;

import java.io.IOException;
import java.util.Scanner;

import br.com.jogo.controlador.FabricaMecanicaDoJogo;
import br.com.jogo.controlador.MecanicaDoJogo;

public class Principal {
	
	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in);
		String resposta = "";
		
		MecanicaDoJogo jogo = new FabricaMecanicaDoJogo().getMecanicaDoJogo();
		
		System.out.println("Jogo das Palavras Embaralhadas");
		System.out.println("-------------------------------------------------");
		System.out.println(jogo.tituloMecanicaDoJogo());
		
		do {

			System.out.println();
			System.out.println("Desembaralhe a palavra: " + jogo.getPalavraEmbaralhada());
			System.out.println("Digite sua resposta");
			resposta = input.nextLine();
			jogo.setRepostaJogador(resposta);
			
			System.out.println(jogo.validaRespostaJogador());

		} while (!jogo.isFimDeJogo());
		
		System.out.println();
		System.out.println("#################################################");
		System.out.println("Fim de jogo!");
		System.out.println("Pontuação final: " + jogo.getPontuacao());
		System.out.println("#################################################");
		input.close();
		
	}

}
