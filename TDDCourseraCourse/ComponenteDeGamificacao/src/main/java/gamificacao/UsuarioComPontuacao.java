package gamificacao;

public class UsuarioComPontuacao {

	private String nomeUsuario;
	private String tipoPontuacao;
	private int pontuacao;

	public UsuarioComPontuacao(String nomeUsuario, String tipoPontuacao, int pontuacao) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.tipoPontuacao = tipoPontuacao;
		this.pontuacao = pontuacao;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public String getTipoPontuacao() {
		return tipoPontuacao;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}

	@Override
	public String toString() {
		return nomeUsuario + ";" + tipoPontuacao + ";" + pontuacao;
	}
	
}
