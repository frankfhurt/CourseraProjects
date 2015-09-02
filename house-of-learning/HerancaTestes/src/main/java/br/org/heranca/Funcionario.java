package br.org.heranca;

public class Funcionario {

	protected String nome;
	protected String cpf;
	protected Double salario;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public double getBonificacao(){
		return this.salario * 0.10;
	}
}
