import java.util.Scanner;

public class ContaTeste {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		double valorDeposito;

		Conta conta1 = new Conta(50.00);
		Conta conta2 = new Conta(-7.53);

		System.out.println("Saldo da conta1: " + conta1.getSaldo());
		System.out.println("Saldo da conta2: " + conta2.getSaldo());

		System.out.println("Entre com o valor para depósito na conta1: ");
		valorDeposito = entrada.nextDouble();
		conta1.deposito(valorDeposito);
		System.out.println("Valor depositado na conta1: " + valorDeposito);

		System.out.println("Saldo da conta1: " + conta1.getSaldo());
		System.out.println("Saldo da conta2: " + conta2.getSaldo());
		
		System.out.println("Entre com o valor para depósito na conta2: ");
		valorDeposito = entrada.nextDouble();
		conta2.deposito(valorDeposito);
		System.out.println("Valor depositado na conta2: " + valorDeposito);
		
		System.out.println("Saldo da conta1: " + conta1.getSaldo());
		System.out.println("Saldo da conta2: " + conta2.getSaldo());
		
	}
}
