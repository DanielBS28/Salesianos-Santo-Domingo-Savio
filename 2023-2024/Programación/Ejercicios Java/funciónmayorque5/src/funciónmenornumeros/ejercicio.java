package funciónmenornumeros;

import java.util.Scanner;

public class ejercicio {

	static boolean mayor(int num1, int num2) {
		boolean res = false;
		if (num1 > num2)
			res = true;
		return res;
	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int nIN;
		int nIN2;

		System.out.println("Dime un número para compararlo con otro número");
		nIN = teclado.nextInt();
		System.out.println("Dime el otro número");
		nIN2 = teclado.nextInt();
		boolean Numeromayor = mayor(nIN, nIN2);
		
		if (Numeromayor)
		System.out.println("El número " + nIN + " es mayor que el " + nIN2);
		else 
			System.out.println("El número " + nIN + " es menor que el " + nIN2);
	}

}
