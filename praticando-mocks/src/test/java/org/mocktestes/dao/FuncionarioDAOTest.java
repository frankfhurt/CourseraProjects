package org.mocktestes.dao;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mocktestes.model.Funcionario;

public class FuncionarioDAOTest {

	private FuncionarDAO funcionarioDAO;
	
	@Mock
	private Transacao transacao;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		funcionarioDAO = new FuncionarDAO(transacao);
	}
	
	@Test
	public void quandoUmUsuarioValidoForPesquisado() {
		Funcionario funcionario = new Funcionario("RAPHAEL", "12345", 2045);
		
		when(transacao.executar("12345")).thenReturn(funcionario);
		
		Funcionario func = funcionarioDAO.buscar("12345");
		
		assertEquals("RAPHAEL", func.getName());
		assertEquals("12345", func.getMatricula());
		assertEquals(2045, func.getSetor());
		
		verify(transacao, atLeastOnce()).executar("12345");
	}
}
