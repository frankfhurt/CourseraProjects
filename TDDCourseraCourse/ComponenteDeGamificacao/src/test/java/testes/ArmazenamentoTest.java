package testes;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gamificacao.Armazenamento;
import gamificacao.UsuarioComPontuacao;
import gamificacao.UsuariosComPontuacao;

public class ArmazenamentoTest {

	private Armazenamento armazenamento;
	private String nomeArquivo = "arquivoDeTeste.txt";
	
	@Before
	public void setUp() throws Exception {
		armazenamento = new Armazenamento(nomeArquivo);
		File f = new File("./" + nomeArquivo);
		if (f.exists()){
			f.delete();
			f.createNewFile();
		} else {
			f.createNewFile();
		}
		
	}
	
	@After
	public void finalizar() throws IOException {
		File f = new File("./" + nomeArquivo);
		f.delete();
	}

	@Test
	public void registrarPontuacaoParaUmUsuario() throws IOException {
		String retorno;
		retorno = armazenamento.registraPontuacao("guerra", "estrela", 10);
		assertEquals("O usuário guerra recebeu 10 pontos do tipo estrela", retorno);
	}
	
	@Test
	public void recuperarQuantidadeDePontosDeUmUsuarioPorTipoPontuacao() {
		String retornoRegistro;
		int retornoPontos;
		retornoRegistro = armazenamento.registraPontuacao("guerra", "estrela", 10);
		assertEquals("O usuário guerra recebeu 10 pontos do tipo estrela", retornoRegistro);
		
		retornoPontos = armazenamento.quantidadePontosPorTipo("guerra", "estrela");
		assertEquals(10, retornoPontos);
	}
	
	@Test
	public void recuperarQuantidadeDePontosDeDoisUsuarioPorTipoPontuacao() {
		String retornoRegistro;
		int pontosGuerra;
		int pontosClovis;
		
		retornoRegistro = armazenamento.registraPontuacao("guerra", "estrela", 10);
		assertEquals("O usuário guerra recebeu 10 pontos do tipo estrela", retornoRegistro);
		retornoRegistro = armazenamento.registraPontuacao("clovis", "estrela", 5);
		assertEquals("O usuário clovis recebeu 5 pontos do tipo estrela", retornoRegistro);
		
		pontosGuerra = armazenamento.quantidadePontosPorTipo("guerra", "estrela");
		pontosClovis = armazenamento.quantidadePontosPorTipo("clovis", "estrela");
		assertEquals(10, pontosGuerra);
		assertEquals(5, pontosClovis);
	}
	
	@Test
	public void registrarTresUsuariosEVerificarUsuariosQuePossuemPontuacao() {
		armazenamento.registraPontuacao("guerra", "estrela", 10);
		armazenamento.registraPontuacao("clovis", "estrela", 5);
		armazenamento.registraPontuacao("fernandes", "moeda", 15);
		
		String nomes = "";
		
		for (UsuarioComPontuacao usuario : armazenamento.getUsuariosComPontuacao().getUsuariosComPontuacao()) {
			nomes += usuario.getNomeUsuario() + ", ";
		}
		
		assertEquals("guerra, clovis, fernandes, ", nomes);
	}
	
	@Test
	public void registrarCincoUsuariosEVerificarUsuariosQuePossuemPontuacao() {
		armazenamento.registraPontuacao("guerra", "estrela", 10);
		armazenamento.registraPontuacao("clovis", "estrela", 5);
		armazenamento.registraPontuacao("fernandes", "moeda", 15);
		armazenamento.registraPontuacao("eduardo", "moeda", 20);
		armazenamento.registraPontuacao("joao", "energia", 12);
		
		String nomes = "";
		
		for (UsuarioComPontuacao usuario : armazenamento.getUsuariosComPontuacao().getUsuariosComPontuacao()) {
			nomes += usuario.getNomeUsuario() + ", ";
		}
		
		assertEquals("guerra, clovis, fernandes, eduardo, joao, ", nomes);
	}
	
	@Test
	public void verificaTipoDePontoPorUsuario() {
		String tiposDePontos = "";

		armazenamento.registraPontuacao("guerra", "estrela", 10);
		
		for (String tipo : armazenamento.getTiposDePontosPorUsuario("guerra")) {
			tiposDePontos += tipo + ", ";
		}
		assertEquals("estrela, ", tiposDePontos);
	}
	
	@Test
	public void registrarDoisTiposDePontoParaOMesmoUsuario() {
		String tiposDePontos = "";

		armazenamento.registraPontuacao("guerra", "estrela", 10);
		armazenamento.registraPontuacao("guerra", "moeda", 20);
		
		for (String tipo : armazenamento.getTiposDePontosPorUsuario("guerra")) {
			tiposDePontos += tipo + ", ";
		}
		assertEquals("estrela, moeda, ", tiposDePontos);
	}
	
	@Test
	public void registrarVariosTiposDePontoParaDoisUsuarios() {
		String tiposDePontosGuerra = "";
		String tiposDePontosClovis = "";

		armazenamento.registraPontuacao("guerra", "estrela", 10);
		armazenamento.registraPontuacao("guerra", "moeda", 20);

		armazenamento.registraPontuacao("clovis", "energia", 10);
		armazenamento.registraPontuacao("clovis", "curtida", 5);
		
		for (String tipo : armazenamento.getTiposDePontosPorUsuario("guerra")) {
			tiposDePontosGuerra += tipo + ", ";
		}
		
		for (String tipo : armazenamento.getTiposDePontosPorUsuario("clovis")) {
			tiposDePontosClovis += tipo + ", ";
		}
		
		assertEquals("estrela, moeda, ", tiposDePontosGuerra);
		assertEquals("energia, curtida, ", tiposDePontosClovis);
	}
	
	@Test
	public void arquivoEstaComOsValoresCorretosCadastradosAnteriormente() {
		armazenamento.registraPontuacao("guerra", "estrela", 10);
		armazenamento.registraPontuacao("guerra", "moeda", 20);
		armazenamento.registraPontuacao("clovis", "energia", 10);
		armazenamento.registraPontuacao("clovis", "curtida", 5);
		
		UsuariosComPontuacao usuariosCadastrados = armazenamento.getUsuariosComPontuacao();
		
		Armazenamento armazenamentoValidacao = new Armazenamento(nomeArquivo);
		
		UsuariosComPontuacao usuariosRecuperadosDoArquivo = armazenamentoValidacao.getUsuariosComPontuacao();
		
		assertEquals(usuariosCadastrados, usuariosRecuperadosDoArquivo);
	}
	
}
