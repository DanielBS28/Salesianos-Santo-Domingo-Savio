package LecturaEscritura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class L_ejercicio5 {

	static Scanner teclado = new Scanner(System.in);

	static void crearFichero(String nombreArchivo) {

		File archivo = new File(nombreArchivo);
		File planetas = new File("planetas.txt");

		if (!archivo.exists()) {
			try {
				if (archivo.createNewFile())
					System.out.println("Se ha creado el archivo");

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else
			System.out.println("El archivo ya existe");

		ordenarPlanetas(planetas);

	}

	static void ordenarPlanetas(File archivo) {

		try {
			BufferedReader lectura = new BufferedReader(new FileReader(archivo));
			ArrayList <String> Planetas = new ArrayList<>();
			String linea;
			
			while((linea = lectura.readLine()) != null) {
				Planetas.add(linea);
			}
			
			Planetas.sort(null);
			
			System.out.println(Planetas);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void ejercicio5() {

		System.out.println("Dime el nombre del archivo que quieres crear");
		String nombreArchivo = teclado.nextLine();
		nombreArchivo += ".txt";
		crearFichero(nombreArchivo);

	}

	public static void main(String[] args) {

		ejercicio5();

	}

}
