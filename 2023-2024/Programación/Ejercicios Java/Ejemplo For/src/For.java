import java.util.Scanner;

public class For {

	public static void main(String[] args) {

		int n;
		n = 3;
		int Numerointroducido;

		Scanner teclado = new Scanner(System.in);

		for (int i = 0; i < n; i++) {
			System.out.println("Introduce un número");
			Numerointroducido = teclado.nextInt();
			System.out.println("Has metido el: " + Numerointroducido);
			if (i == Numerointroducido - 1) {
				System.out.println("El último número introducido es el número " + Numerointroducido);

			}
		}
		System.out.println("FIN");
	}

}