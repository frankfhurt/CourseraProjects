package br.com.tarefa.model;

public class Comentario {

	private long id;
	private String comentario;
	private String login;
	private long idTopico;

	public Comentario() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public long getIdTopico() {
		return idTopico;
	}

	public void setIdTopico(long idTopico) {
		this.idTopico = idTopico;
	}

}
