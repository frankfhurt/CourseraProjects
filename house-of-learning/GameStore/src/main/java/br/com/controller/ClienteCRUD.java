package br.com.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.model.Cliente;

public class ClienteCRUD {

	private List<Cliente> clientes = new ArrayList<Cliente>();

	public boolean insereCliente(int matricula, Date dataCadastro, boolean vip,
			String nome, String CPF, String telefone, String sexo,
			Date dataNascimento, String endereço) {

		try {

			clientes.add(new Cliente(matricula, dataCadastro, vip, nome, CPF,
					telefone, sexo, dataNascimento, endereço));

		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public String exibirCliente() {

		return clientes.get(0).getNome();
		
	}

}
