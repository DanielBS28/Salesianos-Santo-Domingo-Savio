package ejerciciocalculadoraentornos;

import java.util.Scanner;

public class ejercicio1 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		int numero1, numero2, eleccion, resultado = 1;

		do {
			System.out.println("¿Qué operación quieres realizar?");
			System.out.println("1. Suma");
			System.out.println("2. Resta");
			System.out.println("3. Multiplicación");
			System.out.println("4. División");
			System.out.println("5. Potencia");
			eleccion = teclado.nextInt();
			if (eleccion < 1 || eleccion > 5) {
				System.out.println("El resultado es incorrecto, por favor repite el proceso.");
			}

		} while (eleccion < 1 || eleccion > 5);
		System.out.println("Dime el número 1");
		numero1 = teclado.nextInt();
		System.out.println("Dime el número 2");
		numero2 = teclado.nextInt();

		if (eleccion == 1) {
			System.out.println("El resultado de la suma es: " + (numero1 + numero2));
		} else if (eleccion == 2) {
			System.out.println("El resultado de la resta es: " + (numero1 - numero2));
		} else if (eleccion == 3) {
			System.out.println("El resultado de la multiplicación es: " + (numero1 * numero2));
		} else if (eleccion == 4) {
			System.out.println("El resultado de la división es: " + (numero1 / numero2));
		} else if (eleccion == 5) {

			for (int i = 0; i < numero2; i++) {
				resultado = (resultado * numero1);
			}
			System.out.println("El resultado de la potencia es: " + resultado);
		}

	}

}
