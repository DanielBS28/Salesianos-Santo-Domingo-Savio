package EjerciciosBásicos;

import java.io.File;
import java.util.Scanner;

public class ListarFicherosRecursivo {

	static Scanner teclado = new Scanner(System.in);

	public static void ejercicio1() {

		System.out.println("Dime el nombre del directorio que quieras (A partir de la ruta actual)");
		String directorioSolicitado = teclado.nextLine();
		File directorio = new File(".\\" + directorioSolicitado + "\\");
		comprobarDirectorio(directorio);

	}

	public static void comprobarDirectorio(File f) {
		if (f.isDirectory()) {
			System.out.println("El archivo que has pasado es un directorio y sus archivos son:");
			nombrarArchivos2(f);
			// listFiles(f);
		} else
			System.out.println("No es un directorio");
	}

	public static void nombrarArchivos2(File directorio) { // BEA

		if (directorio == null) {
			System.out.println("No hay nada");
		} else {
			File[] ficheros = directorio.listFiles();
			for (int i = 0; i < ficheros.length; i++) {
				if (ficheros[i].isFile()) {
					System.out.println("Es un fichero " + ficheros[i].getName());
				} else if (ficheros[i].isDirectory()) {
					System.out.println("Es un directorio " + ficheros[i].getName());
					nombrarArchivos2(ficheros[i]);
				}
			}

		}
	}

	public static void listFiles(File dir) {
		// Obtener el listado de archivos y subdirectorios REALIZADO POR CHAT GPT
		File[] files = dir.listFiles();

		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				if (file.isFile()) {
					System.out.println("Archivo: " + file.getName());
				} else if (file.isDirectory()) {
					System.out.println("Directorio: " + file.getName());
					listFiles(file);
				}
			}
		}
	}

	public static void main(String[] args) {

		ejercicio1();

	}

}
