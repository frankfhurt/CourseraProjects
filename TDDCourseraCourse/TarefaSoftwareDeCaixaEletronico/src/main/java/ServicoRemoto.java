
public interface ServicoRemoto {

	public ContaCorrente recuperarConta(String nroConta);
	public void persistirConta(ContaCorrente conta);
	
}
