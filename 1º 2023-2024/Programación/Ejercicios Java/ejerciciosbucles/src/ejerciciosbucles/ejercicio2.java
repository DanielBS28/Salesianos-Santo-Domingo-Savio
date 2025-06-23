package ejerciciosbucles;

import java.util.Scanner;

public class ejercicio2 {

	public static void main(String[] args) {
		
	Scanner teclado = new Scanner(System.in);
	int numero;
	int numeroAux;
	boolean condicion = false;
	
	System.out.println("Te voy a pedir dos números, si los dos números son iguales hemos terminado el programa");

	do {
		System.out.println("Dime el número 1");
		numero = teclado.nextInt();
		numeroAux = numero;
		System.out.println("Dime el otro número");
		numero = teclado.nextInt();
		if (numero == numeroAux) {
			System.out.println("Los números son iguales hemos acabado");
			condicion = true;
		} else
			System.out.println("Los números no son iguales por favor repite el proceso");
		
	}while (condicion == false);
	
	}
}
