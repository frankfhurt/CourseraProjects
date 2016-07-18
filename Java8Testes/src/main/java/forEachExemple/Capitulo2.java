package forEachExemple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Capitulo2 {

	public static void main(String[] args) {
	
		Usuario user1 = new Usuario("Paulo Silveira", 150);
		Usuario user2 = new Usuario("Rodrigo Turini", 120);
		Usuario user3 = new Usuario("Guilherme Silveira", 190);
		
		List<Usuario> usuarios = Arrays.asList(user1, user2, user3);
		usuarios = new ArrayList<>(usuarios);
		
		usuarios.forEach(u -> System.out.println(u.getName()));
		
		usuarios.removeIf(u -> u.getPontos() > 160);
		usuarios.forEach(u -> System.out.println(u.getName()));
		
		usuarios.forEach(Usuario::tornaModerador);
		
	}
}

//		Validador<String> validadorCEP = valor -> valor.matches("[0-9]{5}-[0-9]{3}");
//		
//		String cep = "82650-505";
//		
//		if (validadorCEP.valida(cep))
//			System.out.println("O CEP: " + cep + " é Válido!");
//		else
//			System.out.println("O CEP: " + cep + " é Inválido!");
//		
//		Consumer<Usuario> mensagem = u -> System.out.printf("Nome: ");
//		Consumer<Usuario> imprimeNome = u -> System.out.println(u.getName());
//		
//		usuarios.forEach(mensagem.andThen(imprimeNome.andThen(imprimeNome)));