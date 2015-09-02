package br.com.model;

import java.util.Date;

public class Pessoa {

	private String nome;
	private String CPF;
	private String telefone;
	private String sexo;
	private Date dataNascimento;
	private String endereço;

	public Pessoa() {

		this.nome.isEmpty();
		this.CPF.isEmpty();
		this.telefone.isEmpty();
		this.sexo.isEmpty();
		this.dataNascimento = null;
		this.endereço.isEmpty();

	}

	public Pessoa(String nome, String CPF, String telefone, String sexo,
			Date dataNascimento, String endereço) {

		this.nome = nome;
		this.CPF = CPF;
		this.telefone = telefone;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.endereço = endereço;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

}
