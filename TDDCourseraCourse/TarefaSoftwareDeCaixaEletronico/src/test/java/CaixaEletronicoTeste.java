import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CaixaEletronicoTeste {

	private ServicoRemoto servico;
	private Hardware hardware;
	CaixaEletronico caixa;
	
	@Before
	public void criaMocks() throws Exception {
		servico = new MockServicoRemoto();
		hardware = new MockHardware();
		caixa = new CaixaEletronico(servico, hardware);
	}

	@Test(expected = CartaoInvalidoException.class)
	public void efetuarLoginComCartaoInvalido() throws Exception {
		caixa.logar("x");
	}

	@Test(expected = CartaoBloqueadoException.class)
	public void efetuarLoginComCartaoBloqueado() throws Exception {
		caixa.logar("");
	}

	@Test(expected = ErroNaLeituraDoCartaoException.class)
	public void efetuarLoginComErroNaLeituraDoCartao() throws Exception {
		caixa.logar("0");
	}
	
	@Test
	public void efetuarLoginComSucessoDeAutenticacao() throws Exception {
		assertEquals("Usuário Autenticado", caixa.logar("1"));
	}

	@Test
	public void efetuarLoginComFalhaDeAutenticacao() throws Exception {
		assertEquals("Não foi possível autenticar o usuário", caixa.logar("5"));
	}

	@Test
	public void logarEEfetuarSaqueNaConta1ComSucesso() throws Exception {
		assertEquals("Usuário Autenticado", caixa.logar("1"));
		assertEquals("Retire seu dinheiro", caixa.sacar(50));
	}

	@Test
	public void logarEEfetuarSaqueNaConta2ComFalhaDeSaldo() throws Exception {
		assertEquals("Usuário Autenticado", caixa.logar("2"));
		assertEquals("Saldo insuficiente", caixa.sacar(100));
	}
	
	@Test
	public void logarSacarEVerificarSaldoNaConta1() throws Exception {
		assertEquals("Usuário Autenticado", caixa.logar("1"));
		assertEquals("Retire seu dinheiro", caixa.sacar(50));
		assertEquals("O saldo é R$950,00", caixa.saldo());
	}

	@Test
	public void logarSacarEVerificarSaldoNaConta2() throws Exception {
		assertEquals("Usuário Autenticado", caixa.logar("2"));
		assertEquals("Retire seu dinheiro", caixa.sacar(50));
		assertEquals("O saldo é R$0,00", caixa.saldo());
	}

	@Test (expected = EntregarDinheiroException.class)
	public void erroDeHardwareNaEntregaDoDinheiro() throws Exception {
		MockHardware hardwareComPau = new MockHardware();
		hardwareComPau.queroQueDePauNoSaque();
		CaixaEletronico caixaComPau = new CaixaEletronico(servico, hardwareComPau);
		assertEquals("Usuário Autenticado", caixaComPau.logar("1"));
		caixaComPau.sacar(50);
	}

	@Test (expected = UsuarioNaoLogadoException.class)
	public void depositarSemUsuarioLogado() throws Exception {
		caixa.depositar(100);
	}

	@Test (expected = UsuarioNaoLogadoException.class)
	public void sacarSemUsuarioLogado() throws Exception {
		caixa.sacar(100);
	}

	@Test (expected = UsuarioNaoLogadoException.class)
	public void saldoSemUsuarioLogado() throws UsuarioNaoLogadoException {
		caixa.saldo();
	}

	@Test
	public void depositarValorNaContaCorrente() throws Exception {
		assertEquals("Usuário Autenticado", caixa.logar("1"));
		assertEquals("Depósito recebido com sucesso", caixa.depositar(100));
	}

	@Test
	public void depositarValorNaContaCorrenteEVerificarSaldo() throws Exception {
		assertEquals("Usuário Autenticado", caixa.logar("1"));
		assertEquals("Depósito recebido com sucesso", caixa.depositar(100));
		assertEquals("O saldo é R$1100,00", caixa.saldo());
	}

	@Test (expected = DepositoComValorNegativoException.class)
	public void depositarValorNegativo() throws Exception {
		assertEquals("Usuário Autenticado", caixa.logar("1"));
		assertEquals("Depósito recebido com sucesso", caixa.depositar(-100));
	}

	@Test (expected = ProblemaNaLeituraDoEnvelopeException.class)
	public void problemaNaHoraDeLerEnvelope() throws Exception {
		MockHardware hardwareComPau = new MockHardware();
		hardwareComPau.queroQueDePauNaLeituraDoEnvelope();
		CaixaEletronico caixaComPau = new CaixaEletronico(servico, hardwareComPau);
		assertEquals("Usuário Autenticado", caixaComPau.logar("1"));
		caixaComPau.depositar(100);
	}

	@Test
	public void verificaSeContaFoiPersistidaComSucessoAposSaque() throws Exception {
		assertEquals("Usuário Autenticado", caixa.logar("1"));
		assertEquals("Retire seu dinheiro", caixa.sacar(50));
		assertEquals("O saldo é R$950,00", caixa.saldo());
		
		assertEquals("Usuário Autenticado", caixa.logar("1"));
		assertEquals("O saldo é R$950,00", caixa.saldo());
	}

	@Test
	public void verificaSeContaFoiPersistidaComSucessoAposDeposito() throws Exception {
		assertEquals("Usuário Autenticado", caixa.logar("1"));
		assertEquals("Depósito recebido com sucesso", caixa.depositar(50));
		assertEquals("O saldo é R$1050,00", caixa.saldo());
		
		assertEquals("Usuário Autenticado", caixa.logar("1"));
		assertEquals("O saldo é R$1050,00", caixa.saldo());
	}
	
}