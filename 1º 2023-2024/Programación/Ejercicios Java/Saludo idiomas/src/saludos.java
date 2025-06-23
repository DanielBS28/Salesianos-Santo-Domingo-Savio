import java.io.Closeable;
import java.util.Scanner;

public class saludos {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numeroelegido;

		do {
			System.out.println("Introduce un número del 1 al 4 para seleccionar la opción");
			System.out.println("");
			System.out.println("1) Saludo en Español");
			System.out.println("2) Saludo en Inglés");
			System.out.println("3) Saludo en Italiano");
			System.out.println("4) Salir del bucle");
			numeroelegido = teclado.nextInt();
			if (numeroelegido == 1) {
				System.out.println("Hola que tal estás?");
				System.out.println("");
			} else if (numeroelegido == 2) {
				System.out.println("How are you?");
				System.out.println("");
			} else if (numeroelegido == 3) {
				System.out.println("Ciao...");
				System.out.println("");
			} else if (numeroelegido <= 0 || numeroelegido > 4) {
				System.out.println("No has introducido un número que he pedido, repite el proceso");
				System.out.println("");
			}
		} while (numeroelegido != 4);
		System.out.println("Hasta luego");

	}

}
