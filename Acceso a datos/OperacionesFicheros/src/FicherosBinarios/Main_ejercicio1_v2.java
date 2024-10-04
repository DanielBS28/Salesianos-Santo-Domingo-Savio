package FicherosBinarios;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_ejercicio1_v2 {

	static Scanner teclado = new Scanner(System.in);

	public static void escribirPersonas(ArrayList<Persona> p, String ruta) {
		
		try {

			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(ruta)));
			oos.writeObject(p);
			System.out.println("Las personas han sido guardadas");

			oos.close();

		} catch (IOException e) {
			e.getStackTrace();
		}

	}

	public static ArrayList<Persona> lecturaPersonas(String ruta) {

		ArrayList<Persona> Personas = new ArrayList<>();
		try {

			ObjectInputStream ois = new ObjectInputStream(new FileInputStream((new File(ruta))));
			Personas = (ArrayList<Persona>) ois.readObject();
			ois.close();

		} catch (ClassNotFoundException fnfe) {
			fnfe.getStackTrace();
		} catch (IOException ioe) {
			ioe.getStackTrace();

		}

		return Personas;

	}

	public static void main(String[] args) {

		ArrayList<Persona> Personas = new ArrayList<>();
		String ruta = "ArrayPersonas.bin";

		System.out.println("Introduce los datos de la persona");
		int opcion = 1;

		while (opcion != 0) {
			System.out.println("Introduce el nombre de la persona");
			String nombre = teclado.nextLine();
			System.out.println("Introduce la edad de la persona");
			int edad = teclado.nextInt();
			Personas.add(new Persona(nombre, edad));
			System.out.println("¿Quieres continuar?, pulsa 0 en caso de que no y cualquier otro número para continuar");
			opcion = teclado.nextInt();
			teclado.nextLine();
		}

		escribirPersonas(Personas, ruta);
		ArrayList<Persona> personasLeidas = lecturaPersonas(ruta);

		for (Persona p : personasLeidas) {
			System.out.println(p);
		}

		teclado.close();
	}

}
