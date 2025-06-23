package ejercicio5;

import java.util.Scanner;

public class ejercicio {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numero;
		int numeroincrementado;
		for (int i = 0; i < 10; i++) {
			System.out.println("Introduce un número");
			numero = teclado.nextInt();
			numeroincrementado = numero + 5;
			System.out.println("El número que has introducido incrementado en cinco es " + numeroincrementado);
			System.out.println();
		}

	}

}
