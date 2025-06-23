package ejerciciocadenaletras;

import java.util.Scanner;

public class ejercicio {

	static boolean esVocal(char caracterin) {
		boolean resultado = false;

		if (caracterin == 'a' || caracterin == 'e' || caracterin == 'i' || caracterin == 'o' || caracterin == 'u')
			resultado = true;
		return resultado;
	}

	static void escribirLetras(String cadena) {
		for (int i = 0; i < cadena.length(); i++) {
			System.out.println(cadena.charAt(i));
			

		}
	}
		
	static int ContarVocales(String cadena) {
		int resultado = 0;
		for (int i = 0; i < cadena.length(); i++) {
			if (esVocal(cadena.charAt(i)));
			resultado ++;
		}
			return resultado;
	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String cadena;
		int numvocales; 
		System.out.println("Introduce una cadena:");
		cadena = teclado.nextLine();
		ContarVocales(cadena);
		System.out.println("EL número de vocales es: ");
		numvocales = ContarVocales(cadena);
		System.out.println(numvocales);
	}

}
