package EjerciciosBásicos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ejerciciosIniciación {

	static Scanner teclado = new Scanner(System.in);
	static int contador = 0;

	public static void existeDirectorio(File directorio) {

		if (directorio.exists()) {
			System.out.println("El directorio es valido, vamos a ver los archivos");
			nombrarArchivos2(directorio);
		} else
			System.out.println("Has introducido mal los datos del directorio o el directorio no existe");

	}

	public static void nombrarArchivos(File directorio) {

		File[] ficheros = directorio.listFiles();

		for (File f : ficheros)
			System.out.println("El nombre del archivo es: " + f.getName());

	}
	

	public static void nombrarArchivos2(File directorio) {

		// File[] ficheros = directorio.list();
		if (directorio == null) {
			System.out.println("No hay nada");
		} else {
			if (directorio.isFile()) {
				System.out.println("Es un fichero " + directorio.getName());
			}
			if (directorio.isDirectory()) {

				// nombrarArchivos2(directorio);
				File[] ficheros = directorio.listFiles();
				System.out.println("Es un directorios " + directorio.getName());
				System.out.println(ficheros.toString());

			}

		}
	}

	public static void ejercicio1() {

		System.out.println("Dime el nombre del directorio que quieras (A partir de la ruta actual)");
		String directorioSolicitado = teclado.nextLine();
		File directorio = new File(".\\" + directorioSolicitado + "\\");
		comprobarDirectorio(directorio);

		/*
		 * Estas lineas de código me permiten ver todos los archivos si introduzco una
		 * ruta absoluta System.out.
		 * println("Introduce la ruta absoluta del directorio que quieres ver"); File
		 * directorio2 = new File(teclado.nextLine()); comprobarDirectorio(directorio2);
		 */
	}

	public static void ejercicio2() {
		String fichero = ("ficheroprueba.txt");
		File documento = new File(fichero);
		crearFichero(documento);
		comprobarFichero(documento);
	}

	public static void crearFichero(File fichero) {

		try {
			if (!fichero.exists()) {
				if (fichero.createNewFile())
					System.out.println("El fichero se ha creado correctamente");
				else
					System.out.println("El fichero no se ha podido crear");
			} else
				System.out.println("El fichero ya existe");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void comprobarFichero(File fichero) {

		if (fichero.exists()) {
			System.out.println("El fichero existe, vamos a borrarlo");
			fichero.delete();
		} else
			System.out.println("El fichero no existe");
	}

	public static void ejercicio3() {

		System.out.println("Dime el nombre del directorio");
		String nombreDir = teclado.nextLine();
		System.out.println("Dime el nombre del fichero que quieres crear");
		String nombreFichero = teclado.nextLine();

		File fichero = new File(".\\" + nombreDir + "\\" + nombreFichero + ".txt");
		File directorio = new File(".\\" + nombreDir + "\\");

		crearDirectorio(directorio);
		crearFichero(fichero);

	}

	public static void crearDirectorio(File directorio) {

		if (!directorio.exists())
			if (directorio.mkdirs())
				System.out.println("Se ha creado el directorio");
			else
				System.out.println("No se ha podido crear el directorio");
		else
			System.out.println("El directorio ya existe");
	}

	public static void comprobarDirectorio(File f) {

		if (f.isDirectory()) {
			System.out.println("El archivo que has pasado es un directorio y sus archivos son:");
			nombrarArchivos2(f);
		} else
			System.out.println("No es un directorio");

	}

	public static void ejercicio4() {

		File directorio = new File(".\\Datos\\");
		comprobarDirectorio(directorio);
	}

	public static void ejercicio5() {

		File fichero = new File("FicheroPrueba.txt");

		if (!fichero.exists())
			crearFichero(fichero);

		mostrarPermisos(fichero);
	}

	public static void mostrarPermisos(File fichero) {

		String permisos = "";

		permisos += fichero.canRead() ? "r" : "_";
		permisos += fichero.canWrite() ? "w" : "_";
		permisos += fichero.canExecute() ? "x" : "_";

		System.out.println("El archivo: " + fichero.getName() + " tiene los permisos: " + permisos);

		if (permisos.equals("rwx"))
			cambiarPermisos(fichero);
		else
			System.out.println("ERROR");
	}

	public static void cambiarPermisos(File fichero) {

		System.out.println(
				"¿Quieres quitarle los permisos de lectura: introduce r, de lo contrario pulsa otra tecla cualquiera");
		String r = teclado.nextLine();
		if (r.equals("r"))
			fichero.setReadable(false);
		System.out.println(
				"¿Quieres quitarle los permisos de escritura: introduce w, de lo contrario pulsa otra tecla cualquiera");
		String w = teclado.nextLine();
		if (w.equals("w"))
			fichero.setWritable(false);
		System.out.println(
				"¿Quieres quitarle los permisos de ejecucion: introduce x, de lo contrario pulsa otra tecla cualquiera");
		String x = teclado.nextLine();
		if (x.equals("x"))
			fichero.setWritable(false);

	}

	public static void ejercicio6() {

		System.out.println("Dime el nombre del fichero que quieres crear");
		String nombreFichero = teclado.nextLine();
		File fichero = new File(nombreFichero + ".txt");
		// crearFichero(fichero);
		comprobarFicheroEjercicio6(fichero);

	}

	public static void comprobarFicheroEjercicio6(File fichero) {

		if (fichero.exists()) {
			System.out.println("El fichero: " + fichero.getName() + " tiene la ruta: " + fichero.getAbsolutePath());
		} else {
			fichero.setExecutable(false);
			fichero.setReadable(true);
			fichero.setWritable(false);
		}
	}

	public static void main(String[] args) {

		int opcion = 0;
		do {
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------");
			System.out.println(
					"Selecciona el ejercicio que quieras realizar introduce un número del 1 al 6, si quieres terminar introduce un 0");
			opcion = teclado.nextInt();
			teclado.nextLine();

			if (opcion == 1)
				/*
				 * 1. Realiza un programa que liste elementos de un directorio introducido por
				 * pantalla.
				 */
				ejercicio1();

			else if (opcion == 2)
				/*
				 * 2. Crea un programa que compruebe que existe un fichero y si existe que lo
				 * borre.
				 */
				ejercicio2();

			else if (opcion == 3)

				/*
				 * 3. Crea un programa que cree un fichero dentro de un directorio (ambos
				 * nombres son introducidos por el usuario por teclado)
				 */
				ejercicio3();
			else if (opcion == 4)

				/*
				 * 4. Crea un programa que dado un directorio (compruebe primero que es un
				 * directorio y si lo es) liste todos los ficheros y directorios que contiene.
				 */

				ejercicio4();
			else if (opcion == 5)

				/*
				 * 5. Crea un programa que dado un fichero (hay que comprobar que existe
				 * primero) compruebe los permisos que tiene y los muestre de la siguiente
				 * manera rwx o _wx (como el Linux). Si tiene todos los permisos tiene que dar
				 * la opción al usuario de cambiarlos tecleando r,w,x (las demás opciones dan
				 * error)
				 */
				ejercicio5();

			else if (opcion == 6)

				/*
				 * 6. Crea un programa que permita al usuario introducir el nombre del fichero
				 * que quiere crear, que el programa compruebe que existe, si existe muesta la
				 * ruta dónde está. Sino le cambia los permisos para solo lectura
				 */
				ejercicio6();
		} while (opcion != 0);

		System.out.println("Terminaste");
	}

}
