package org.mocktestes.dao;

import org.mocktestes.model.Funcionario;

public class FuncionarDAO {

	private final Transacao transacao;
	
	public FuncionarDAO(Transacao transacao) {
		this.transacao = transacao;
	}

	public Funcionario buscar(String matricula) {
		return transacao.executar(matricula);
	}

}
