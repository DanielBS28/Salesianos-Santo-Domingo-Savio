package EjerciciosDíaExcursión16Octubre;

import java.io.*;
import java.util.Arrays;

public class ejercicio1 {

	public static void lecturaFichero(String ruta) {

		/*
		 * 1. Crea un programa que lea un fichero de texto que contiene registros de
		 * ventas de productos y genere un informe sobre las ventas totales, la venta
		 * promedio por producto y el producto con la mayor venta. ProductoA,200
		 * ProductoB,150 ProductoC,300 ProductoD,250 ProductoE,100
		 */

		try {
			BufferedReader lector = new BufferedReader(new FileReader(new File(ruta)));

			String linea = "";
			int total = 0;
			String max[] = { "0", "0" };
			double promedio = 0;
			int productos = 0;

			while ((linea = lector.readLine()) != null) {

				String[] Array = linea.split(",");
				total += Integer.parseInt(Array[1]);

				if (Integer.parseInt(max[1]) < Integer.parseInt(Array[1]))
					max = Array;

				productos++;

			}

			promedio = total / productos;

			imprimirDatos(total, productos, promedio, max);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void imprimirDatos(int total, int productos, double promedio, String[] max) {

		System.out.println("Se han vendido en total: " + total + (productos == 1 ? "productos" : " productos"));
		System.out.println(
				"El número maximo de productos que se ha vendido es: " + max[0] + " con " + max[1] + " unidades ");
		System.out.println("El promedio de ventas de los productos es: " + total + "/" + productos + " = " + promedio);
	}

	public static void main(String[] args) {

		String ruta = "src/Ejercicio1/ejercicio1.txt";
		lecturaFichero(ruta);

	}

}
