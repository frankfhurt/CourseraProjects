import java.util.HashMap;
import java.util.Map;

public class Tradutor {

	private Map<String, String> traducoes = new HashMap<>();
	
	public boolean estaVazio() {
		return traducoes.isEmpty();
	}

	public void adicionaTraducao(String palavra, String traducao) {
		
		if (traducoes.containsKey(palavra)) {
			traducao = traduzirPalavra(palavra) + ", " + traducao;
		}
		
		traducoes.put(palavra, traducao);
		
	}

	public String traduzirPalavra(String palavra) {
		return traducoes.get(palavra);
	}

	public String traduzirFrase(String frase) {
		String[] palavras = frase.split(" ");
		String fraseTraduzida = "";
		
		for (String palavra : palavras) {
			String traducao = primeiraTraducao(palavra);
			fraseTraduzida += " " + traducao;
		}
		
		return fraseTraduzida.trim();
	}

	private String primeiraTraducao(String palavra) {
		String traducao = traduzirPalavra(palavra);
		
		if (traducao.contains(","))
			traducao = traducao.substring(0, traducao.indexOf(","));
		return traducao;
	}

}
