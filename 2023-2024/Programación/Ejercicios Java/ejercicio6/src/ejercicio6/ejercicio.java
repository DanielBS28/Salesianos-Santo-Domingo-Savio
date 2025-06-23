package ejercicio6;

import java.util.Scanner;

public class ejercicio {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numero;
		int menor = 0;
		for (int i = 0; i < 10; i++) {
			System.out.println("Introduce un número");
			numero = teclado.nextInt();
			if (i==0)
				menor = numero;
			if (numero < menor) {
				menor = numero;
			}
			
		}
		System.out.println("El menor número introducido es: " + menor);
	}

}
