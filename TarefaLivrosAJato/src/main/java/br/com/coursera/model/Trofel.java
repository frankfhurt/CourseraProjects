package br.com.coursera.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trofel")
public class Trofel {

	@Id
	@GeneratedValue
	private Long id;

	@Enumerated(EnumType.STRING)
	private LivroEstilos livroEstilo;

	public Trofel() {
	}

	public Trofel(LivroEstilos livroEstilo) {
		super();
		this.livroEstilo = livroEstilo;
	}

	public LivroEstilos getLivroEstilo() {
		return livroEstilo;
	}

	public void setLivroEstilo(LivroEstilos livroEstilo) {
		this.livroEstilo = livroEstilo;
	}

	public Long getId() {
		return id;
	}

}