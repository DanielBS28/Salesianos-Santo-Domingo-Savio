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
		double calculoResta= 1;

		do {
			System.out.println("Dime la variable n (debe de ser mayor que r)");
			n = teclado.nextDouble();
			System.out.println("Dime la variable r (debe de ser menor que n)");
			r = teclado.nextDouble();
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
		
		System.out.println("El resultado es: " + calculoN/(calculoR*calculoResta));
}
}


