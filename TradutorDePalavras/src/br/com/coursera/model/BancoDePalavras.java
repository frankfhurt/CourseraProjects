package br.com.coursera.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BancoDePalavras {

	private List<PortuguesIngles> palavras = new ArrayList<>();
	private final String fileName;

	public BancoDePalavras(String fileName) throws IOException {
		this.fileName = fileName;
		populaPalavras();
	}

	private void populaPalavras() throws IOException {
		System.out.println(this.getClass().getClassLoader().getResource(fileName).getPath());
		Stream<String> stream = Files.lines(Paths.get(this.getClass().getClassLoader().getResource(fileName).getPath()));

		stream.forEach(line -> {
			int pontoEVirgula = line.indexOf(";");
			PortuguesIngles palavra = new PortuguesIngles(line.substring(0, pontoEVirgula - 1),
					line.substring(pontoEVirgula + 1));
			palavras.add(palavra);
		});
		stream.close();
	}

	public List<PortuguesIngles> getPalavras() {
		return palavras;
	}

}