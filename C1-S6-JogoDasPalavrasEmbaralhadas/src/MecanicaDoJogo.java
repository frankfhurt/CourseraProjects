
public interface MecanicaDoJogo {
	
	public String nomeDoJogo();
	
	public String proximaPalavra();

	public boolean acertouPalavra(String palavra);

	public void somaAcertos();
	
	public void somaErros();
	
	public int getAcertos();
	
	public int getErros();
	
	public boolean finalizouJogo();

}
