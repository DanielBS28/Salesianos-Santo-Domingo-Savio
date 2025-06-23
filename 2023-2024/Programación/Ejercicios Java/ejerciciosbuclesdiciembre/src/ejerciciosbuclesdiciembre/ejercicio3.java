package ejerciciosbuclesdiciembre;

import java.util.Scanner;

public class ejercicio3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int numero, cifra, posicion, cifranumero, nuevoNumero = 0;

		System.out.println("Dime un número");
		numero = sc.nextInt();
		while (numero != 0) {
			cifra = numero % 10;
			numero = numero / 10;
			nuevoNumero = nuevoNumero * 10 + cifra;
		}

		numero = nuevoNumero;
		System.out.println("Dime la posición de la cifra que quieres que imprima en la consola");
		cifranumero = sc.nextInt();
		
		String numerocifras = Integer.toString(nuevoNumero);

		System.out.println("La cifra que se encuentra en la posición " + cifranumero + " es "+ numerocifras.charAt(cifranumero-1));
	}

}


