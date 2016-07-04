package caesarCipher;

public class Encryptation {

	private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
	private String shifted;
	private String shiftedLower;
	
	public Encryptation(int key) {
		super();
		this.shifted = alphabet.substring(key) + alphabet.substring(0, key);
		this.shiftedLower = alphabetLower.substring(key) + alphabetLower.substring(0, key);
	}
	
	public String encrypt(String message) {
		StringBuilder ret = new StringBuilder();
		
		for (int i = 0; i < message.length(); i++) {
			char letter = message.charAt(i);
			try {
				if (Character.isLowerCase(letter))
					ret.append(shiftedLower.charAt(alphabetLower.indexOf(letter)));
				else
					ret.append(shifted.charAt(alphabet.indexOf(letter)));
			} catch (Exception e) {
				ret.append(letter);
			}
		}
		return ret.toString();
	}
	
	public String decrypt(String message) {
		StringBuilder ret = new StringBuilder();
		
		for (int i = 0; i < message.length(); i++) {
			char letter = message.charAt(i);
			try {
				if (Character.isLowerCase(letter))
					ret.append(alphabetLower.charAt(shiftedLower.indexOf(letter)));
				else
					ret.append(alphabet.charAt(shifted.indexOf(letter)));
			} catch (Exception e) {
				ret.append(letter);
			}
		}
		return ret.toString();
	}
}
