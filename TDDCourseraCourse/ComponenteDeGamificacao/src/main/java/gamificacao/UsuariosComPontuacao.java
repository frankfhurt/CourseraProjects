package gamificacao;

import java.util.ArrayList;
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
	
}
