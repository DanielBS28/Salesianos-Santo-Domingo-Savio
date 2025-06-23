package ejerciciorepetirnumeros;

import java.util.Scanner;

public class repetirnumeros {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numero1;
		int numero2;

		do {
			
			System.out.println("Introduce un número");
			numero1 = teclado.nextInt();
			System.out.println("Introduce otro número");
			numero2 = teclado.nextInt();
			if (numero1 != numero2) {
                System.out.println("Los números no son iguales. Por favor, repite el proceso.");
            }

		} while (numero1 != numero2);
		System.out.println("FIN DEL BUCLE");
	}

}
