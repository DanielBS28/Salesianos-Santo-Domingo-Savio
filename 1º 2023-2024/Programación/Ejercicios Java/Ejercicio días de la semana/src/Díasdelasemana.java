import java.util.Scanner;

public class Díasdelasemana {

	public static void main(String[] args) {
		int numSemana;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un número del 1 al 7");
		numSemana = teclado.nextInt();
		if (numSemana ==1 ) {
			System.out.println("Es Lunes");
		} else if (numSemana == 2) {
			System.out.println("Es Martes");
		} else if (numSemana == 3) {
			System.out.println("Es Miercoles");
		} else if (numSemana == 4) {
			System.out.println("Es Jueves");
		} else if (numSemana == 5) {
			System.out.println("Es Viernes");
		} else if (numSemana == 6) {
			System.out.println("Es Sabado");
		} else if (numSemana == 7) {
			System.out.println("Es Domingo");
		} else { System.out.println("No has introducido un número de día valido");
		}
	
	}

}
