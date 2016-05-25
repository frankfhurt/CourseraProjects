import java.util.HashMap;
import java.util.Map;

public class CarrinhoDeCompras {

	private Map<Produto, Integer> carrinho = new HashMap<>();

	public void adicionaProduto(Produto produto, Integer qtd) {
		if (carrinho.containsKey(produto)) {
			carrinho.put(produto, carrinho.get(produto) + qtd);
		} else {
			carrinho.put(produto, qtd);
		}
	}

	public void removeProduto(Produto produto, Integer qtd) {
		if (carrinho.containsKey(produto)) {

			carrinho.put(produto, carrinho.get(produto) - qtd);

			if (carrinho.get(produto) <= 0) {
				carrinho.remove(produto);
			}
		}
	}

	public int getValorTotal() {
		int total = 0;

		for (Produto prod : carrinho.keySet()) {
			int qtd = carrinho.get(prod);

			total += prod.getPreco() * qtd;
		}

		return total;
	}

	public int getQtdeProdutosDiferentesNoCarrinho() {
		return carrinho.size();
	}

}
