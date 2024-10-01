package LecturaEscritura;

import java.io.File;
import java.io.FileReader;

public class L_ejercicio2 {

	/*
	 * Crea un programa que según lo que hemos visto hoy lea un fichero y saque por
	 * pantalla el número de caracteres que tiene el fichero y el número de vocales.
	 */

	static void ejercicio2() {

		String ruta = ".\\L_ejercicio2.txt";
		File archivo = new File(ruta);
		leerArchivo(archivo);
	}

	static void leerArchivo(File archivo) {

		try {
			FileReader lectura = new FileReader(archivo);
			int caracter;
			int contador = 0;
			int contadorVocales = 0;

			while ((caracter = lectura.read()) != -1) {

				char c = (char) caracter;

				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I'
						|| c == 'O' || c == 'U')
					contadorVocales++;
				contador++;
			}
			System.out.println(
					"El archivo tiene " + contadorVocales + (contadorVocales == 1 ? " vocal" : " 			vocales")
							+ " y en total tiene " + contador + (contador == 1 ? " caracter" : " caracteres"));

			lectura.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		ejercicio2();
	}

}
