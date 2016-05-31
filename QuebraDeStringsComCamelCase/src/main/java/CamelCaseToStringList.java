import java.util.ArrayList;
import java.util.List;

public class CamelCaseToStringList {
	
	private static List<String> palavras = new ArrayList<>();
	private static int index = 0;
	private static char anterior;
	private static String palavraMaiuscula = "";
	private static String numero = "";
	
	private CamelCaseToStringList() {
		super();
	}

	private static void adicionaNaListaDePalavras(String palavra) {
		palavras.add(palavra);
	}
	
	public static void limparListaDePalavras() {
		palavras.clear();
	}
	
	public static void setIndex(int i) {
		index = i;
	}
	
	public static void zerarIndex() {
		index = 0;
	}
	
	public static void setAnterior(char c) {
		anterior = c;
	}
	
	public static void limparPalavraMaiuscula() {
		palavraMaiuscula = "";
	}
	
	public static void setPalavraMaiuscula(String s) {
		palavraMaiuscula = s;
	}
	
	public static void limparNumero() {
		 numero = "";
	}
	
	public static void setNumero(String s) {
		numero = s;
	}

	public static List<String> converterCamelCase(String original) throws ErroDeValidacao {
		validacaoInicial(original);
		for (int i = 1; i < original.length(); i++) {
			setAnterior(original.charAt(i - 1));
			efetuaValidacoesEPopulaListaDePalavras(original, i);
		}
		if (palavras.isEmpty())
			adicionaNaListaDePalavras(original.toLowerCase());
		return palavras;
	}

	private static void efetuaValidacoesEPopulaListaDePalavras(String original, int i) {
		if (caracterAnteriorEAtualSaoMaiusculos(original, anterior, i))
			setPalavraMaiuscula(validacoesParaPalavraMaiuscula(original, anterior, palavraMaiuscula, i));
		else if (palavraMaiusculaDeveSerAdicionadaALista(original, anterior, palavraMaiuscula, i))
			adicionaEAtualizaIndexELimpaPalavraMaiuscula(i);
		else if (original.length() - 1 == i)
			adicionaNaListaDePalavras(original.substring(index, i + 1).toLowerCase());
		else if (Character.isUpperCase(original.charAt(i)))
			adicionaNaListaDePalavrasEAtualizaIndex(original, i);
		else if (Character.isDigit(original.charAt(i)))
			efetuaMovimentacaoParaNumero(original, i);
		else if (numeroNaoEstaVazioECharAnteriorEUmDigito(original, i))
			adicionaNaListaDePalavrasELimpaNumero();
	}

	private static void adicionaNaListaDePalavrasELimpaNumero() {
		adicionaNaListaDePalavras(numero);
		limparNumero();
	}

	private static void efetuaMovimentacaoParaNumero(String original, int i) {
		if (numero.isEmpty())
			adicionaNaListaDePalavrasEAtualizaIndex(original, i);
		setNumero(numero + original.charAt(i));
	}

	private static boolean numeroNaoEstaVazioECharAnteriorEUmDigito(String original, int i) {
		return !numero.isEmpty() && Character.isDigit(original.charAt(i - 1));
	}

	private static void adicionaNaListaDePalavrasEAtualizaIndex(String original, int i) {
		adicionaNaListaDePalavras(original.substring(index, i).toLowerCase());
		setIndex(i);
	}

	private static void adicionaEAtualizaIndexELimpaPalavraMaiuscula(int i) {
		adicionaNaListaDePalavras(palavraMaiuscula.substring(0, palavraMaiuscula.length() - 1));
		limparPalavraMaiuscula();
		setIndex(i - 1);
	}

	private static boolean caracterAnteriorEAtualSaoMaiusculos(String original, char anterior, int i) {
		return Character.isUpperCase(anterior) && Character.isUpperCase(original.charAt(i));
	}

	private static String validacoesParaPalavraMaiuscula(String original, char anterior, String palavraMaiuscula, int i) {
		String ret;
		if (palavraMaiuscula.length() == 0)
			ret = palavraMaiuscula + anterior + original.charAt(i);
		else
			ret = palavraMaiuscula + original.charAt(i);
		if (original.length() - 1 == i)
			adicionaNaListaDePalavrasELimpaPalavraMaiuscula(ret);
		return ret;
	}

	private static void adicionaNaListaDePalavrasELimpaPalavraMaiuscula(String palavraMaiuscula) {
		adicionaNaListaDePalavras(palavraMaiuscula);
		limparPalavraMaiuscula();
	}

	private static void validacaoInicial(String original) throws StringVaziaException, CaracterEspecialException, IniciaComNumeroException {
		verificaStringVazia(original);
		verificaCaracterEspecial(original);
		verificaSeIniciaComNumero(original);
	}

	private static boolean palavraMaiusculaDeveSerAdicionadaALista(String original, char anterior, String palavraMaiuscula, int i) {
		return Character.isUpperCase(anterior) && !Character.isUpperCase(original.charAt(i)) && i > 1 && palavraMaiuscula.length() > 0;
	}

	private static void verificaCaracterEspecial(String original) throws CaracterEspecialException {
		for (int i = 0; i < original.length(); i++) {
			if (!Character.isLetterOrDigit(original.charAt(i)))
				throw new CaracterEspecialException( "Inválido - caracteres especiais não são permitidos, somente letras e números");
		}
	}

	private static void verificaStringVazia(String original) throws StringVaziaException {
		if (original.isEmpty())
			throw new StringVaziaException("Inválido - a string está vazia");
	}

	private static void verificaSeIniciaComNumero(String original) throws IniciaComNumeroException {
		if (Character.isDigit(original.charAt(0)))
			throw new IniciaComNumeroException("Inválido - não deve começar com números");
	}

}
