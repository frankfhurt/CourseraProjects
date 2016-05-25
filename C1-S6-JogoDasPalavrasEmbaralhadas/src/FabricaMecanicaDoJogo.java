
public class FabricaMecanicaDoJogo {

	public MecanicaDoJogo obterMecanicaDoJogo(int n){
		
		if(n == 1)
			return new MecanicaDoJogoTreino();
		
		else if (n == 2)
			return new MecanicaDoJogoPadrao();
		
		else return null;	
	}
}
