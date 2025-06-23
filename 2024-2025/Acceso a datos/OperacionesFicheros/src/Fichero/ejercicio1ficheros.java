package Fichero;

import java.io.File;
import java.util.Scanner;

public class ejercicio1ficheros {

	static Scanner teclado = new Scanner(System.in);

	public static void listarFicheros(File f) {
		File[] ficheros = f.listFiles();

		for (File files : ficheros) {
			if (files.isFile())
				System.out.println(files.getName() + " es un fichero");
			if (files.isDirectory())
				System.out.println(files.getName() + " es un directorio");

		}
	}

	public static void comprobarDirectorio(File f) {

		if (f.isDirectory())
			listarFicheros(f);
		else if (f.isFile())
			System.out.println("Es un fichero no se puede recorrer");

	}

	public static void mostrarDirectorio() {

		System.out.println("Dime el nombre del directorio que quieras listar");
		String directorioSolicitado = teclado.nextLine();
		String directorio = ".\\" + directorioSolicitado + "\\";

		File directorio1 = new File(directorio);
		// directorio1.list();

		comprobarDirectorio(directorio1);
	}

	public static void main(String[] args) {

		mostrarDirectorio();

	}

}
