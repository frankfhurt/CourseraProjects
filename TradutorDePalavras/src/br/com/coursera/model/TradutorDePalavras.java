package br.com.coursera.model;

import java.io.IOException;

public class TradutorDePalavras {

	BancoDePalavras bancoDePalavras;
	
	public TradutorDePalavras(String path) throws IOException {
		bancoDePalavras = new BancoDePalavras(path);
	}
	
	/**
	 * @param palavra
	 * @return Tradução
	 * @throws PalavraNaoEncontradaException 
	 */
	public String traduzirPalavra(String palavra) throws PalavraNaoEncontradaException {
		for (PortuguesIngles portIngl : bancoDePalavras.getPalavras()) {
			if (palavra.equalsIgnoreCase(portIngl.getPortugues()))
				return portIngl.getIngles();
			else if (palavra.equalsIgnoreCase(portIngl.getIngles()))
				return portIngl.getPortugues();
		}
		throw new PalavraNaoEncontradaException("A palavra # " + palavra + " # ainda não possui tradução cadastrada");
	}
}
