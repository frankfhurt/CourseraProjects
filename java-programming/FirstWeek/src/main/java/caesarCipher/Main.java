package caesarCipher;

public class Main {
 
	public static void main(String[] args) {

		Encryptation enc1 = new Encryptation(16);
		String message = enc1.encrypt("Boa noite Cinderela");
		
		System.out.println("Criptografada: " + message);
		
//		System.out.println("Teste Forca bruta");
//		for (int i = 1; i < 26; i++) {
//			Encryptation enc = new Encryptation(i);
//			System.out.println(enc.decrypt(message));
//		}
		
		Encryptation enc2 = new Encryptation(15);
		System.out.println(enc2.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?"));
		
	}

}
