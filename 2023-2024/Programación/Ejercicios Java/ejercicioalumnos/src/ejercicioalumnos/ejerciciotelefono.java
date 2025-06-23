package ejercicioalumnos;

import java.util.Scanner;

public class ejerciciotelefono {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		char dia;
		String momento;
		int minutos;
		double costo;
		double costetotal;

		do {
			System.out.println("¿Cuantos minutos ha durado la llamada?");
			minutos = teclado.nextInt();

			if (minutos < 0) {
				System.out.println("El número de minutos que has introducido es incorrecto");
			}

		} while (minutos < 0);

		do {
			System.out.println("¿La llamada se ha producido en Domingo? S/N");
			dia = teclado.next().charAt(0);
			teclado.nextLine();

			if (dia == 'N' || dia == 'n') {
				System.out.println("La llamada se ha producido un día diferente al domingo");

				do {
					System.out.println(
							"¿La llamada se ha producido por la mañana o por la tarde? Responde (mañana o tarde)");

					momento = teclado.nextLine();

					if (momento.equals("mañana")) {
						System.out.println("Es por la mañana");
						if (minutos <= 5) {
							costo = 1;
						} else if (minutos <= 8) {
							costo = 0.80;
						} else if (minutos <= 10) {
							costo = 0.70;
						} else
							costo = 0.50;

						costetotal = costo * minutos;
						System.out.printf("El precio total de tu llamada es: %.2f", (costetotal + (costetotal * 0.15)));
						System.out.print("€");

					} else if (momento.equals("tarde")) {
						System.out.println("Es por la tarde");
						if (minutos <= 5) {
							costo = 1;
						} else if (minutos <= 8) {
							costo = 0.80;
						} else if (minutos <= 10) {
							costo = 0.70;
						} else
							costo = 0.50;

						costetotal = costo * minutos;
						System.out.printf("El precio total de tu llamada es: %.2f", (costetotal + (costetotal * 0.10)));
						System.out.print("€");
					} else
						System.out.println("Repitelo");
				} while (!momento.equals("tarde") && !momento.equals("mañana"));

			} else if (dia == 'S' || dia == 's') {
				System.out.println("La llamada se ha producido en domingo");
				if (minutos <= 5) {
					costo = 1;
				} else if (minutos <= 8) {
					costo = 0.80;
				} else if (minutos <= 10) {
					costo = 0.70;
				} else
					costo = 0.50;

				costetotal = costo * minutos;
				System.out.printf("El precio total de tu llamada es: %.2f", (costetotal + (costetotal * 0.03)));
				System.out.print("€");
			} else
				System.out.println("Has elegido un caracter incorrecto por favor repitelo de nuevo");
		} while (dia != 'S' && dia != 'N' && dia != 's' && dia != 'n');
	}

}
