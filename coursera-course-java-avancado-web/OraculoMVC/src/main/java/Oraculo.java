import java.util.ArrayList;
import java.util.List;

public class Oraculo {

	public List<String> getMelhoresProdutos(String tipo) {
		
		List<String> lista = new ArrayList<>();
		
		if ("doce de leite".equals(tipo)) {
			lista.add("Viçosa");
			lista.add("Boreal");
		} else if ("queijo mineiro".equals(tipo)) {
			lista.add("Candido Tostes");
			lista.add("Humaitá");
			lista.add("O da minha Tia Totônia");
		}
		return lista;
	}
	
}
