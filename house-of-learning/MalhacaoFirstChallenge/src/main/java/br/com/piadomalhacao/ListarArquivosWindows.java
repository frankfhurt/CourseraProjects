package br.com.piadomalhacao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListarArquivosWindows implements ListagemDeArquivo {

	@Override
	public List<String> listar(String src) {
		
		File diretorio = new File(src);
		String[] arquivos = diretorio.list();
		
		List<String> retorno = new ArrayList<String>();
		
		for (String arquivo : arquivos) {
			retorno.add(arquivo);
		}
		
		return retorno;
	}

}
