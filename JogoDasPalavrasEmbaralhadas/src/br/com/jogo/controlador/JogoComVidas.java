package br.com.jogo.controlador;

import java.io.IOException;

public class JogoComVidas implements MecanicaDoJogo {

	private BancoDePalavras bancoPalavras;
	private int pontuacao;
	private boolean fimDoJogo;
	private String respostaJogador;
	private String palavra;
	private Embaralhador embaralhador;
	private int vidas;

	// Lançada exceção no construtor, pois as instruções dizem que só a classe Principal pode escrever no console.
	public JogoComVidas() throws IOException {
		super();
		setVidas(3);
		bancoPalavras = new BancoDePalavras();
		fimDoJogo = false;
	}

	@Override
	public String tituloMecanicaDoJogo() {
		return "Você tem " + getVidas() + " vidas. Se perde-las, o jogo termina!";
	}

	@Override
	public int getPontuacao() {
		return pontuacao;
	}

	@Override
	public boolean isFimDeJogo() {
		if (getVidas() == 0){
			fimDoJogo = true;
		}
		return fimDoJogo;
	}

	@Override
	public String validaRespostaJogador() {
		if (getRepostaJogador().toLowerCase().equals(getPalavra().toLowerCase())) {
			adicionaPontuacao();
			return "Você acertou!\nSua Pontuação atual é " + getPontuacao();
		} else {
			descontaVida();
			return "Você errou!\nRestam " + getVidas() + " vidas";
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

	private int getVidas() {
		return vidas;
	}

	private void setVidas(int vidas) {
		this.vidas = vidas;
	}

	private void descontaVida(){
		setVidas(getVidas() -1);
	}

}
