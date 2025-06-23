import java.util.Scanner;

public class numero50 {

	public static void main(String[] args) {
		int numero;

		Scanner teclado = new Scanner(System.in);

		System.out.println("Dime un número");
		numero = teclado.nextInt();

		if (numero >= 0 && numero <= 50) {
			System.out.println("Tu número está entre los 50 primeros");
			if (numero == 0)
				System.out.println("Has introducido el 0");
		} else
			System.out.println("Tu número no está entre los 50 primeros");

	}
}
