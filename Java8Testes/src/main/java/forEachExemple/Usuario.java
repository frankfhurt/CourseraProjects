package forEachExemple;

public class Usuario {

	private String name;
	private int pontos;
	private boolean moderador;

	public Usuario(String name, int pontos) {
		super();
		this.name = name;
		this.pontos = pontos;
		this.moderador = false;
	}

	public String getName() {
		return name;
	}

	public int getPontos() {
		return pontos;
	}

	public boolean isModerador() {
		return moderador;
	}
	
	public void tornaModerador() {
		this.moderador = true;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
