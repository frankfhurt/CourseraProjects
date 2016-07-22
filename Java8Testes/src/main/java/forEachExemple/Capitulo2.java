package forEachExemple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

public class Capitulo2 {

	public static void main(String[] args) {
		
		BiFunction<String, Integer, Usuario> usuarioFactory = Usuario::new;
	
		Usuario user1 = usuarioFactory.apply("Paulo Silveira", 150);
		Usuario user2 = usuarioFactory.apply("Rodrigo Turini", 120);
		Usuario user3 = usuarioFactory.apply("Guilherme Silveira", 90);
		
		List<Usuario> usuarios = Arrays.asList(user1, user2, user3);
		usuarios = new ArrayList<>(usuarios);
		
		usuarios.stream()
			.sorted(Comparator.comparing(Usuario::getName))
			.peek(System.out::println)
			.forEach(null);
		
//		usuarios.removeIf(u -> u.getPontos() > 160);
//		usuarios.forEach(u -> System.out.println(u.getName()));
//		
//		usuarios.forEach(Usuario::tornaModerador);
		
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