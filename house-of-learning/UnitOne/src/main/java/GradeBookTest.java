import java.util.Scanner;

public class GradeBookTest {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String nameOfCurse;
		
		GradeBook myGradeBook = new GradeBook("Name Default");
		GradeBook myGradeBook1 = new GradeBook("Nome do GradeBook 1");
		GradeBook myGradeBook2 = new GradeBook("Nome do GradeBook 2");
		
		System.out.println("\nNome do 1o grade: " + myGradeBook1.getCurseName());
		System.out.println("\nNome do 2o grade: " + myGradeBook2.getCurseName());
		
//		System.out.printf("Nome do Curso antes: %s", myGradeBook.getCurseName());
//		System.out.print("\nEnter the curse name: ");
//		nameOfCurse = input.nextLine();
//		myGradeBook.setCurseName(nameOfCurse);
//		
//		myGradeBook.displayMessage();
		
//		System.out.print("Enter the curse name: ");
//		nameOfCurse = input.nextLine();
//		System.out.println();
//		
//		myGradeBook.displayCurseName(nameOfCurse);

	}
}