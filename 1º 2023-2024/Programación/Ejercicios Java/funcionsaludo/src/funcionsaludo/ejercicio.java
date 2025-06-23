package funcionsaludo;

import java.util.Scanner;

public class ejercicio {

	static void saludo() {
		String nombre;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce tu nombre");
		nombre = teclado.nextLine();
		System.out.println("Buenos días " + nombre);
	}
	static String saludo2() {
		String nombre;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce tu nombre");
		nombre = teclado.nextLine();
		return nombre;
	}

	static String saludo3() {
		String nombre;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce tu nombre");
		nombre = teclado.nextLine();
		return nombre;
	}

	public static void main(String[] args) {
		String nombre = saludo2();
		System.out.println("Tu nombre es: " + nombre);
	}
}
