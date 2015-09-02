public class ControleDeBonificacoes {

	private double totalDeBonificacoes;
	
	public ControleDeBonificacoes(){
		totalDeBonificacoes = 0;
	}

	public void registra(Funcionario f) {
		System.out.println("Adicionando bonificacao do funcionario : " + f);
		this.totalDeBonificacoes += f.getBonificacao();
	}

	public double getTotalDeBonificacoes() {
		return totalDeBonificacoes;
	}
}