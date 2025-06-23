package ejercicios1diciembre;

import java.util.Scanner;

public class ejercicio1 {

	public static void main(String[] args) {

		int numero;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Vamos a dibujar una piramide según el número que introduzcas");

		numero = teclado.nextInt();

		for (int fila = 1; fila <= numero; fila++) {
			for (int columna = 1; columna <= numero; columna++){
				if (fila == numero || columna == numero) {
					System.out.print("*");
				
				}else 
					System.out.print(" ");
			}
			System.out.println();
		}
		
	}
}
		
	
	

