import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TesteEmbaralhadorMisturar {

	@Test
	public void test() {
		Embaralhador embaralhador = new EmbaralhadorMisturar();
		String palavra   = "daniel";
		String misturada = embaralhador.embaralhar(palavra);

		char[] sequenciaPalavra = palavra.toCharArray();
		char[] sequenciaMisturada = misturada.toCharArray();

		Arrays.sort(sequenciaPalavra);
		Arrays.sort(sequenciaMisturada);

		palavra = Arrays.toString(sequenciaPalavra);
		misturada = Arrays.toString(sequenciaMisturada);
	
		assertEquals(palavra, misturada);
	}

}
