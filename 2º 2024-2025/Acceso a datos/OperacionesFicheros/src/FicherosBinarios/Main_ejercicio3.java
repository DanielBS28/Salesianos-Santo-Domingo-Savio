package FicherosBinarios;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_ejercicio3 {

	/*
	 * Se quiere guardar los datos de los alumnos con los atributos nombre, apellido
	 * y nota. Se debe crear una clase que se llame alumnos y que permita dar de
	 * alta alumnos, insertar notas y filtrar quienes han suspendido y quieres han
	 * aprobado.
	 */

	static Scanner teclado = new Scanner(System.in);
	static ArrayList<Alumno> ALUMNOS = new ArrayList<>();
	static String ruta = "Alumnos.bin";
	final static char SUSPENSOS = '0';
	final static char APROBADOS = '1';

	public static void main(String[] args) {

		int opcion = 0;
		do {

			System.out.println("********************************************");
			System.out.println("Selecciona la acción que deseas realizar");
			System.out.println("0- Salir");
			System.out.println("1- Dar de alta a un alumno");
			System.out.println("2- Insertar nota a un alumno");
			System.out.println("3- Mostrar los alumnos suspensos");
			System.out.println("4- Mostrar los alumnos aprobados");
			System.out.println("********************************************");

			opcion = teclado.nextInt();
			teclado.nextLine();

			if (opcion == 0)
				System.out.println("Saliste del programa, ¡Hasta pronto!");
			else if (opcion == 1)
				altaAlumnos();
			else if (opcion == 2)
				insertarNotaAlumnos();
			else if (opcion == 3)
				mostrarAlumnos(SUSPENSOS);
			else if (opcion == 4)
				mostrarAlumnos(APROBADOS);
			else
				System.out.println("Opción no reconocida, por favor vuelve a intentarlo");

		} while (opcion != 0);

	}

	static void escribirArray() {

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(ruta)));

			oos.writeObject(ALUMNOS);
			
			oos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void mostrarAlumnos(char BANDERA) {
		
		escribirArray();

		ArrayList<Alumno> Alumnos = new ArrayList<>();

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(ruta)));

			Alumnos = (ArrayList<Alumno>) ois.readObject();
			
			ois.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		if (Alumnos.isEmpty()) {
			System.out.println("No hay alumnos para visualizar notas");
			return;
		}

		for (Alumno a : Alumnos)
			if (BANDERA == APROBADOS) {
				if (a.getNota() >= 5)
					System.out.println(a);
			} else {
				if (a.getNota() < 5)
					System.out.println(a);
			}

	}

	static String pedirNombre() {

		System.out.println("Dime el nombre del alumno");
		return teclado.nextLine();
	}

	static String pedirApellido() {

		System.out.println("Dime el apellido del alumno");
		return teclado.nextLine();
	}

	static void insertarNotaAlumnos() {

		if (ALUMNOS.isEmpty()) {
			System.out.println("No hay alumnos para insertar notas");
			return;
		}

		System.out.println("Vamos a identificar al alumno");
		String nombre = pedirNombre();
		String apellido = pedirApellido();

		for (Alumno a : ALUMNOS) {
			if (a.getNombre().equals(nombre) && a.getApellido().equals(apellido)) {
				a.setNota();
				return;
			}
		}
		System.out.println("Alumno no reconocido");
	}

	static void altaAlumnos() {

		System.out.println("Vamos a registrar a un alumno");
		String nombre = pedirNombre();
		String apellido = pedirApellido();

		ALUMNOS.add(new Alumno(nombre, apellido));

	}

}
