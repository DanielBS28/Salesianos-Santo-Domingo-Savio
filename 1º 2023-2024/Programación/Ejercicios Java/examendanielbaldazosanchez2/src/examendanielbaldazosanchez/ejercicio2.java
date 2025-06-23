package examendanielbaldazosanchez;

import java.util.Scanner;

public class ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);

		double n;
		double r;
		int calculoR = 1;
		double calculoN = 1;
		double calculoResta = 1;

		do {
			do {
				System.out.println("Dime la variable n (debe de ser mayor que r)");
				n = teclado.nextDouble();
				if (n <= 0) {
					System.out.println("El número debe de ser mayor que 0, por favor vuelve a introducir el número)");
				}
			} while (n <= 0);
			do {
				System.out.println("Dime la variable r (debe de ser menor que n)");
				r = teclado.nextDouble();
				if (r <= 0) {
					System.out.println("El número debe de ser mayor que 0, por favor vuelve a introducir el número)");
				}
			} while (r <= 0);
			if (n <= r) {
				System.out.println("N debe de ser mayor que R, por favor repite el proceso");
			}
		} while (n <= r);

		for (int i = 1; i <= n; i++) {
			calculoN = calculoN * i;
		}
		for (int i = 1; i <= r; i++) {
			calculoR = calculoR * i;
		}

		double resta = n - r;

		for (int i = 1; i <= resta; i++) {
			calculoResta = calculoResta * i;
		}

		System.out.println("El resultado es: " + calculoN / (calculoR * calculoResta));
	}
}

