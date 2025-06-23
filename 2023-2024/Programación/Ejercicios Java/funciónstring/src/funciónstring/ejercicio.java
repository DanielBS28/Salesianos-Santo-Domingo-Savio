package funciónstring;

import java.util.Scanner;

public class ejercicio {

	static String texto(String mensaje1, String mensaje2) {
		String res;
		res = mensaje1 + (" ") + mensaje2;
		return res;

	}

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		String cadena1, cadena2;

		System.out.println("Dime una frase");
		cadena1 = teclado.nextLine();
		System.out.println("Dime otra frase");
		cadena2 = teclado.nextLine();
		String CadenasConcatenadas = texto(cadena1, cadena2);

		System.out.println("La cadena concatenada es: " + CadenasConcatenadas);

	}

}
