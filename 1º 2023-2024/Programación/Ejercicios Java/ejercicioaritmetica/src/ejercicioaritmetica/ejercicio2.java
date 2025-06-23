package ejercicioaritmetica;

import java.util.Scanner;

public class ejercicio2 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el lado del rectángulo");
		double lado = teclado.nextDouble();
		System.out.println("Introduce la base del rectángulo");
		double base = teclado.nextDouble();
	
		double area = (lado * base);
		
		System.out.printf("El perimetro del rectángulo es %.2f",(base*2+ lado*2));
		System.out.println();
		System.out.printf("El area del rectángulo es %.2f",area);
		
	}
}
