import java.util.Scanner;

public class ejercicio {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int nveces;
		int introducido;
		boolean esmenor20 = false;

		System.out.println("Introduce un número y repetir ese número tantas veces");
		nveces = teclado.nextInt();

		// tenemos que mirar si se han metido todos los números.
		// Además a de cumplirse que no encuentro número menor o igual que 20

		int i = 0;
		// !esmenorigual20 es lo mismo que es menorigual20==false
		while (i < nveces && !esmenor20) {
			System.out.println("Introduce un número: ");
			introducido = teclado.nextInt();
			if (introducido < 20)
				esmenor20 = true;
			i++;
		}
		System.out.println("FIN");
		teclado.close();
	}
}
