import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BancoDePalavras {

	private ArrayList<String> palavras = new ArrayList<String>();
	
	public BancoDePalavras(){

		String  enderecoDoArquivo = "arquivo/palavras.txt";
		Scanner arquivo = null;

        try {
			
			arquivo = new Scanner(new FileReader(enderecoDoArquivo));
						
			while (arquivo.hasNextLine()){
				this.palavras.add(arquivo.nextLine().toLowerCase());
			}			
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} finally {
			arquivo.close();
		}		
	}
		
	public String retornaPlalavra(){
		
		int n;
		String palavra = "";
		Random gerador = new Random();
		
		if (!this.palavras.isEmpty()) {
		
			n = gerador.nextInt(this.palavras.size());
			palavra = this.palavras.get(n);
			this.palavras.remove(n);
			return palavra;
		
		} else  
			return null;
	}

	public boolean existePalavra(){
		return !this.palavras.isEmpty();
	}	
}
