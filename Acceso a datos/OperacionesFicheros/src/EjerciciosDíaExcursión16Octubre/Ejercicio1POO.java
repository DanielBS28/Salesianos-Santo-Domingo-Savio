package EjerciciosDíaExcursión16Octubre;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import EjercicioBeaLibros.Libro;

public class Ejercicio1POO {

	/*
	 * 1. Crea un programa que lea un fichero de texto que contiene registros de
	 * ventas de productos y genere un informe sobre las ventas totales, la venta
	 * promedio por producto y el producto con la mayor venta. ProductoA,200
	 * ProductoB,150 ProductoC,300 ProductoD,250 ProductoE,100
	 */

	final static String RUTA = "src/EjerciciosDíaExcursión16Octubre/ejercicio1_2.txt";
	static ArrayList<Producto> PRODUCTOS = new ArrayList<>();

	public static void leerFichero(String ruta) {

		boolean Encontrado = false;

		try {
			BufferedReader bf = new BufferedReader(new FileReader(RUTA));

			String linea = "";

			while ((linea = bf.readLine()) != null) {
				
				String [] campos = linea.split(",");

				Encontrado = false;

				for (int i = 0; i < PRODUCTOS.size(); i++) {

					if (PRODUCTOS.get(i).getNombre().equals(campos[0])) {
						PRODUCTOS.get(i).setCantidad(PRODUCTOS.get(i).getCantidad() + (Integer.valueOf(campos[1])));
						Encontrado = true;
					}
				}

				if (!Encontrado)
					PRODUCTOS.add(new Producto(campos[0], Integer.parseInt(campos[1])));

				bf.close();
			}

			exportarDatos();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static void exportarDatos() {
		int cantidad = 0;
		int productos = PRODUCTOS.size();

		Collections.sort(PRODUCTOS, Comparator.comparingInt(Producto::getCantidad));

		for (Producto p : PRODUCTOS) {
			cantidad += p.getCantidad();
		}

		imprimirDatos(cantidad, productos);
	}

	private static void imprimirDatos(int cantidad, int productos) {

		System.out.println("Se han vendido un total de " + cantidad + (cantidad == 1 ? " producto" : " productos"));
		System.out.println("El producto que mas se ha vendido a sido: " + PRODUCTOS.getLast().toString());
		System.out.println("Hay un promedio de ventas de: " + cantidad + "/" + productos + " = " + cantidad / productos);

	}

	public static void main(String[] args) {

		leerFichero(RUTA);

	}

}
