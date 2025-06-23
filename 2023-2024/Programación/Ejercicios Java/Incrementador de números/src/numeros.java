import java.util.Scanner;

public class numeros {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int introducido;
		boolean esSi = false;
		char respuesta;

		do {
			System.out.println("Introduce un número que se incrementará una vez");
			introducido = teclado.nextInt();
			introducido = introducido + 1;
			System.out.println(introducido);
			System.out.println("¿Quieres volver a incrementar el número S/N");
			respuesta = teclado.next().charAt(0);
			if (respuesta == 'S') {
				esSi = true;
			} else if (respuesta == 'N') {

				esSi = false;
			} else
				System.out.println("Caracter erroneo");
			while (respuesta != 'S' && respuesta != 'N') {
				System.out.println("¿Quieres volver a incrementar el número S/N");
			respuesta = teclado.next().charAt(0);
				}
		} while (esSi);
		System.out.println("FIN DEL BUCLE");

	}
}
