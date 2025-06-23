package ejercicioaritmetica;

import java.util.Scanner;

public class ejercicioexamen2 {

	public static void main(String[] args) {
		// Escribir en pantalla los naturales multiplos de 3 < 50 y calcular la suma

		System.out.println();
		System.out.print("Estos son los números naturales multiplos de 3 y menores que 50: ");
		int sumatorio = 0;
		boolean numeromultiplo3 = false;
		int numero = 3;
		
		for (int i = 1; i < 50; i++) {
			
			if (i % numero == 0) {
				System.out.print(i + " ");
				numeromultiplo3 = true;{
					sumatorio = sumatorio + i;
				}
		}
		}
		System.out.println();
		System.out.println();
		System.out.println("El sumatorio de los números naturales multiplos de 3 menores que 50 es: "+ sumatorio);
	}
}
