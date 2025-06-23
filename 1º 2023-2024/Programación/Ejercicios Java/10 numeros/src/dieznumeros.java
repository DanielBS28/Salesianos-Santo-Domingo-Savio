import java.util.Scanner;

public class dieznumeros {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numero;
		boolean esImpar = false;

		for (int i = 0; i < 10; i++) {
			System.out.println("Introduce un número");
			numero = teclado.nextInt();
			if (numero % 2 != 0)
				esImpar = true;
		}
		if (esImpar)
			System.out.println("Has introducido un número impar");
		else
			System.out.println("Todos los números introducidos son pares");
	}

}
