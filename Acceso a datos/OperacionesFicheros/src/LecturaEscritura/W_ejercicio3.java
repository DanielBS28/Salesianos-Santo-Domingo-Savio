package LecturaEscritura;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class W_ejercicio3 {

	private static void escribirArchivo(String ruta) {
		String Numeros = "";

		Scanner teclado = new Scanner(System.in);
		System.out.println("Dime el número de números aleatorios que se generarán");
		int max = teclado.nextInt();
		teclado.nextLine();
		try {
			BufferedWriter bf = new BufferedWriter(new FileWriter(ruta));

			for (int i = 1; i <= max; i++) {

				int n = generarNumero();

				if (Numeros.equals(""))
					Numeros += n;
				else
					Numeros += "," + n;

			}
			bf.write(Numeros);

			bf.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static int generarNumero() {

		Random r = new Random();

		int n = r.nextInt(1, Integer.MAX_VALUE);
		return n;
	}

	public static void main(String[] args) {

		escribirArchivo("src/LecturaEscritura/W_ejercicio3.txt");

	}

}