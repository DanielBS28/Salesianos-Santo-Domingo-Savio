package ejercicio6;

import java.util.Scanner;

public class ejercicio {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numero;
		int mayor = 0;
		for (int i = 0; i < 10; i++) {
			System.out.println("Introduce un número");
			numero = teclado.nextInt();
			if (numero > mayor) {
				mayor = numero;
			}
			
		}
		System.out.println("El mayor número introducido es:" + mayor);
	}

}
