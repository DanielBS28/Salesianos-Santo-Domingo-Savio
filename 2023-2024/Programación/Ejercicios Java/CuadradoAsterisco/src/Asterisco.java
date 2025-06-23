import java.util.Scanner;

public class Asterisco {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		int numerointroducido;
		char asterisco = '*';
		System.out.println("Dime un número y haré un cuadrado con asteriscos ");
		numerointroducido = teclado.nextInt();
		for (int i = 0; i < numerointroducido; i++) {
			System.out.println("");
			for (int j = 0; j < numerointroducido; j++) {
				System.out.print(asterisco + " ");
			}
		}

	}
}
