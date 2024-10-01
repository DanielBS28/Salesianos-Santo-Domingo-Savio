package LecturaEscritura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class L_ejercicio3 {

	/*
	 * Dado el fichero restaurantes muestra el fichero de la siguiente forma
	 * campo:valor
	 */

	static void leerDatos(File archivo) {

		try {
			BufferedReader lectura = new BufferedReader(new FileReader(archivo));
			String linea;
			String[] campos = { "Restaurant", "Address", "City", "State", "Zipcode" };

			while ((linea = lectura.readLine()) != null) {
				String[] datos = linea.split(",");

				if (campos.length != datos.length) {
					System.out.println("Hay un error en la linea: " + linea);
					System.out.println("------------------------------");

				} else {
					for (int i = 0; i < campos.length; i++) {
						System.out.println(campos[i] + ": " + datos[i]);
					}

					System.out.println("------------------------------");
				}
			}
			lectura.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void ejercicio3() {

		String ruta = "Restaurants.csv";
		File archivo = new File(ruta);
		leerDatos(archivo);
	}

	public static void main(String[] args) {

		ejercicio3();

	}

}
