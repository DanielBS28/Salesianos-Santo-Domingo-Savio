import java.util.Scanner;

public class Beca {

	public static void main(String[] args) {
		int edad;
		int Ingresosanuales;
		String ciudad;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce tu edad: ");
		edad = teclado.nextInt();
		System.out.println("Introduce tus ingresos: ");
		Ingresosanuales = teclado.nextInt();
		System.out.println("Introduce tu ciudad ");
		teclado.nextLine();
		ciudad = teclado.nextLine();
		
		if (edad>= 18 & Ingresosanuales < 15000 & ciudad.equals("Madrid"))
			System.out.println("Enhorabuena estas becado");
		else
			System.out.println("Lo siento no tienes beca");

	}
}
