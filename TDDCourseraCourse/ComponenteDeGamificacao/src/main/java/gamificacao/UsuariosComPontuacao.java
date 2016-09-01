package gamificacao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UsuariosComPontuacao {

	private List<UsuarioComPontuacao> usuariosComPontuacao;

	public UsuariosComPontuacao() {
		super();
		this.usuariosComPontuacao = new ArrayList<>();
	}
	
	public void adicionaUsuarioComPontuacao(UsuarioComPontuacao usuario) {
		usuariosComPontuacao.add(usuario);
	}
	
	public List<UsuarioComPontuacao> getUsuariosComPontuacao() {
		return new ArrayList<>(usuariosComPontuacao);
	}
	
	public int getPontuacaoPorNomeUsuarioETipoPontuacao(String nomeUsuario, String tipoPontuacao) {
		
		int pontuacao = 0;
		
		for (UsuarioComPontuacao usuarioComPontuacao : usuariosComPontuacao) {
			if (nomeUsuario.equals(usuarioComPontuacao.getNomeUsuario()) && tipoPontuacao.equals(usuarioComPontuacao.getTipoPontuacao()))
				pontuacao = usuarioComPontuacao.getPontuacao();
		}
		
		return pontuacao;
	}
	
	public List<UsuarioComPontuacao> getListaOrdenadaDeUsuariosComPontuacao() {
		List<UsuarioComPontuacao> usuarios = new ArrayList<>(this.usuariosComPontuacao);
		Comparator<UsuarioComPontuacao> comparator = (u1, u2) -> u1.getPontuacao() - u2.getPontuacao();
		usuarios.sort(comparator.reversed());
		
		return usuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuariosComPontuacao == null) ? 0 : usuariosComPontuacao.hashCode());
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
		UsuariosComPontuacao other = (UsuariosComPontuacao) obj;
		if (usuariosComPontuacao == null) {
			if (other.usuariosComPontuacao != null)
				return false;
		} else if (!usuariosComPontuacao.equals(other.usuariosComPontuacao))
			return false;
		return true;
	}

}
