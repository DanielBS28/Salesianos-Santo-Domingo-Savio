package ejercicioalumnos;

import java.util.Scanner;

public class ejercicioalumnos {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		int numeroalumnos;
		double precio = 0;
		double preciototal;
		double costefijo = 0; 

		do {
			System.out.println("Dime el número de alumnos que van a asistir al viaje");
			numeroalumnos = teclado.nextInt();

			if (numeroalumnos > 100) {
				precio = 65;
			}

			else if (numeroalumnos >= 50 && numeroalumnos <= 99) {
				precio = 70;
			
			} else if (numeroalumnos >= 30 && numeroalumnos <= 49) {
				precio = 95;
				
			} else if (numeroalumnos >= 1 && numeroalumnos <= 29) {
				precio = 0;
				costefijo = 4000;

			} else
				System.out.println("Has introducido un número de alumnos incorrecto");

		} while (numeroalumnos <= 0);
		
		preciototal = costefijo + (numeroalumnos*precio);
		System.out.printf("El precio que debe de pagar cada alumno es: %.2f", (preciototal/numeroalumnos));
		System.out.print("€");
		System.out.println();
		System.out.printf("El preciototal del viaje es:  %.2f", preciototal);
		System.out.print("€");
		
	}

}
