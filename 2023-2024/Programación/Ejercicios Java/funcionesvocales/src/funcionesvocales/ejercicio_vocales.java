package funcionesvocales;

import java.util.Scanner;

public class ejercicio_vocales {

	static boolean esVocal(char caracterin) {
		boolean resultado = false;

		if (caracterin == 'a' || caracterin == 'e' || caracterin == 'i' || caracterin == 'o' || caracterin == 'u')
			resultado = true;
		return resultado;
	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		char caracter;
		System.out.println("Introduce una letra");
		caracter = teclado.next().charAt(0);
		if (esVocal(caracter))
			System.out.println("Es vocal");
		else
			System.out.println("No es vocal");

	}

}
