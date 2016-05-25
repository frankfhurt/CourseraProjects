import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Pizza {

	List<String> ingredientes;
	static HashMap<String, Integer> ingredientesGastos = new HashMap<>();
	
	public Pizza() {
		ingredientes = new ArrayList<>();
	}

	void adicionaIngrediente(String ingrediente){
		ingredientes.add(ingrediente);
		contabilizaIngrediente(ingrediente);
	}
	
	int getPreco(){

		if (ingredientes.size() == 0){
			return 0;
		} else if (ingredientes.size() < 3){
			return 15;
		} else if (ingredientes.size() < 6){
			return 20;
		} else if (ingredientes.size() > 5){
			return 23;
		}
		
		return 0;
	}
	
	static void contabilizaIngrediente(String ingrediente){
		
		if (ingredientesGastos.get(ingrediente) == null){
			ingredientesGastos.put(ingrediente, 1);
		} else {
			Integer nroIngrediente = ingredientesGastos.get(ingrediente);
			nroIngrediente ++;
			ingredientesGastos.put(ingrediente, nroIngrediente);
		}
	}
	
	static void zerarRegistroIngredientes(){
		ingredientesGastos.clear();
	}
}
