package br.com.coursera.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;

	private String email;
	private String nome;
	private String senha;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Livro> livros;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Trofel> trofeus;

	private int pontos;

	public Long getId() {
		return id;
	}

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

	public List<Trofel> getTrofeus() {
		return trofeus;
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

		long count = livros.stream().filter(l -> l.getEstilo().equals(livro.getEstilo())).count();

		if (count == 5) {
			Trofel trofel = new Trofel(livro.getEstilo());

			if (trofeus.stream().noneMatch(t -> t.equals(trofel)))
				adicionaTrofel(new Trofel(livro.getEstilo()));
		}
	}

	private void adicionaTrofel(Trofel trofel) {
		this.trofeus.add(trofel);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
