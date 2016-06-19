package gamificacao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Armazenamento {

	private UsuariosComPontuacao usuariosComPontuacao;
	
	public Armazenamento() {
		super();
		try {
			lerArquivo();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro na leitura do arquivo e/ou carregamento da informações.");
		}
	}

	public String registraPontuacao(String nomeUsuario, String tipoPontuacao, int pontuacao) {

		UsuarioComPontuacao usuario = new UsuarioComPontuacao(nomeUsuario, tipoPontuacao, pontuacao);

		try {
			escreverNoArquivo(usuario);
			usuariosComPontuacao.adicionaUsuarioComPontuacao(usuario);
			return "O usuário " + nomeUsuario + " recebeu " + pontuacao + " pontos do tipo " + tipoPontuacao;
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro ao escrever no arquivo.";
		}
	}

	public int quantidadePontosPorTipo(String nomeUsuario, String tipoPontuacao) {
		return usuariosComPontuacao.getPontuacaoPorNomeUsuarioETipoPontuacao(nomeUsuario, tipoPontuacao);
	}

	public List<String> getUsuariosComPontuacao() {
		
		List<String> nomeUsuarios = new ArrayList<>();
		
		for (UsuarioComPontuacao usuario : usuariosComPontuacao.getUsuariosComPontuacao()) {
			nomeUsuarios.add(usuario.getNomeUsuario());
		}
		
		return nomeUsuarios;
	}
	
	private void escreverNoArquivo(UsuarioComPontuacao usuario) throws IOException {
		File arquivo = new File("./UsuariosComPontuacao.txt");
		FileWriter writer = new FileWriter(arquivo, true);
		PrintWriter printWriter = new PrintWriter(writer);
		
		printWriter.println(usuario.toString());
		printWriter.flush();
		printWriter.close();
	}
	
	private void lerArquivo() throws NumberFormatException, IOException {
		String aux = "";
		usuariosComPontuacao = new UsuariosComPontuacao();
		BufferedReader reader = new BufferedReader(new FileReader("./UsuariosComPontuacao.txt"));
		
		while ((aux = reader.readLine()) != null) {
			String string[] = aux.split(";");
			String nome = string[0];
			String tipoPontuacao = string[1];
			String pontuacao = string[2];
			
			usuariosComPontuacao.adicionaUsuarioComPontuacao(new UsuarioComPontuacao(nome, tipoPontuacao, Integer.parseInt(pontuacao)));
		}
		reader.close();
	}

}