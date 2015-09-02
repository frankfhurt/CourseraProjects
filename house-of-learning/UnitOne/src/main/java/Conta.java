public class Conta {

	private double saldo;

	public Conta(double saldoInicial) {
		if (saldoInicial > saldo)
			saldo = saldoInicial;
	}

	public void deposito(double quantia) {
		saldo = saldo + quantia;
	}

	public double getSaldo() {
		return saldo;
	}
}
