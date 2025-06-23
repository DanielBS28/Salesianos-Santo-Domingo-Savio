package ejercicios;

import java.util.Scanner;

public class ejercicio3 {

	public static void main(String[] args) {
		System.out.println("El nombre del cliente es Daniel");
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("¿Cuántos neumáticos has comprado?");
		int neumaticos = teclado.nextInt();
		
		if (neumaticos < 12) {
			System.out.println("El precio total de los neumáticos es 45€ x "+ neumaticos + "neumaticos = " + neumaticos * 45+"€");
		}
		else
			System.out.println("El precio total de los neumáticos es 40€ x "+ neumaticos + " neumaticos = " + neumaticos * 40 +"€");
	}
}
