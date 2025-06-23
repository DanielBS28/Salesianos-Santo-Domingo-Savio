package funciónmenornumeros;

import java.util.Scanner;

public class ejercicio {

	static boolean par(int num1) {
		boolean res = false;
		if (num1 % 2 == 0)
			res = true;
		return res;
	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		int n1;
		boolean esNumeroPar;

		System.out.println("Introduce un número");
		n1 = teclado.nextInt();
		esNumeroPar = par(n1);
		if (esNumeroPar)
			System.out.println("El número es par y tú numero es el: " + n1);
		else
			System.out.println("El número es impar y tú numero es el: " + n1);
	}

}
