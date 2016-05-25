package br.com.jogo.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CincoPalavras implements MecanicaDoJogo {

	private BancoDePalavras bancoPalavras;
	private List<String> palavras = new ArrayList<>();
	private int indicePalavra;
	private int pontuacao;
	private boolean fimDoJogo;
	private String respostaJogador;
	private String palavraEmbaralhada;
	private Embaralhador embaralhador;

	// Lançada exceção no construtor, pois as instruções dizem que só a classe Principal pode escrever no console.
	public CincoPalavras() throws IOException {
		super();
		bancoPalavras = new BancoDePalavras();
		indicePalavra = 0;
		fimDoJogo = false;
		populaPalavras();

	}

	@Override
	public String tituloMecanicaDoJogo() {
		return "Adivinhe 5 palavras";
	}

	@Override
	public int getPontuacao() {
		return pontuacao;
	}

	@Override
	public boolean isFimDeJogo() {
		if (getIndicePalavraInformada() == 5) {
			fimDoJogo = true;
		}
		return fimDoJogo;
	}
	
	@Override
	public String validaRespostaJogador() {
		if (getRepostaJogador().toLowerCase().equals(palavras.get(indicePalavra - 1).toLowerCase())) {
			adicionaPontuacao();
			return "Você acertou!\nSua Pontuação atual é " + getPontuacao();
		} else {
			return "Você errou!";
		}
	}

	private void populaPalavras() {
		for (int i = 0; i < 5; i++) {
			palavras.add(bancoPalavras.getPalavraAleatoria());
		}
	}

	@Override
	public String getPalavraEmbaralhada() {

		embaralhador = getEmbaralhadorAleatorio();
		palavraEmbaralhada = embaralhador.embaralhar(palavras.get(indicePalavra));
		indicePalavra++;

		return palavraEmbaralhada;
	}

	@Override
	public void setRepostaJogador(String resposta) {
		this.respostaJogador = resposta;
	}

	private String getRepostaJogador() {
		return respostaJogador;
	}

	private int getIndicePalavraInformada() {
		return indicePalavra;
	}

	private void adicionaPontuacao() {
		pontuacao += embaralhador.getDificuldade();
	}

	private Embaralhador getEmbaralhadorAleatorio() {
		return new FabricaEmbaralhadores().getEmbaralhador();
	}

}
