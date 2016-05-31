import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Test;

public class CamelCaseToStringListTest {

	private List<String> palavras;
	
	@After
	public void limparAmbienteParaProximoTeste() {
		CamelCaseToStringList.limparListaDePalavras();
		CamelCaseToStringList.zerarIndex();
		CamelCaseToStringList.limparNumero();
		CamelCaseToStringList.limparPalavraMaiuscula();
	}
	
	@Test
	public void converteUmaPalavra() throws ErroDeValidacao {
		
		palavras = CamelCaseToStringList.converterCamelCase("nome");
		
		assertEquals("nome", palavras.get(0));
	}
	
	@Test
	public void converteUmaPalavraComPrimeiraLetraMaiuscula() throws ErroDeValidacao {
		
		palavras = CamelCaseToStringList.converterCamelCase("Nome");
		
		assertEquals("nome", palavras.get(0));
	}
	
	@Test
	public void converteDuasPalavras() throws ErroDeValidacao {
		
		palavras = CamelCaseToStringList.converterCamelCase("nomeComposto");

		assertEquals("nome", palavras.get(0));
		assertEquals("composto", palavras.get(1));
	}

	@Test
	public void converteDuasPalavrasComPrimeiraLetraMaiuscula() throws ErroDeValidacao {
		
		palavras = CamelCaseToStringList.converterCamelCase("NomeComposto");
		
		assertEquals("nome", palavras.get(0));
		assertEquals("composto", palavras.get(1));
	}
	
	@Test
	public void converteSeisPalavras() throws ErroDeValidacao {

		palavras = CamelCaseToStringList.converterCamelCase("QuebraDeStringsComCamelCase");
		
		assertEquals("quebra", palavras.get(0));
		assertEquals("de", palavras.get(1));
		assertEquals("strings", palavras.get(2));
		assertEquals("com", palavras.get(3));
		assertEquals("camel", palavras.get(4));
		assertEquals("case", palavras.get(5));
	}
	
	@Test
	public void converteTodasMaiusculas() throws ErroDeValidacao {
		
		palavras = CamelCaseToStringList.converterCamelCase("CPF");
		
		assertEquals("CPF", palavras.get(0));
	}
	
	@Test(expected=CaracterEspecialException.class)
	public void converteCaracterEspecial() throws ErroDeValidacao {
		
		palavras = CamelCaseToStringList.converterCamelCase("nome#Composto");
	}
	
	@Test(expected=StringVaziaException.class)
	public void stringVazia() throws ErroDeValidacao{
		palavras = CamelCaseToStringList.converterCamelCase("");
	}
	
	@Test
	public void converteMaiusculasEMinusculas() throws ErroDeValidacao {
		
		palavras = CamelCaseToStringList.converterCamelCase("numeroCPF");
		
		assertEquals("numero", palavras.get(0));
		assertEquals("CPF", palavras.get(1));
	}
	
	@Test
	public void converteMaiusculasEMinusculasTeste2() throws ErroDeValidacao {
		
		palavras = CamelCaseToStringList.converterCamelCase("numeroCPFContribuinte");
		
		assertEquals("numero", palavras.get(0));
		assertEquals("CPF", palavras.get(1));
		assertEquals("contribuinte", palavras.get(2));
	}
	
	@Test
	public void convertePalavraComNumeros() throws ErroDeValidacao {
		
		palavras = CamelCaseToStringList.converterCamelCase("recupera10Primeiros");
		
		assertEquals("recupera", palavras.get(0));
		assertEquals("10", palavras.get(1));
		assertEquals("primeiros", palavras.get(2));
	}
	
	@Test(expected=IniciaComNumeroException.class)
	public void convertePalavraIniciandoComNumeros() throws ErroDeValidacao {
		
		palavras = CamelCaseToStringList.converterCamelCase("10Primeiros");
	}

}
