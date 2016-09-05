
public class Contador {

	private int numeroAtual = 0;
	private String nome;

	public Contador(String nome) {
		super();
		this.nome = nome;
	}

	public void contar() {
		numeroAtual++;
	}

	@Override
	public String toString() {
		return nome + " = " + numeroAtual;
	}

}
