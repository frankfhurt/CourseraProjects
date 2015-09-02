package br.com.view;

import java.util.Date;
import java.util.Scanner;

import br.com.controller.ClienteCRUD;

public class Principal {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		String nome = null;
		String CPF = null;
		String telefone = null;
		String sexo = null;
		Date dataNascimento = null;
		String endereço = null;
		int matricula = 0;
		Date dataCadastro = null;
		boolean vip = false;
		
		ClienteCRUD cliente = new ClienteCRUD();

		System.out.println("Digite o nome do cliente: ");
		nome = new Scanner(System.in).nextLine();
		
		cliente.insereCliente(matricula, dataCadastro, vip, nome, CPF, telefone, sexo, dataNascimento, endereço);
		
		System.out.println("O nome do cliente é: " + cliente.exibirCliente());

	}

}
