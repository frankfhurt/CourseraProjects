
public class Fruta {

	protected String nome;

	public Fruta(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Fruta [nome=" + nome + "]";
	}

}
