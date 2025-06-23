import java.util.Scanner;

public class LadosAsterisco {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		int lado;
		int base;
		char asterisco = '*';
		System.out.println("Dime un número y haré una base con asteriscos ");
		base = teclado.nextInt();
		System.out.println("Dime un número y haré un lado con con asteriscos ");
		lado = teclado.nextInt();
		for (int i = 0; i < lado; i++) {
			System.out.println("");
			for (int j = 0; j < base; j++) {
				System.out.print(asterisco + " ");
			}
		}

	}
}
