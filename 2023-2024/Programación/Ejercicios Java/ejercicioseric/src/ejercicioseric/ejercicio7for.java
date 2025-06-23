package ejercicioseric;

import java.util.Scanner;

public class ejercicio7for {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime un número y te diré numeros hasta que llegues a ese número empezando por 1");
		int num = sc.nextInt();
		
		for (int i = 1; i<=num; i++) {
			System.out.println(i);		
		}
	}

}
