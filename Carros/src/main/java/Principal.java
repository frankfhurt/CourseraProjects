
public class Principal {

	public static void main(String[] args) {
		Corrida corrida = new Corrida(2000);
		
		corrida.adicionaCarro(new CarroSoma("CarroA", 10, 110));
		corrida.adicionaCarro(new CarroSoma("CarroB", 8, 140));
		
		corrida.adicionaCarro(new CarroMult("CarroC", 1.7, 100));
		corrida.adicionaCarro(new CarroMult("CarroD", 1.4, 110));
		
		corrida.umDoisTresEJa();
	}
	
}
