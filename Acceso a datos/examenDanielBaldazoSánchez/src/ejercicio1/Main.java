package ejercicio1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	final static char TODOS_LOS_ALUMNOS = '0';
	final static char ALUMNOS_PRIMERO = '1';
	final static char ALUMNOS_SEGUNDO = '2';

	static String ruta = "src/Alumnos.txt";
	static String rutaFicheroBinario = "src/Alumnos.bin";
	static Scanner teclado = new Scanner(System.in);
	static ArrayList<Alumno> ALUMNOS = new ArrayList<>();

	private static void crearFichero() {

		File fichero = new File(ruta);

		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
				System.out.println("Se he creado el fichero  de caracteres");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
			System.out.println("El fichero de caracteres ya existe");
	}

	private static void crearFicheroBinario() {

		File fichero = new File(rutaFicheroBinario);

		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
				System.out.println("Se he creado el fichero binario");

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
			System.out.println("El fichero binario ya existe");

	}

	private static void lecturaFichero() {

		String linea = "";

		try {
			BufferedReader bf = new BufferedReader(new FileReader(ruta));

			while ((linea = bf.readLine()) != null) {

				String[] campos = linea.split(",");
				ALUMNOS.add(new Alumno(campos[0], Integer.parseInt(campos[1]), Integer.parseInt(campos[2])));

			}

			bf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void escribirBinario() {

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaFicheroBinario));

			oos.writeObject(ALUMNOS);

			oos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void mostrarMenu() {

		int opcion = 0;

		System.out.println("*********************************");
		System.out.println("BIENVENIDA AL EJERCICIO 1");
		System.out.println("*********************************");

		do {

			System.out.println("Selecciona una opción");
			System.out.println("0- Salir de la aplicación");
			System.out.println("1- Mostrar todos los alumnos");
			System.out.println("2- Mostrar los alumnos de primero");
			System.out.println("3- Mostrar los alumnos de segundo");
			System.out.println("4- Mostrar la nota media de primero");
			System.out.println("5- Mostrar la nota media de segundo");
			System.out.println("6- Mostrar la nota media del ciclo entero");
			System.out.println("7- Agregar un nuevo alumno");
			System.out.println("8- Lectura del fichero Binario");

			opcion = teclado.nextInt();
			teclado.nextLine();

			if (opcion == 1) {
				mostrarAlumnos(TODOS_LOS_ALUMNOS);
			} else if (opcion == 2) {
				mostrarAlumnos(ALUMNOS_PRIMERO);
			} else if (opcion == 3) {
				mostrarAlumnos(ALUMNOS_SEGUNDO);
			} else if (opcion == 4) {
				mostrarNota(ALUMNOS_PRIMERO);
			} else if (opcion == 5) {
				mostrarNota(ALUMNOS_SEGUNDO);
			} else if (opcion == 6) {
				mostrarNota(TODOS_LOS_ALUMNOS);
			} else if (opcion == 7) {
				agregarNuevoAlumno();
			} else if (opcion == 8) {
				lecturaBinario();
			} else if (opcion == 0) {
				System.out.println("Saliste de la aplicación, ¡Hasta pronto!");
			} else
				System.out.println("Opción no reconocida");

		} while (opcion != 0);
	}

	private static void lecturaBinario() {

		ArrayList<Alumno> ArrayListSerializado = new ArrayList<>();

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaFicheroBinario));

			ArrayListSerializado = (ArrayList<Alumno>) ois.readObject();

			ois.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mostrarArraySerializado(ArrayListSerializado);
	}

	private static void mostrarArraySerializado(ArrayList<Alumno> arrayListSerializado) {

		System.out.println("ARRAY LIST SERIALIZADO");
		System.out.println("*********************************");
		for (Alumno a : arrayListSerializado)
			System.out.println(a);
		System.out.println("*********************************");

	}

	private static void agregarNuevoAlumno() {

		int curso;

		System.out.println("Vamos a agregar un nuevo Alumno");
		System.out.println("Dime su nombre");
		String nombre = teclado.nextLine();
		System.out.println("Dime su nota media");
		int notaMedia = teclado.nextInt();
		teclado.nextLine();
		do {
			System.out.println("Dime su curso 1/2");
			curso = teclado.nextInt();
			teclado.nextLine();
			if (curso != 1 && curso != 2)
				System.out.println("No has introducido un curso válido");
		} while (curso != 1 && curso != 2);

		ALUMNOS.add(new Alumno(nombre, notaMedia, curso));
		insertarEnFichero(nombre, notaMedia, curso);
		System.out.println("Se ha agregado correctamente el alumno");
		escribirBinario();

	}

	private static void insertarEnFichero(String nombre, int notaMedia, int curso) {

		try {
			BufferedWriter bf = new BufferedWriter(new FileWriter(ruta, true));

			bf.write(nombre + "," + notaMedia + "," + curso + "\n");

			bf.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void mostrarNota(char Bandera) {

		int cantidadAlummos = 0;
		int notaTotal = 0;

		String cursoString = "";

		if (Bandera == TODOS_LOS_ALUMNOS)
			cursoString = "todos los alumnos";
		else if (Bandera == ALUMNOS_PRIMERO)
			cursoString = "alumnos de primero";
		else if (Bandera == ALUMNOS_SEGUNDO)
			cursoString = "alumnos de segundo";

		System.out.println("*********************************");
		for (Alumno a : ALUMNOS) {
			if (Bandera == TODOS_LOS_ALUMNOS) {
				notaTotal += a.getNotaMedia();
				cantidadAlummos++;
			} else if (Bandera == ALUMNOS_PRIMERO) {
				if (a.getCurso() == 1) {
					notaTotal += a.getNotaMedia();
					cantidadAlummos++;
				}
			} else if (Bandera == ALUMNOS_SEGUNDO) {
				if (a.getCurso() == 2) {
					notaTotal += a.getNotaMedia();
					cantidadAlummos++;
				}
			}
		}

		int NotaMedia = notaTotal / cantidadAlummos;

		System.out.println("La nota media de los alumnos de " + cursoString +" es: " + NotaMedia);
		System.out.println("*********************************");
	}

	private static void mostrarAlumnos(char Bandera) {

		System.out.println("*********************************");
		for (Alumno a : ALUMNOS) {
			if (Bandera == TODOS_LOS_ALUMNOS)
				System.out.println(a);
			else if (Bandera == ALUMNOS_PRIMERO) {
				if (a.getCurso() == 1)
					System.out.println(a);
			} else if (Bandera == ALUMNOS_SEGUNDO) {
				if (a.getCurso() == 2)
					System.out.println(a);
			}
		}
		System.out.println("*********************************");
	}

	public static void main(String[] args) {

		crearFichero();
		crearFicheroBinario();
		lecturaFichero();
		mostrarMenu();
	}

}
