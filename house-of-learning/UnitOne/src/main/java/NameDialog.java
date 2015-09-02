import javax.swing.JOptionPane;


public class NameDialog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name;
		
		name = JOptionPane.showInputDialog("Qual o seu nome?");
		
		JOptionPane.showMessageDialog(null, String.format("Bem vindo %s!", name));

	}

}
