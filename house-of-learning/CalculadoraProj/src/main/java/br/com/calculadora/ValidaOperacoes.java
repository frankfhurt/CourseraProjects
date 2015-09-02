package br.com.calculadora;

import javax.swing.JOptionPane;

public class ValidaOperacoes {

	Operacoes operacao = new Operacoes();
	String resultado;

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public void somar(String valor1, String valor2) {
		try {
			if (valor1.contains(".") || valor2.contains(".")) {
				setResultado(Double
						.toString(operacao.soma(Double.parseDouble(valor1),
								Double.parseDouble(valor2))));
			} else {
				setResultado(Integer.toString(operacao.soma(
						Integer.parseInt(valor1), Integer.parseInt(valor2))));
			}
		} catch (NumberFormatException e) {
			JOptionPane
					.showMessageDialog(null, "Números ou operador inválido!");
		}
	}

	public void subtrair(String valor1, String valor2) {
		try {
			if (valor1.contains(".") || valor2.contains(".")) {
				setResultado(Double
						.toString(operacao.subtracao(
								Double.parseDouble(valor1),
								Double.parseDouble(valor2))));
			} else {
				setResultado(Integer.toString(operacao.subtracao(
						Integer.parseInt(valor1), Integer.parseInt(valor2))));
			}
		} catch (NumberFormatException e) {
			JOptionPane
					.showMessageDialog(null, "Números ou operador inválido!");
		}
	}

	public void multiplicar(String valor1, String valor2) {
		try {
			if (valor1.contains(".") || valor2.contains(".")) {
				setResultado(Double
						.toString(operacao.multiplicacao(
								Double.parseDouble(valor1),
								Double.parseDouble(valor2))));
			} else {
				setResultado(Integer.toString(operacao.multiplicacao(
						Integer.parseInt(valor1), Integer.parseInt(valor2))));
			}
		} catch (NumberFormatException e) {
			JOptionPane
					.showMessageDialog(null, "Números ou operador inválido!");
		}
	}

	public void dividir(String valor1, String valor2) {
		try {
			if (valor1.contains(".") || valor2.contains(".")) {
				setResultado(Double
						.toString(operacao.divisao(Double.parseDouble(valor1),
								Double.parseDouble(valor2))));
			} else {
				setResultado(Integer.toString(operacao.divisao(
						Integer.parseInt(valor1), Integer.parseInt(valor2))));
			}
		} catch (NumberFormatException e) {
			JOptionPane
					.showMessageDialog(null, "Números ou operador inválido!");
		}
	}

}
