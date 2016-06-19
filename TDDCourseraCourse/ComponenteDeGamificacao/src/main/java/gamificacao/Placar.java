package gamificacao;

public class Placar {

	private Armazenamento armazenamento;

	public Placar(Armazenamento armazenamento) {
		super();
		this.armazenamento = armazenamento;
	}

	public String registrarPontuacao(String nomeUsuario, String tipoPontuacao, int pontuacao) {
		return armazenamento.registraPontuacao(nomeUsuario, tipoPontuacao, pontuacao);
	}

}
