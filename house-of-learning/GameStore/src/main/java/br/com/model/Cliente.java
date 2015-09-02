package br.com.model;

import java.util.Date;

public class Cliente extends Pessoa {

	private int matricula;
	private Date dataCadastro;
	private boolean vip;

	public Cliente(int matricula, Date dataCadastro, boolean vip, String nome,
			String CPF, String telefone, String sexo, Date dataNascimento,
			String endereço) {

		super(nome, CPF, telefone, sexo, dataNascimento, endereço);
		this.matricula = matricula;
		this.dataCadastro = dataCadastro;
		this.vip = vip;

	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

}
