package ejerciciosbucles;

import java.util.Scanner;

public class ejercicio3 {
	public static void main(String[] args) {
		/*
		 * Realizar un programa en el que se pide al usuario que introduzca un número.
		 * Se le seguirá pidiendo repetidamente un número hasta que introduzca un 0, en
		 * cuyo caso finalizará el programa y se mostrará un mensaje indicando cuántos
		 * números pares ha introducido
		 */
		Scanner teclado = new Scanner(System.in);
		int numero;
		int contador = 0;
		do {
			System.out.println("Dime un número");
			numero = teclado.nextInt();
			if (numero % 2 == 0) {
				contador = contador + 1;
			}
			if (numero == 0) {
				contador = contador - 1;
			}
		} while (numero != 0);

		System.out.println("El número de introducuidos pares es " + contador);
	}
}
