public class GradeBook {

	public GradeBook(String name) {
		curseName = name;
	}

	private String curseName;

	public String getCurseName() {
		return curseName;
	}

	public void setCurseName(String curseName) {
		this.curseName = curseName;
	}

	public void displayMessage() {
		System.out.println("Welcome to the Grade Book");
		System.out.printf("Curse: %s", getCurseName());
	}

	public void displayCurseName(String name) {
		System.out.printf("Bem vindo ao curso %s!", name);
	}
}
