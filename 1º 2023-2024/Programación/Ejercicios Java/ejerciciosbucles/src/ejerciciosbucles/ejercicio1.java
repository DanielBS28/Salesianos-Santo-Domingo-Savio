package ejerciciosbucles;

import java.util.Scanner;

public class ejercicio1 {

	public static void main(String[] args) {
		int numero;
		int numeroAux;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Te voy a pedir dos números, si los dos números son iguales hemos terminado el programa");
		do {
			System.out.println("Dime el número 1");
			numero = teclado.nextInt();
			numeroAux = numero;
			System.out.println("Dime el otro número");
			numero = teclado.nextInt();
			if (numero == numeroAux) {
				System.out.println("Los números son iguales hemos acabado");
			} else
				System.out.println("Los números no son iguales por favor repite el proceso");

		} while (numero != numeroAux);
	}
}
