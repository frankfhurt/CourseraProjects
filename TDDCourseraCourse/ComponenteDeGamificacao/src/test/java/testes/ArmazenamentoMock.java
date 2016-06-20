package testes;

import java.io.IOException;

import gamificacao.Armazenamento;
import gamificacao.UsuarioComPontuacao;
import gamificacao.UsuariosComPontuacao;

public class ArmazenamentoMock extends Armazenamento {

	private UsuariosComPontuacao usuarios = new UsuariosComPontuacao();
	
	public ArmazenamentoMock(String nomeArquivo) {
		super(nomeArquivo);
	}

	@Override
	public String registraPontuacao(String nomeUsuario, String tipoPontuacao, int pontuacao) {
		usuarios.adicionaUsuarioComPontuacao(new UsuarioComPontuacao(nomeUsuario, tipoPontuacao, pontuacao));
		return "O usuário " + nomeUsuario + " recebeu " + pontuacao + " pontos do tipo " + tipoPontuacao;
	}

	@Override
	public UsuariosComPontuacao getUsuariosComPontuacao() {
		return usuarios;
	}

	@Override
	protected void escreverNoArquivo(UsuarioComPontuacao usuario) {
	}

	@Override
	protected void lerArquivo() throws IOException {
	}

}
