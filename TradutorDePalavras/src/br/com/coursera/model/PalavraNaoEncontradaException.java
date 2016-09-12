package br.com.coursera.model;

public class PalavraNaoEncontradaException extends Exception {

	private static final long serialVersionUID = 1045763064175310433L;

	public PalavraNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

}
