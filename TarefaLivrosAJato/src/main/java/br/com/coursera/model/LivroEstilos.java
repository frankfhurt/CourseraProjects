package br.com.coursera.model;

public enum LivroEstilos {

	FICCAO_CIENTIFICA("Ficção Cientifica"),
	AVENTURA("Aventura"),
	ROMANCE("Romance"),
	HISTORIA("História"),
	COMEDIA("Comédia"),
	ESPIRITA("Espirita"),
	QUADRINHOS("Quadrinhos");
	
	private String estilo;

	private LivroEstilos(String estilo) {
		this.estilo = estilo;
	}

	public String getEstilo() {
		return estilo;
	}

}
