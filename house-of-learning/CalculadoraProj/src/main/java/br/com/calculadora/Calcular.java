package br.com.calculadora;

import javax.swing.JOptionPane;

public class Calcular {

	public static void main(String[] args) {

		String valor1;
		String valor2;
		String operador;

		ValidaOperacoes operacao = new ValidaOperacoes();

		valor1 = JOptionPane.showInputDialog("Insira o 1o número:");
		operador = JOptionPane.showInputDialog("Insira o operador:");
		valor2 = JOptionPane.showInputDialog("Insira o 2o número:");

		if (valor1.contains(",")) {
			valor1 = valor1.replace(",", ".");
		}

		if (valor2.contains(",")) {
			valor2 = valor2.replace(",", ".");
		}

		System.out.println("valor 1: " + valor1 + "\nvalor 2: " + valor2
				+ "\noperador: " + operador);

		switch (operador) {
		case "+":
			operacao.somar(valor1, valor2);
			JOptionPane.showMessageDialog(null, valor1 + " + " + valor2 + " = "
					+ operacao.getResultado());
			break;
		case "-":
			operacao.subtrair(valor1, valor2);
			JOptionPane.showMessageDialog(null, valor1 + " + " + valor2 + " = "
					+ operacao.getResultado());
			break;
		case "*":
			operacao.multiplicar(valor1, valor2);
			JOptionPane.showMessageDialog(null, valor1 + " + " + valor2 + " = "
					+ operacao.getResultado());
			break;
		case "/":
			operacao.dividir(valor1, valor2);
			JOptionPane.showMessageDialog(null, valor1 + " + " + valor2 + " = "
					+ operacao.getResultado());
			break;
		default:
			JOptionPane
					.showMessageDialog(null, "Números ou operador inválido!");
			break;
		}

	}
}
