package LecturaEscritura;

import java.io.*;
import java.util.Scanner;

public class W_ejercicio2 {

	static Scanner teclado = new Scanner(System.in);

	private static void escribirArchivo(String ruta) {

		boolean fin = false;
		String frase;

		try {
			BufferedWriter bf = new BufferedWriter(new FileWriter(ruta, true));

			while (!fin) {

				System.out.println("Dime una frase");
				frase = teclado.nextLine();
				if (frase.equalsIgnoreCase("fin"))
					fin = true;
				else {
					bf.write(frase);
					bf.newLine();
				}
			}
			bf.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		escribirArchivo("src/LecturaEscritura/W_Ejercicio2.txt");

	}

}
