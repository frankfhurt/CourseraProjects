package br.com.tarefa.model;

public class TopicoUsuario {

	private Topico topico;
	private Usuario usuario;

	public TopicoUsuario(Topico topico, Usuario usuario) {
		super();
		this.topico = topico;
		this.usuario = usuario;
	}

	public Topico getTopico() {
		return topico;
	}

	public void setTopico(Topico topico) {
		this.topico = topico;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
