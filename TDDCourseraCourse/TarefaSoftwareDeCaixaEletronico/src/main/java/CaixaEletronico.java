
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
	
	public String sacar() {
		return null;
	}
	
	public String depositar() {
		return null;
	}
	
	public String saldo() {
		return null;
	}
	
}
