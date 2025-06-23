package EjerciciosDíaExcursión16Octubre;

import java.io.*;
import java.util.Arrays;

public class SoluciónEJ1Bea {

	private static String[][] leerVentas(String nombreFichero, String[][] datos) {

		String linea = "";
		try {

			BufferedReader bf = new BufferedReader(new FileReader(new File(nombreFichero)));

			while ((linea = bf.readLine()) != null) {

				String[] partesLinea = linea.split(",");

				int indice = 0;
				boolean Encontrado = false;

				// while(datos[indice] != null && !Encontrado)
				while (indice < datos.length && !Encontrado) {

					if (datos[indice][0].equals(partesLinea[0]))
						Encontrado = true;
					else
						indice++;
				}

				if (Encontrado) {
					// Ya existe el producto por que el indice apunta a su posición ------------>
					int cantidad = Integer.parseInt(datos[indice][1] + Integer.parseInt(partesLinea[1]));
					datos[indice][1] = String.valueOf(cantidad);
				} else {

					// Añadiremos el elemento
					datos[datos.length][0] = partesLinea[0];
					datos[datos.length][0] = partesLinea[1];
					// Indice
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return datos;

	}

	public static void visualizarDatos(String[][] datos) {
		for (String[] d : datos)
			for (String columna : d)
				System.out.println(Arrays.toString(d));

	}

	public static void main(String[] args) {

		String[][] datos = new String[100][2]; // Max 100 productos

		String ruta = "src/EjerciciosDíaExcursión16Octubre/ejercicio1.txt";
		String[][] datos2 = leerVentas(ruta, datos);
		visualizarDatos(datos2);
		/*
		 * for(String [] d : datos) for(String columna : d)
		 * System.out.println(Arrays.toString(d));
		 */
	}

}
