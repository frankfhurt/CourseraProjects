public class Presidente extends Funcionario {

	public Presidente() {

	}

	public Presidente(String nome, String cpf, double salario) {
		super(nome, cpf, salario);
	}

	@Override
	double getBonificacao() {
		return this.getSalario() * 1.4 + 1000;
	}

}
