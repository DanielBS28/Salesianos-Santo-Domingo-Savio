package FicherosBinarios;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_ejercicio2 {

	/*
	 * Se quiere guardar todos los datos de los libros de una librería los atributos
	 * que se almacenan son los siguientes título, autor y precio.Se debe crear una
	 * clase que se llame libros y que contenga los atributos mencionados. El
	 * programa debe permitir insertar libros, listar libros, ordenar los libros
	 * según su precio y filtrar por rango de precio.
	 * 
	 */

	static ArrayList<Libros> LIBROS = new ArrayList<>();
	static Scanner teclado = new Scanner(System.in);
	static String ruta = "Libros.bin";

	final static char TODOSLOSLIBROS = '0';
	final static char FILTRADORANGO = '1';

	public static void main(String[] args) {

		int opcion;

		do {
			System.out.println("******************************************");
			System.out.println("Selecciona la acción que deseas realizar:");
			System.out.println("0- SALIR");
			System.out.println("1- Añadir un libro");
			System.out.println("2- Ver todos los libros");
			System.out.println("3- Ordenar los libros por precio");
			System.out.println("4- Filtrar libros por rango de precios");
			System.out.println("******************************************");

			opcion = teclado.nextInt();
			teclado.nextLine();

			if (opcion == 0)
				System.out.println("Saliste");
			else if (opcion == 1)
				insertarLibros();
			else if (opcion == 2)
				listarLibros();
			else if (opcion == 3)
				ordenarLibrosPrecio(TODOSLOSLIBROS);
			else if (opcion == 4)
				filtrarRango();
			else
				System.out.println("Opción no reconocida, vuelve a intentarlo");

		} while (opcion != 0);

	}

	static void filtrarRango() {

		System.out.println("Dime el rango de de precios para filtrar el inicio y el fin");
		System.out.println("Dime el precio mínimo del libro");
		double inicio_ = teclado.nextDouble();
		System.out.println("Dime el precio máximo del libro");
		double final_ = teclado.nextDouble();
		ordenarLibrosPrecio(FILTRADORANGO);
		escribirLibros(ruta);
		lecturalibros(ruta, FILTRADORANGO, inicio_, final_);
	}

	static void listarLibros() {

		escribirLibros(ruta);
		lecturalibros(ruta, TODOSLOSLIBROS, 0, 0);

	}

	static void lecturalibros(String ruta, char rango, double inicio, double final_) {

		ArrayList<Libros> LibrosSeleccionados = new ArrayList<>();

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(ruta)));

			LibrosSeleccionados = (ArrayList<Libros>) ois.readObject();

		} catch (ClassNotFoundException fnfe) {
			fnfe.getStackTrace();
		} catch (IOException ioe) {
			ioe.getStackTrace();

		}

		if (rango == TODOSLOSLIBROS) {
			for (Libros l : LibrosSeleccionados)
				System.out.println(l);
		} else {
			for (Libros l : LibrosSeleccionados) {
				if (l.getPrecio() >= inicio && l.getPrecio() <= final_)
					System.out.println(l);
			}
		}
	}

	static void escribirLibros(String ruta) {

		if (LIBROS.isEmpty()) {
			System.out.println("No hay ningún libro");
			return;
		}
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(ruta)));

			oos.writeObject(LIBROS);
			// Se han guardado los libros
			oos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static void ordenarLibrosPrecio(char FLAG) {

		if (FLAG == TODOSLOSLIBROS) {
			LIBROS.sort(null);
			listarLibros();
		} else
			LIBROS.sort(null);

	}

	static void insertarLibros() {

		String titulo;
		String autor;
		double precio;

		System.out.println("Vamos a añadir un libro");
		System.out.println("Dime el titulo del libro");
		titulo = teclado.nextLine();
		System.out.println("Dime el autor del libro");
		autor = teclado.nextLine();
		System.out.println("Dime el precio del libro");
		precio = teclado.nextDouble();
		teclado.nextLine();

		LIBROS.add(new Libros(titulo, autor, precio));
		System.out.println("Libro añadido correctamente");
	}

}
