import java.util.Scanner;

public class dieznumeros {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numero;
		int i = 0;
		boolean esImpar = false;

		while (i < 10 && !esImpar) {
			System.out.println("Introduce un número");
			numero = teclado.nextInt();
			if (numero % 2 != 0)
				esImpar = true;
			i++;
		}
		if (esImpar)
			System.out.println("Has introducido un número impar");
		else
			System.out.println("Todos los números introducidos son pares");
	}

}
