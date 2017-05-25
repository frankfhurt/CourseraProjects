package org.mocktestes.model;

public class Funcionario {

	private String name;
	private String matricula;
	private int setor;

	public Funcionario() {}
	
	public Funcionario(String name, String matricula, int setor) {
		super();
		this.name = name;
		this.matricula = matricula;
		this.setor = setor;
	}

	public String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getSetor() {
		return setor;
	}

	public void setSetor(int setor) {
		this.setor = setor;
	}

}
