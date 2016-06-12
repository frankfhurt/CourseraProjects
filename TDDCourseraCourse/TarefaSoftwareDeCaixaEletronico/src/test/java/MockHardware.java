
public class MockHardware implements Hardware {

	@Override
	public String pegarNumeroDaContaCartao(String nroConta) throws Exception {
		
		if (nroConta.equals("0"))
			throw new ErroNaLeituraDoCartaoException("Erro na leitura do cartão!");

		if (nroConta.equals(""))
			throw new CartaoBloqueadoException("Cartão bloqueado!");

		if (nroConta.equals("x"))
			throw new CartaoInvalidoException("Cartão inválido!");
		
		return nroConta;
	}

	@Override
	public void entregarDinheiro() throws Exception {

	}

	@Override
	public void lerEnvelope(int valor) throws Exception {

	}

}
