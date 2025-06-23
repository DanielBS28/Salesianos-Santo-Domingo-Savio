package ejercicios;

import java.util.Scanner;

public class ejercicio1 {

	public static void main(String[] args) {
		double nota1;
		double nota2;
		double nota3;
		double nota4;
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce la nota 1 ");
		nota1 = teclado.nextInt();
		System.out.println("Introduce la nota 2 ");
		nota2 = teclado.nextInt();
		System.out.println("Introduce la nota 3 ");
		nota3 = teclado.nextInt();
		System.out.println("Introduce la nota 4 ");
		nota4 = teclado.nextInt();
		
		double notamedia = ((nota1 + nota2 + nota3 + nota4)/4);
		
		if (notamedia <= 4.99) {
			System.out.println("Estas suspenso");
		}
		else 
			System.out.println("Estas aprobado");
	}
}
