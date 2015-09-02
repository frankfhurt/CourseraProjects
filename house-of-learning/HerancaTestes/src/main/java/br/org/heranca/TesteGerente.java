package br.org.heranca;

public class TesteGerente {

	public static void main(String[] args) {
		
		ControleBonificacoes controle = new ControleBonificacoes();
		
		Gerente gerente = new Gerente();
		gerente.setSalario(5000.00);
		controle.registra(gerente);
		
		Funcionario func = new Funcionario();
		func.setSalario(2000.00);
		controle.registra(func);
		
		System.out.println("Bonificação do Gerente: R$" + gerente.getBonificacao());
		System.out.println("Bonificação do Funcionario: R$" + func.getBonificacao());
		System.out.println("Total de bonificaçoes: R$" + controle.getTotalBonificacoes());
	}

}
