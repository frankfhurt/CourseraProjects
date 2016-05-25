import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		FabricaMecanicaDoJogo fabrica = new FabricaMecanicaDoJogo();
		MecanicaDoJogo mecanica;
		Scanner sc = new Scanner(System.in); 
		String entrada = "";
		
		System.out.println("BEM VINDO AO JOGO DAS PALAVRAS EMBARALHADAS\n");
		System.out.println("Treino tecle: 1");
		System.out.println("Padrão tecle: 2");
		
		entrada = sc.nextLine();
		while (!entrada.trim().equals("1") && !entrada.trim().equals("2")){
			System.out.println("Opção não encontrada. Tecle novamente:");
			entrada = sc.nextLine();
		}
		
		mecanica = fabrica.obterMecanicaDoJogo(Integer.parseInt(entrada));
				
		System.out.println(mecanica.nomeDoJogo());
		System.out.println("Para encerrar digite: sair \n");
		
        while (!mecanica.finalizouJogo() && !entrada.equals("sair")){
        
        	System.out.println("Embaralhada: " + mecanica.proximaPalavra());
        	System.out.println("Qual é a palavra?");
        	entrada = sc.nextLine();
        	
        	if(!entrada.equals("sair")){
        		if (mecanica.acertouPalavra(entrada.toLowerCase())){
        			mecanica.somaAcertos();
        			System.out.println(":) \n");
        		} else {
        			mecanica.somaErros();
        			System.out.println("ops! :( \n");
        		}
        	}
        }

        sc.close();
        System.out.println("\nFim do Jogo!");
        System.out.println("Acertos: " + mecanica.getAcertos());
        System.out.println("Erros:" + mecanica.getErros());
 	}
}
