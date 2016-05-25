
public abstract class CarroDeCorrida {

	protected abstract void acelerar();

	protected int velocidade;
	protected int velocidadeMaxima;
	protected String nome;
	
	public CarroDeCorrida(String nome, int velocidadeMaxima) {
		super();
		this.nome = nome;
		this.velocidadeMaxima = velocidadeMaxima;
		this.velocidade = 0;
	}

	public String getNome() {
		return nome;
	}

	protected void frear() {
		velocidade = velocidade / 2;
	}

	protected int getVelocidade() {
		return velocidade;
	}

}
