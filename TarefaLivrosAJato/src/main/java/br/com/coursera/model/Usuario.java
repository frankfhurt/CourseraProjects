package br.com.coursera.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	private String email;

	private String nome;
	private String senha;

	@OneToMany
	private List<Livro> livros;

	private int pontos;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getPontos() {
		return pontos;
	}

	private void adicionarPontuacao(int pontos) {
		this.pontos += pontos;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void adicionarLivro(Livro livro) {
		this.livros.add(livro);
		adicionarPontuacao(1);
		if (livro.getQtdPaginas() >= 350)
			adicionarPontuacao(4);
		else if (livro.getQtdPaginas() >= 124)
			adicionarPontuacao(2);
		else if (livro.getQtdPaginas() >= 72)
			adicionarPontuacao(1);
	}
}
