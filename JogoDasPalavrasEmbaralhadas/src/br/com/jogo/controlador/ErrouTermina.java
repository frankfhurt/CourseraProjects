package br.com.jogo.controlador;

import java.io.IOException;

public class ErrouTermina implements MecanicaDoJogo {

	private BancoDePalavras bancoPalavras;
	private int pontuacao;
	private boolean fimDoJogo;
	private String respostaJogador;
	private String palavra;
	private Embaralhador embaralhador;

	// Lançada exceção no construtor, pois as instruções dizem que só a classe Principal pode escrever no console.
	public ErrouTermina() throws IOException {
		super();
		bancoPalavras = new BancoDePalavras();
	}

	@Override
	public String tituloMecanicaDoJogo() {
		return "Se você errar, o jogo termina";
	}

	@Override
	public int getPontuacao() {
		return pontuacao;
	}

	@Override
	public boolean isFimDeJogo() {
		return fimDoJogo;
	}

	@Override
	public String validaRespostaJogador() {
		if (getRepostaJogador().toLowerCase().equals(getPalavra().toLowerCase())) {
			adicionaPontuacao();
			return "Você acertou!\nSua Pontuação atual é " + getPontuacao();
		} else {
			fimDoJogo = true;
			return "Você errou!";
		}
	}

	@Override
	public String getPalavraEmbaralhada() {

		embaralhador = getEmbaralhadorAleatorio();
		setPalavra(getPalavraDoBancoDePalavras());
		
		return embaralhador.embaralhar(palavra);
	}

	@Override
	public void setRepostaJogador(String resposta) {
		this.respostaJogador = resposta;
	}

	private String getPalavra() {
		return palavra;
	}

	private void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	private String getPalavraDoBancoDePalavras() {
		return bancoPalavras.getPalavraAleatoria();
	}

	private String getRepostaJogador() {
		return respostaJogador;
	}

	private void adicionaPontuacao() {
		pontuacao += embaralhador.getDificuldade();
	}
	
	private Embaralhador getEmbaralhadorAleatorio() {
		return new FabricaEmbaralhadores().getEmbaralhador();
	}

}
