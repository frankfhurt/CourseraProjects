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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeUsuario == null) ? 0 : nomeUsuario.hashCode());
		result = prime * result + pontuacao;
		result = prime * result + ((tipoPontuacao == null) ? 0 : tipoPontuacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioComPontuacao other = (UsuarioComPontuacao) obj;
		if (nomeUsuario == null) {
			if (other.nomeUsuario != null)
				return false;
		} else if (!nomeUsuario.equals(other.nomeUsuario))
			return false;
		if (pontuacao != other.pontuacao)
			return false;
		if (tipoPontuacao == null) {
			if (other.tipoPontuacao != null)
				return false;
		} else if (!tipoPontuacao.equals(other.tipoPontuacao))
			return false;
		return true;
	}

}
