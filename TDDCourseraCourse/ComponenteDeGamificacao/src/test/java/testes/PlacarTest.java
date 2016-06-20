package testes;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import gamificacao.Placar;
import gamificacao.UsuarioComPontuacao;

public class PlacarTest {

	private String nomeArquivo = "arquivoDeTeste.txt";
	private ArmazenamentoMock mock;
	private Placar placar;
	
	@Before
	public void setUp() throws Exception {
		mock = new ArmazenamentoMock(nomeArquivo);
		placar = new Placar(mock);
	}

	@Test
	public void registrarUmTipoDePontoParaUmUsuario() {
		String retorno = placar.registrarPontuacao("guerra", "estrela", 10);
		assertEquals("O usuário guerra recebeu 10 pontos do tipo estrela", retorno);
	}

	@Test
	public void registrarUmTipoDePontoParaDoisUsuarios() {
		String retorno = placar.registrarPontuacao("guerra", "estrela", 10);
		assertEquals("O usuário guerra recebeu 10 pontos do tipo estrela", retorno);

		String retorno2 = placar.registrarPontuacao("clovis", "estrela", 20);
		assertEquals("O usuário clovis recebeu 20 pontos do tipo estrela", retorno2);
	}
	
	@Test
	public void verificarTodosOsPontosDeUmUsuario() {
		String[] resultado = new String[3];
		int i = 0;
		
		placar.registrarPontuacao("guerra", "estrela", 10);
		placar.registrarPontuacao("guerra", "moeda", 5);
		placar.registrarPontuacao("guerra", "energia", 30);
		
		for (String result : placar.getTodosOsPontosPorUsuario("guerra")) {
			resultado[i] = result;
			i++;
		}
		
		assertEquals("estrela - 10", resultado[0]);
		assertEquals("moeda - 5", resultado[1]);
		assertEquals("energia - 30", resultado[2]);
	}
	
	@Test
	public void verificaRankingPorTipoDePonto() {
		List<UsuarioComPontuacao> listaOrdenada = new ArrayList<>();
		
		listaOrdenada.add(new UsuarioComPontuacao("clovis", "estrela", 30));
		listaOrdenada.add(new UsuarioComPontuacao("joao", "estrela", 15));
		listaOrdenada.add(new UsuarioComPontuacao("guerra", "estrela", 10));
		listaOrdenada.add(new UsuarioComPontuacao("virgulino", "estrela", 5));
		
		placar.registrarPontuacao("guerra", "estrela", 10);
		placar.registrarPontuacao("virgulino", "estrela", 5);
		placar.registrarPontuacao("clovis", "estrela", 30);
		placar.registrarPontuacao("joao", "estrela", 15);
		
		List<UsuarioComPontuacao> rankingUsuarios = placar.getRankingUsuarios("estrela");
		
		assertEquals(listaOrdenada, rankingUsuarios);
	}

}
