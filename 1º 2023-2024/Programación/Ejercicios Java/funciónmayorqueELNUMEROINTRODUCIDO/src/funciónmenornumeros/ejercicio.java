package funciónmenornumeros;

import java.util.Scanner;

public class ejercicio {

	static boolean mayor(int num1, int num2) {
		boolean res = false;
		int contador;
		if (num1 > num2)
			res = true;
		return res;
		if (res = true)
			contador = contador +1;
	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int nIN;
		int nIN2;
		int contador;

		System.out.println("Dime un número para compararlo con otro número");
		nIN = teclado.nextInt();
		System.out.println("Dime el otro número");
		nIN2 = teclado.nextInt();
		boolean Numeromayor = mayor(nIN, nIN2);

		
	}

}
