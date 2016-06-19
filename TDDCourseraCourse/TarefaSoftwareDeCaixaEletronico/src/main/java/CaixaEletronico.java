
public class CaixaEletronico {

	private ServicoRemoto servicoRemoto;
	private Hardware hardware;
	private ContaCorrente contaCorrente;
	
	public CaixaEletronico(ServicoRemoto servicoRemoto, Hardware hardware) {
		super();
		this.servicoRemoto = servicoRemoto;
		this.hardware = hardware;
	}

	public String logar(String nroConta) throws Exception {

		hardware.pegarNumeroDaContaCartao(nroConta);
		contaCorrente = servicoRemoto.recuperarConta(nroConta);
		
		if (contaCorrente == null) {
			return "Não foi possível autenticar o usuário";
		}
		else {
			return "Usuário Autenticado";
		}
	}
	
	public String sacar(Integer valorSaque) throws Exception {
		if (contaCorrente == null)
			throw new UsuarioNaoLogadoException("Usuário não logado!");
		else {
			if (valorSaque <= contaCorrente.getSaldo()){
				hardware.entregarDinheiro();
				contaCorrente.setSaldo(contaCorrente.getSaldo() - valorSaque);
				servicoRemoto.persistirConta(contaCorrente);
				return "Retire seu dinheiro";
			} else {
				return "Saldo insuficiente";
			}
		}
	}
	
	public String depositar(Integer valorDeposito) throws Exception {
		if (contaCorrente == null) {
			throw new UsuarioNaoLogadoException("Usuário não logado!");
		} else {
			if (valorDeposito < 1)
				throw new DepositoComValorNegativoException("Não é permitido valor negativo para depósito");
			
			hardware.lerEnvelope();
			contaCorrente.setSaldo(contaCorrente.getSaldo() + valorDeposito);
			servicoRemoto.persistirConta(contaCorrente);
			return "Depósito recebido com sucesso";
		}
	}
	
	public String saldo() throws UsuarioNaoLogadoException {
		if (contaCorrente == null) {
			throw new UsuarioNaoLogadoException("Usuário não logado!");
		} else {
			return "O saldo é R$" + contaCorrente.getSaldo() + ",00";
		}
	}
	
}
