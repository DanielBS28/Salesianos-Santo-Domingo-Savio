package ejercicioaritmetica;

import java.util.Scanner;

public class ejercicioexamen1 {

	// Calcular area de un trapecio 
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el altura 1 del trapecio");
		double altura1 = teclado.nextDouble();
		System.out.println("Introduce el altura 2 del trapecio");
		double altura2 = teclado.nextDouble();
		System.out.println("Introduce la base del trapecio");
		double base = teclado.nextDouble();
	
		double arearectangulo = (altura1 * base);
		double areatriangulo = (((altura2 - altura1)*base)/2);
		double areatrapecio = (arearectangulo + areatriangulo);
		
		System.out.printf("El area del rectangulo dentro del trapecio es %.2f",(arearectangulo));
		System.out.println("");
		System.out.printf("El area del triangulo dentro del trapecio es %.2f",areatriangulo);
		System.out.println();
		System.out.println();
		System.out.printf("El area total del trapecio es %.2f",areatrapecio);

	}

}



