package br.com.calculadora;

public class Operacoes implements Calculadora {
	
	@Override
	public int soma(int valor1, int valor2) {
		
		return valor1 + valor2;
	}

	@Override
	public int subtracao(int valor1, int valor2) {
		
		return valor1 - valor2;
	}

	@Override
	public int multiplicacao(int valor1, int valor2) {
		
		return valor1 * valor2;
	}

	@Override
	public int divisao(int valor1, int valor2) {
		
		return valor1 / valor2;
	}

	@Override
	public double soma(double valor1, double valor2) {
		
		return valor1 + valor2;
	}

	@Override
	public double subtracao(double valor1, double valor2) {
		
		return valor1 - valor2;
	}

	@Override
	public double multiplicacao(double valor1, double valor2) {
		
		return valor1 * valor2;
	}

	@Override
	public double divisao(double valor1, double valor2) {
		
		return valor1 / valor2;
	}
	
	

}
