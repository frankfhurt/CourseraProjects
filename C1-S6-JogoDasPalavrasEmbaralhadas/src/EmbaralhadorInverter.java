
public class EmbaralhadorInverter implements Embaralhador {

	@Override
	public String embaralhar(String palavra) {

		String resultado = "";
         
        for(int i = palavra.length()-1; i >= 0; i--){
            resultado += palavra.charAt(i);
        }
		
        return resultado.toLowerCase();
	}

}
