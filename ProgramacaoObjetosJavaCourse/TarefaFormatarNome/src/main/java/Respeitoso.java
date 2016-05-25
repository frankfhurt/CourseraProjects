
public class Respeitoso implements FormatadorNome {

	private String masculinoOuFeminino;
	
	public Respeitoso(String mascOuFem) {
		super();
		this.masculinoOuFeminino = mascOuFem;
	}

	@Override
	public String formatarNome(String nome, String sobrenome) {
		if (this.masculinoOuFeminino.toLowerCase().equals("masculino")){
			return "Sr. " + sobrenome;
		} else if (this.masculinoOuFeminino.toLowerCase().equals("feminino")){
			return "Sra. " + sobrenome;
		}
		return null;
	}

}
