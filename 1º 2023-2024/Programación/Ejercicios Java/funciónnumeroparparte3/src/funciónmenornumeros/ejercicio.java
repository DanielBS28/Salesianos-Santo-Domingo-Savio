package funciónmenornumeros;

import java.util.Scanner;

public class ejercicio {

	static boolean par(int num1) {
		boolean res = false;
		if (num1 % 2 == 0)
			res = true;
		return res;
	}
	
	static void imprimirMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	
	static int leernumero() {
		int res;
		Scanner teclado = new Scanner(System.in);
		res = teclado.nextInt();
		return res;
	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		int n1;
		boolean esNumeroPar;

		System.out.println("Introduce un número");
		n1 = leernumero();
	
		esNumeroPar = par(n1);
		if (esNumeroPar)
			//System.out.println("El número es par");
			imprimirMensaje("El número que has introducido es par");
		else
			//System.out.println("El número es impar");
			imprimirMensaje("El número que has introducido es impar");
	}

}
