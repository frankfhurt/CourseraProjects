import java.util.ArrayList;
import java.util.List;


public class CarrinhoDeCompras {
	
	List<Pizza> pizzas;
	
	public CarrinhoDeCompras() {
		pizzas = new ArrayList<Pizza>();
	}

	boolean adicionarPizza(Pizza pizza){
		if (pizza.getPreco() != 0){
			pizzas.add(pizza);
			return true;
		} else {
			// System.out.println("Não é possível adicionar uma pizza sem ingrediente.");
			return false;
		}
	}
	
	int getValorTotal(){
		
		int vlrTotal = 0;
		
		if (pizzas.size() > 0){
			for (Pizza pizza : pizzas) {
				vlrTotal += pizza.getPreco();
			}
		} else {
			System.out.println("O Carrinho de Compras está vazio.");
		}
		
		return vlrTotal;
	}

}
