import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CaixaEletronicoTeste {

	private ServicoRemoto servico;
	private Hardware hardware;
	
	@Before
	public void criaMocks() throws Exception {
		servico = new MockServicoRemoto();
		hardware = new MockHardware();
	}

	@Test(expected = CartaoInvalidoException.class)
	public void efetuarLoginComCartaoInvalido() throws Exception {
		CaixaEletronico caixa = new CaixaEletronico(servico, hardware);
		caixa.logar("x");
	}

	@Test(expected = CartaoBloqueadoException.class)
	public void efetuarLoginComCartaoBloqueado() throws Exception {
		CaixaEletronico caixa = new CaixaEletronico(servico, hardware);
		caixa.logar("");
	}

	@Test(expected = ErroNaLeituraDoCartaoException.class)
	public void efetuarLoginComErroNaLeituraDoCartao() throws Exception {
		CaixaEletronico caixa = new CaixaEletronico(servico, hardware);
		caixa.logar("0");
	}
	
	@Test
	public void efetuarLoginComSucessoDeAutenticacao() throws Exception {
		CaixaEletronico caixa = new CaixaEletronico(servico, hardware);
		
		assertEquals("Usuário Autenticado", caixa.logar("1"));
	}

	@Test
	public void efetuarLoginComFalhaDeAutenticacao() throws Exception {
		CaixaEletronico caixa = new CaixaEletronico(servico, hardware);
		
		assertEquals("Não foi possível autenticar o usuário", caixa.logar("5"));
	}

}
