public class Teste {

	public static void main(String[] args) {

		ControleDeBonificacoes ctrlBonificacao = new ControleDeBonificacoes();
		Gerente gerente = new Gerente("NomeGerente", "03029302900", 5000);
		ctrlBonificacao.registra(gerente);
		gerente.setSalario(gerente.getBonificacao());

		System.out.println(gerente.print());
		System.out.println(ctrlBonificacao.getTotalDeBonificacoes());
	}

}
