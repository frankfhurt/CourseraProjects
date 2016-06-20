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
	private String nomeArquivo;
	
	public Armazenamento(String nomeArquivo) {
		super();
		this.nomeArquivo = nomeArquivo;
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

	public UsuariosComPontuacao getUsuariosComPontuacao() {
		return usuariosComPontuacao;
	}
	
	public List<String> getTiposDePontosPorUsuario(String nomeUsuario) {
		List<String> tiposDePontos = new ArrayList<>();
		
		for (UsuarioComPontuacao usuario : usuariosComPontuacao.getUsuariosComPontuacao()) {
			if(nomeUsuario.equals(usuario.getNomeUsuario()))
				tiposDePontos.add(usuario.getTipoPontuacao());
		}
		
		return tiposDePontos;
	}
	
	protected void escreverNoArquivo(UsuarioComPontuacao usuario) throws IOException {
		File arquivo = new File("./" + nomeArquivo);
		FileWriter writer = new FileWriter(arquivo, true);
		PrintWriter printWriter = new PrintWriter(writer);
		
		printWriter.println(usuario.toString());
		printWriter.flush();
		printWriter.close();
	}
	
	protected void lerArquivo() throws IOException {
		File arquivo = new File("./" + nomeArquivo);
		usuariosComPontuacao = new UsuariosComPontuacao();
		
		if (arquivo.exists()) {
			String aux;
			BufferedReader reader = new BufferedReader(new FileReader("./" + nomeArquivo));
			
			while ((aux = reader.readLine()) != null) {
				String[] string = aux.split(";");
				String nome = string[0];
				String tipoPontuacao = string[1];
				String pontuacao = string[2];
				
				usuariosComPontuacao.adicionaUsuarioComPontuacao(new UsuarioComPontuacao(nome, tipoPontuacao, Integer.parseInt(pontuacao)));
			}
			reader.close();
		} else {
			arquivo.createNewFile();
		}
	}
}