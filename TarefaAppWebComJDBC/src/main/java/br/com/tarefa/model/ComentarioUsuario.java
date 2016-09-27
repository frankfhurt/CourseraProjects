package br.com.tarefa.model;

public class ComentarioUsuario {

	private Usuario usuario;
	private Comentario comentario;

	public ComentarioUsuario(Usuario usuario, Comentario comentario) {
		super();
		this.usuario = usuario;
		this.comentario = comentario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "ComentarioUsuario [usuario=" + usuario.getNome() + ", comentario=" + comentario.getComentario() + "]";
	}
	
	

}
