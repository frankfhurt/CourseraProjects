import java.util.Random;

public class FabricaEmbaralhadores {

	public Embaralhador buscarEmbaralhador(){
		
		Integer n  = new Integer(0);
		Random gerador = new Random();
		n = gerador.nextInt();

	     if((n  % 2) == 0)  
	         //par
	    	 return new EmbaralhadorMisturar();
	      else 
	         //ímpar
	    	 return new EmbaralhadorInverter();		
	}
}
