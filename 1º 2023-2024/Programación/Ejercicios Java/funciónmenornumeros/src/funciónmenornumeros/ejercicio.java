package funciónmenornumeros;

import java.util.Scanner;


public class ejercicio {
	

static int mayor2 (int num1, int num2) {
	int res;
	if (num1 > num2)
		res = num1;
	else
		res = num2;
	return res;
}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		int n1;
		int n2;

		System.out.println("Introduce un número");
		n1 = teclado.nextInt();
		System.out.println("Introduce un segundo número");
		n2 = teclado.nextInt();
		System.out.println("El número mayor es " + mayor2(n1,n2));
	}

}
