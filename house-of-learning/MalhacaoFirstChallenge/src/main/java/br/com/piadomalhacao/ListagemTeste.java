package br.com.piadomalhacao;

import java.util.List;

public class ListagemTeste {

	public static void main(String[] args) {

		ListagemDeArquivo listador = new ListarArquivosWindows();

		List<String> retorno = listador
				.listar("C:\\Program Files\\eclipseLuna");
		//System.out.println(retorno.get(1));
		
		for (String aux : retorno) {
			System.out.println(aux);
		}
	}

}
