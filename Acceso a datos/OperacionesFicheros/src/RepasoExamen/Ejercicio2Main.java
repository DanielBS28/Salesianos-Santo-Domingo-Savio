package RepasoExamen;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Ejercicio2Main {

	final static char TODOSLOSCOCHES = '1';
	final static char MARCA = '2';
	final static char MODELO = '3';
	final static char COLOR = '4';

	static Scanner teclado = new Scanner(System.in);
	static String rutaCoches = "src/RepasoExamen/Coches.bin";
	static String rutaVentas = "src/RepasoExamen/Ventas.bin";
	static ArrayList<Coche> COCHES = new ArrayList<>();
	static ArrayList<Coche> CochesAux = new ArrayList<>();
	static ArrayList<Venta> VENTAS = new ArrayList<>();

	private static void rellenarCochesIniciales() {

		Coche Audi = new Coche("1", "A8", "Audi", "Negro");
		COCHES.add(Audi);
		Coche Suzuki = new Coche("2", "Jimny", "Suzuki", "Blanco");
		COCHES.add(Suzuki);
		Coche Seat = new Coche("3", "Ibiza", "Seat", "Rojo");
		COCHES.add(Seat);
		Coche Fiat = new Coche("4", "Panda", "Fiat", "Azul");
		COCHES.add(Fiat);

		escribirCoches();
	}

	private static void escribirCoches() {

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaCoches));

			oos.writeObject(COCHES);
			oos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void filtrarMarca(ArrayList<Coche> marca) {

		System.out.println("Dime la marca del coche");
		String marcaCoche = teclado.nextLine();
		for (Coche c : marca)
			if (c.getMarca().equals(marcaCoche))
				System.out.println(c);

	}

	private static void filtrarModelo(ArrayList<Coche> modelo) {

		System.out.println("Dime el modelo del coche");
		String modeloCoche = teclado.nextLine();
		for (Coche c : modelo)
			if (c.getModelo().equals(modeloCoche))
				System.out.println(c);

	}

	private static void filtrarColor(ArrayList<Coche> color) {

		System.out.println("Dime el color del coche");
		String colorCoche = teclado.nextLine();
		for (Coche c : color)
			if (c.getColor().equals(colorCoche))
				System.out.println(c);

	}

	private static void AgregarCoche() {

		System.out.println("Vamos a agregar un coche");
		System.out.println("Dime el ID del coche");
		String ID = teclado.nextLine();
		System.out.println("Dime la marca del coche");
		String marcaCoche = teclado.nextLine();
		System.out.println("Dime el modelo del coche");
		String modeloCoche = teclado.nextLine();
		System.out.println("Dime el color del coche");
		String colorCoche = teclado.nextLine();

		COCHES.add(new Coche(ID, modeloCoche, marcaCoche, colorCoche));
		escribirCoches();
	}

	private static void venderCoche() {

		System.out.println("Vamos a vender un coche");
		System.out.println("Dime el ID del coche");
		String ID = teclado.nextLine();
		System.out.println("Introduza el nombre del comprador");
		String comprador = teclado.nextLine();
		Coche CocheVendido = buscarCoche(ID);

		VENTAS.add(new Venta(CocheVendido.getID(), comprador));
		CocheVendido.setVendido(true);

		escribirVentas();

	}

	private static void escribirVentas() {

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaVentas));

			oos.writeObject(VENTAS);
			oos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static Coche buscarCoche(String ID) {

		Coche coche = null;

		for (Coche c : COCHES)
			if (c.getID().equals(ID))
				return c;

		return coche;
	}

	private static void visualizarVentas() {

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaVentas));
			ArrayList<Venta> ventas = new ArrayList<>();

			ventas = (ArrayList<Venta>) ois.readObject();

			for (Venta v : ventas)
				System.out.println(v);

			ois.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void mostrarMenuPrincipal() {

		int opcion = 0;

		System.out.println("BIENVENID@ A LA APLICACIÓN DE DANIEL");

		do {

			System.out.println("Seleccione una opción");
			System.out.println("0- Finalizar el programa");
			System.out.println("1- Mostrar todos los coches");
			System.out.println("2- Mostrar coches por marca");
			System.out.println("3- Mostrar coches por modelo");
			System.out.println("4- Mostrar coches por color");
			System.out.println("5- Agregar un coche");
			System.out.println("6- Vender un coche");
			System.out.println("7- Visualizar ventas");

			opcion = teclado.nextInt();
			teclado.nextLine();

			if (opcion == 0) {
				System.out.println("Saliendo de la aplicación...");
				System.out.println("Saliste de la aplicación");
			} else if (opcion == 1)
				lecturaCoches(TODOSLOSCOCHES);
			else if (opcion == 2)
				lecturaCoches(MARCA);
			else if (opcion == 3)
				lecturaCoches(MODELO);
			else if (opcion == 4)
				lecturaCoches(COLOR);
			else if (opcion == 5) {
				AgregarCoche();
				escribirCoches();
			} else if (opcion == 6)
				venderCoche();
			else if (opcion == 7)
				visualizarVentas();
			else
				System.out.println("Opción no reconocida");

		} while (opcion != 0);

	}

	private static void todosLosCoches(ArrayList<Coche> cochesSeleccionados) {

		for (Coche c : cochesSeleccionados)
			System.out.println(c);
	}

	private static void lecturaCoches(char Flag) {

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaCoches));
			ArrayList<Coche> cochesSeleccionados = new ArrayList<>();

			cochesSeleccionados = (ArrayList<Coche>) ois.readObject();

			if (Flag == TODOSLOSCOCHES)
				todosLosCoches(cochesSeleccionados);
			else if (Flag == MARCA)
				filtrarMarca(cochesSeleccionados);
			else if (Flag == MODELO)
				filtrarModelo(cochesSeleccionados);
			else if (Flag == COLOR)
				filtrarColor(cochesSeleccionados);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		rellenarCochesIniciales();
		mostrarMenuPrincipal();

	}

}
