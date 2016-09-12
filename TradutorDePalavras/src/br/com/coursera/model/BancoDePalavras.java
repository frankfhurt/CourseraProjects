package br.com.coursera.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BancoDePalavras {

	private List<PortuguesIngles> palavras = new ArrayList<>();
	private final String path;

	public BancoDePalavras(String path) throws IOException {
		this.path = path;
		populaPalavras();
	}

	private void populaPalavras() throws IOException {
		Stream<String> stream = Files.lines(Paths.get(path));
		stream.forEach(line -> {
			int pontoEVirgula = line.indexOf(";");
			PortuguesIngles palavra = new PortuguesIngles(line.substring(0, pontoEVirgula),
					line.substring(pontoEVirgula + 1));
			palavras.add(palavra);
		});
		stream.close();
	}

	public List<PortuguesIngles> getPalavras() {
		return palavras;
	}

}