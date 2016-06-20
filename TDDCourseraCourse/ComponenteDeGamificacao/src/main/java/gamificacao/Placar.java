package gamificacao;

import java.util.ArrayList;
import java.util.List;

public class Placar {

	private Armazenamento armazenamento;

	public Placar(Armazenamento armazenamento) {
		super();
		this.armazenamento = armazenamento;
	}

	public String registrarPontuacao(String nomeUsuario, String tipoPontuacao, int pontuacao) {
		return armazenamento.registraPontuacao(nomeUsuario, tipoPontuacao, pontuacao);
	}

	public List<String> getTodosOsPontosPorUsuario(String nomeUsuario) {
		
		List<String> pontuacoes = new ArrayList<>();
		
		UsuariosComPontuacao usuarios = armazenamento.getUsuariosComPontuacao();
		
		for (UsuarioComPontuacao usuario : usuarios.getUsuariosComPontuacao()) {
			if (nomeUsuario.equals(usuario.getNomeUsuario()))
					pontuacoes.add(usuario.getTipoPontuacao() + " - " + usuario.getPontuacao());
		}
		
		return pontuacoes;
	}

	public List<UsuarioComPontuacao> getRankingUsuarios(String string) {
		return armazenamento.getUsuariosComPontuacao().getListaOrdenadaDeUsuariosComPontuacao();
	}
	

}
