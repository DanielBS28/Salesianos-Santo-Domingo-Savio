package notas;

import java.util.Scanner;

public class notas {

	public static void main(String[] args) {
		double nota;

		Scanner teclado = new Scanner(System.in);
		do {
			System.out.println("Dime tu nota");
			nota = teclado.nextDouble();
			if ((nota < 0) || (nota > 10)) {
				System.out.println("Tu nota es erronea por favor repite el proceso");
			}
		} while ((nota < 0) || (nota > 10));

		if (nota < 5) {
			System.out.println("Suspenso");
		} else if (nota < 6) {
			System.out.println("Aprobado");
		} else if (nota < 7) {
			System.out.println("Bien");
		} else if (nota < 9) {
			System.out.println("Notable");
		} else if (nota < 10) {
			System.out.println("Sobresaliente");
		} else
			System.out.println("Matrícula de honor");
	}
}
