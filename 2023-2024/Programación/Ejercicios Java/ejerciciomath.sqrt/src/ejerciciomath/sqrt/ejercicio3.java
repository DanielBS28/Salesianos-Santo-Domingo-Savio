package ejerciciomath.sqrt;

import java.util.Scanner;

public class ejercicio3 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		int num = teclado.nextInt();
		String numString = String.valueOf(num);

		for (int i = 0; i < numString.length(); i++) {
			System.out.println(numString.charAt(i));
		}
	}
}
