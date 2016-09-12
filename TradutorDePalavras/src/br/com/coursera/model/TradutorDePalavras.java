package br.com.coursera.model;

import java.io.IOException;

public class TradutorDePalavras {

	BancoDePalavras bancoDePalavras;
	
	public TradutorDePalavras() throws IOException {
		bancoDePalavras = new BancoDePalavras("palavras");
	}
	
	/**
	 * @param palavra
	 * @return Tradução
	 * @throws PalavraNaoEncontradaException 
	 */
	public String traduzirPalavra(String palavra) throws PalavraNaoEncontradaException {
		for (PortuguesIngles portIngl : bancoDePalavras.getPalavras()) {
			if (palavra.equals(portIngl.getPortugues()))
				return portIngl.getIngles();
			else if (palavra.equals(portIngl.getIngles()))
				return portIngl.getPortugues();
		}
		throw new PalavraNaoEncontradaException("A palavra # " + palavra + " # ainda não possui tradução cadastrada");
	}
}
