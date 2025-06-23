package ejercicios;

import java.util.Scanner;

public class ejercicio2 {

	public static void main(String[] args) {
		
		double numero1;
		double numero2;
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce la nota 1 ");
		numero1 = teclado.nextInt();
		System.out.println("Introduce la nota 2 ");
		numero2 = teclado.nextInt();
		
		double suma = (numero1 + numero2);
		double potencia = Math.pow(numero1, numero2);
		
		if (suma > 10) {
			System.out.println("La suma del número1 + numero2 es: " + suma);
		}
		else 
			System.out.println("La potencia del número 1 elevado al número 2 es: " + potencia);
		
	}
}
