package testes;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gamificacao.Armazenamento;

public class ArmazenamentoTest {

	private Armazenamento armazenamento;
	
	@Before
	public void preparaAmbienteDeTeste() throws Exception {
		armazenamento = new Armazenamento();
		File f = new File("./UsuariosComPontuacao.txt");
		f.delete();
		f.createNewFile();
	}
	
	@After
	public void zeraArquivoDeUsuarios() throws IOException {
		File f = new File("./UsuariosComPontuacao.txt");
		f.delete();
		f.createNewFile();
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
		
		for (String nome : armazenamento.getUsuariosComPontuacao()) {
			nomes += nome + ", ";
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
		
		for (String nome : armazenamento.getUsuariosComPontuacao()) {
			nomes += nome + ", ";
		}
		
		assertEquals("guerra, clovis, fernandes, eduardo, joao, ", nomes);
	}
	
	@Test
	public void teste() {
	}

}
