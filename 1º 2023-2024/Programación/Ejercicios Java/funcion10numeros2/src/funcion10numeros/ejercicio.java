package funcion10numeros;

import java.util.Scanner;

public class ejercicio {

	static int contarnegativos(int numerointroducido) {

		int numeros;
		int contador = 0;
		Scanner teclado = new Scanner(System.in);

		for (int i = 0; i < numerointroducido; i++) {
			System.out.println("Introduce un número");
			numeros = teclado.nextInt();
			if (numeros < 0) {
				contador++;
			}
		}
		return contador;
	}

	public static void main(String[] args) {
		int numeronegativos;
		int numerointroducido;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce la cantidad de números que quieres meter");
		numerointroducido = teclado.nextInt();
		
		numeronegativos = contarnegativos(numerointroducido);
		System.out.println("La cantidad de números negativos es: " + numeronegativos);
	}

}
