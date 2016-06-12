
public class ContaCorrente {

	private String nroConta;
	private int saldo;

	public ContaCorrente(String nroConta, int saldo) {
		super();
		this.nroConta = nroConta;
		this.saldo = saldo;
	}

	public String getNroConta() {
		return nroConta;
	}

	public void setNroConta(String nroConta) {
		this.nroConta = nroConta;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

}
