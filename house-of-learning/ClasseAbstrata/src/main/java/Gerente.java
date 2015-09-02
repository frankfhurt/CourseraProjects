
public class Gerente extends Funcionario {

	public Gerente(){
		
	}
	
	public Gerente(String nome, String cpf, double salario) {
		super(nome, cpf, salario);
	}
	
	@Override
	public double getBonificacao(){
		return this.getSalario() * 1.4 + 1000;
	}
	
	public String print(){
		return "\nNome: " + this.getNome()
				+ "\nCPF: " + this.getCpf()
				+ "\nSalario: " + this.getSalario();
	}
}
