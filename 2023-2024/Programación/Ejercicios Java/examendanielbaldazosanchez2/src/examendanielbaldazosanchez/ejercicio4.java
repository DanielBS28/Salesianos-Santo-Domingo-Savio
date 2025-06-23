package examendanielbaldazosanchez;

import java.util.Scanner;

public class ejercicio4 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		double lado1;
		double lado2;
		double lado3;

		do {
			System.out.println("Dime la medida del lado 1");
			lado1 = teclado.nextDouble();
			if (lado1 <= 0) {
				System.out.println("La medida del lado 1 es incorrecta por favor repite el número");
			}
		} while (lado1 <= 0);
		do {
			System.out.println("Dime la medida del lado 2");
			lado2 = teclado.nextDouble();
			if (lado2 <= 0) {
				System.out.println("La medida del lado 2 es incorrecta por favor repite el número");
			}
		} while (lado2 <= 0);
		do {
			System.out.println("Dime la medida del lado 3");
			lado3 = teclado.nextDouble();

			if (lado3 <= 0) {
				System.out.println("La medida del lado 3 es incorrecta por favor repite el número");
			}
		} while (lado3 <= 0);

		if (lado1 == lado2 && lado1 == lado3 && lado2 == lado3) {
			System.out.println("El triángulo es equilátero");
		} else if (lado1 != lado2 && lado1 != lado3 && lado2 != lado3) {
			System.out.println("El triángulo es escaleno");
		} else
			System.out.println("El triángulo es isósceles");

	}
}

