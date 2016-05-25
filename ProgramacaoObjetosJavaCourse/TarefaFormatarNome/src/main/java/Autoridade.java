
public class Autoridade {

	private String nome;
	private String sobrenome;
	private FormatadorNome formatador;
	
	public Autoridade(String nome, String sobrenome, FormatadorNome formatador) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.formatador = formatador;
	}

	public String getTratamento(){
		return formatador.formatarNome(nome, sobrenome);
	}
	
}
