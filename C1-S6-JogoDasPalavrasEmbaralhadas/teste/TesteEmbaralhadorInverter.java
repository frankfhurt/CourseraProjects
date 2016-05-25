import static org.junit.Assert.*;

import org.junit.Test;

public class TesteEmbaralhadorInverter {

	@Test
	public void test() {

		Embaralhador embaralhador = new EmbaralhadorInverter();
		String palavra   = "daniel";
		String invertida = "leinad";

		assertEquals(invertida, embaralhador.embaralhar(palavra));
	}
}
