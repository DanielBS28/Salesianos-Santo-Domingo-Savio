import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilidades {

	final static char DESPEDIDA = '0';
	final static char BIENVENIDA = '1';
	final static char EMPLEADO = '2';
	final static char CLIENTE = '3';
	
	final static int INICIAL = 0;
	final static int MAYOR_MENOR = 1;
	final static int MENOR_MAYOR = 2;
	final static int STOCK = 3;

	static Scanner teclado = new Scanner(System.in);

	public static int tryCatchInt() {

		int numero = 0;

		try {
			numero = teclado.nextInt();
			teclado.nextLine();
			if (numero < 0) // No quiero que el usuario introduza un número negativo, en ese caso devuelvo
							// un número negativo que califico como numero negativo (es un -2)
				// Para que el programa lo interprete como opción no valida.
				return Errores.NUMERO_NEGATIVO;
		} catch (InputMismatchException e) {
			teclado.nextLine();
			return Errores.ERROR_INT; // Aquí devuelvo -1 por que quiero que sea el mensaje de error dentro del menú y
			// no en el tryCatch
			// ya que si no se provocaría aquí un bucle que quiero evitar ya que si no el
			// menú quedaría arriba en el consola
		}
		return numero; // Si todo fue bien devuelvo el número introducido

	}

	public static void generarPausa() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Hubo un error en la pausa");
		}
	}

	public static String mostrarMensajeBienvenidaODespedida(String alias, String rol, char Bandera) {


		if (Bandera == BIENVENIDA) {
			return "╔═══════════════════════════════════════════════════════════╗" + "\n" + "║  ¡Bienvenid@ " + alias
					+ "!" + " (Menú: " + rol + ")\n" + "╠═══════════════════════════════════════════════════════════╣";
		} else
			return "Cerrando sesión... ¡Hasta pronto " + alias + "!";

	}
	
}
