package testes;

import gamificacao.Armazenamento;

public class ArmazenamentoMock extends Armazenamento {

	@Override
	public String registraPontuacao(String nomeUsuario, String tipoPontuacao, int pontuacao) {
		return "O usuário " + nomeUsuario + " recebeu " + pontuacao + " pontos do tipo " + tipoPontuacao;
	}
}
