import java.util.Scanner;

public class Break {

	public static void main(String[] args) {
		int numSemana;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un número del 1 al 7");
		numSemana = teclado.nextInt();

		switch (numSemana) {
		case 1: {
			System.out.println("Es Lunes");
			break;
		}
		case 2: {
			System.out.println("Es Martes");
			break;
		}
		case 3: {
			System.out.println("Es Miercoles");
			break;
		}
		case 4: {
			System.out.println("Es Jueves");
			break;
		}
		case 5: {
			System.out.println("Es Viernes");
			break;
		}
		case 6: {
			System.out.println("Es Sábado");
			break;
		}
		case 7: {
			System.out.println("Es Domingo");
			break;
		}
		default: {
			System.out.println("No has introducido un número válido");
			break;
		}
		}

	}

}
