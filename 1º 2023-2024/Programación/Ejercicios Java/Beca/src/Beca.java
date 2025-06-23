import java.util.Scanner;

public class Beca {

	public static void main(String[] args) {
		int edad;
		int Ingresosanuales;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce tu edad: ");
		edad = teclado.nextInt();
		System.out.println("Introduce tus ingresos: ");
		Ingresosanuales = teclado.nextInt();
		
		if (edad>= 18 & Ingresosanuales < 15000)
			System.out.println("Enhorabuena estas becado");
		else
			System.out.println("Lo siento no tienes beca");

	}
}
