package br.com.jogo.controlador;

public interface MecanicaDoJogo {

	public String tituloMecanicaDoJogo();
	
	public int getPontuacao();
	
	public boolean isFimDeJogo();
	
	public String validaRespostaJogador();
	
	public String getPalavraEmbaralhada();
	
	public void setRepostaJogador(String resposta);
	
}
