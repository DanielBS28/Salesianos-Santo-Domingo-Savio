package ejerciciosrepaso;

import java.util.Scanner;

public class ejercicio1 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numero;
		do {
			System.out.println("Dime un número pararemos cuando sea divisible entre 7 y mayor que 30");
			numero = teclado.nextInt();
			
		} while (numero % 7 != 0 || numero <= 30);
 
	}

}
