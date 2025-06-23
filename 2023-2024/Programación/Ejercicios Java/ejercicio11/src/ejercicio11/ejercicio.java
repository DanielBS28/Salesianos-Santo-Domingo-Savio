package ejercicio11;

import java.util.Scanner;

public class ejercicio {

	public static void main(String[] args) {
		String nombre;
		String apellido;
		String DNI;
		int edad;
		String ciclo;
		char grupo;
		boolean becado;

		int contDAM;
		int mayor20;
		int nbecados;
		int nbecadosDAM;
		int apellidoporp;

		Scanner teclado = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			System.out.println("Dime el nombre del alumno");
			nombre = teclado.nextLine();
			System.out.println("Dime el apellido del alumno");
			apellido = teclado.nextLine();
			System.out.println("Dime el DNI del alumno");
			DNI = teclado.nextLine();
			System.out.println("Dime la edad del alumno");
			edad = teclado.nextInt();
			System.out.println("Dime el ciclo del alumno");
			ciclo = teclado.nextLine();
			teclado.nextLine();
		}
	}

}
