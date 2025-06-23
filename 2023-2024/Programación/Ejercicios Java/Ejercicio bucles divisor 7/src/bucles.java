import java.util.Scanner;

public class bucles {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numerointroducido;

		boolean esdivisible7;
		do {
			System.out.println("Introduce un número, acabaremos si es divisible entre 7");
			numerointroducido = teclado.nextInt();
			esdivisible7 = (numerointroducido % 7 == 0);
		} while (esdivisible7 || numerointroducido <= 30);
		System.out.println("Fin del bucle");
		{

		}
	}
}
