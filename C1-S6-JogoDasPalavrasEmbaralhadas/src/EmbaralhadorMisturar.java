import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmbaralhadorMisturar implements Embaralhador {

	@Override
	public String embaralhar(String palavra) {
		
	    List<String> lista = new ArrayList<String>();
        String resultado = "";

        for (int i = 0; i < palavra.length(); i++) {
            lista.add(String.valueOf(palavra.charAt(i)));
        }
  
        Collections.shuffle(lista);

        for (int i = 0; i < palavra.length(); i++) {
            resultado += lista.get(i);
        }
        return resultado.toLowerCase();
	}
}