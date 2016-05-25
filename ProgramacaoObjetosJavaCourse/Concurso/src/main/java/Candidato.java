
public class Candidato implements Comparable<Candidato> {

	private int nota;
	private boolean deficiente;
	private int idade;

	public Candidato(int nota, boolean deficiente, int idade) {
		super();
		this.nota = nota;
		this.deficiente = deficiente;
		this.idade = idade;
	}

	public int getNota() {
		return nota;
	}

	public boolean isDeficiente() {
		return deficiente;
	}

	public int getIdade() {
		return idade;
	}

	@Override
	public int compareTo(Candidato outro) {
		if (nota == outro.nota) {
			if (deficiente == outro.isDeficiente()) {
				return idade - outro.idade;
			} else {
				if (deficiente) {
					return 1;
				} else {
					return -1;
				}
			}
		} else {
			return nota - outro.getNota();
		}
	}

	@Override
	public String toString() {
		return "Candidato [nota=" + nota + ", deficiente=" + deficiente + ", idade=" + idade + "]";
	}

}
