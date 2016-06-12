import java.util.HashMap;

public class MockServicoRemoto implements ServicoRemoto {

	private HashMap<String, Integer> contasCorrente = new HashMap<>();
	
	public MockServicoRemoto() {
		super();
		populaContasCorrente();
	}

	private void populaContasCorrente() {
		contasCorrente.put("1", 1000);
		contasCorrente.put("2", 50);
	}

	@Override
	public ContaCorrente recuperarConta(String nroConta) {
		if (contasCorrente.containsKey(nroConta))
			return new ContaCorrente(nroConta, contasCorrente.get(nroConta));
		
		return null;
	}

	@Override
	public void persistirConta(ContaCorrente conta) {

		if (contasCorrente.containsKey(conta.getNroConta()))
			contasCorrente.replace(conta.getNroConta(), conta.getSaldo());
	}

}
