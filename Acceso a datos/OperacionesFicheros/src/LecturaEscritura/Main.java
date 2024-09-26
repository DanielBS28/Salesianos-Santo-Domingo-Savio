package LecturaEscritura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	public static void crearFichero(File fichero) {

		try {

			if (!fichero.exists()) {
				if (fichero.createNewFile())
					System.out.println("El fichero ha sido creado");
				else
					System.out.println("Fichero no ha sido creado");
			} else
				System.out.println("El fichero ya existe");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String esFichero(File fichero) {

		return fichero.exists() ? "Leyendo" : "No existe";
	}

	public static void Lectura(File fichero) {

		char[] texto = new char[100];

		try {
			FileReader salida = new FileReader(fichero);
			System.out.println("La codificación es: " + salida.getEncoding());
			salida.read(texto); // salida.read(texto,0,8);
			System.out.println("La salida es: " + recorrerArrayTexto(texto));

			salida.close();
		} catch (Exception e) {
			e.getStackTrace();

		}
	}

	public static String recorrerArrayTexto(char[] array) {

		String miString = "";

		for (char c : array)
			miString += Character.toString(c);

		return miString;

	}

	public static void LecturaBuffer(File fichero) {

		try {
			FileReader salida = new FileReader(fichero);
			BufferedReader buffer = new BufferedReader(salida);
			String texto = " ";

			// System.out.println(buffer.readLine());

			while ((texto = buffer.readLine()) != null) {
				System.out.println(texto);
			}

			/*
			 * while(texto != null) { texto = buffer.readLine(); System.out.println(texto);
			 * }
			 */

			salida.close();

		} catch (Exception e) {
			e.getStackTrace();

		}
	}
	
	public static void LecturaBuffer2(File fichero) {
	    for (int i = 0; i < 5; i++) { // Cambia 2 por el número de veces que quieras leer
	        try (BufferedReader buffer = new BufferedReader(new FileReader(fichero))) {
	            String texto;
	            while ((texto = buffer.readLine()) != null) {
	                System.out.println(texto);
	            }
	        } catch (IOException e) {
	            System.err.println("Error al leer el archivo: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	}

	public static void Escritura(String ruta) {

		try {

			FileWriter fichero = new FileWriter(ruta);
			PrintWriter pw = new PrintWriter(fichero);

			for (int i = 0; i < 10; i++) {

				pw.println("Numero "+ i);
			}
			
			fichero.close();


		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public static void Escritura2(String ruta) {
		
		try {
			
			FileWriter fichero = new FileWriter(ruta,true); // El true es para que no me sobrescriba el contenido
			BufferedWriter bw = new BufferedWriter(fichero);
			for (int i = 10; i < 30; i++) {

				bw.write("Numero "+ i +"\n");
		
			}
			bw.close();
			fichero.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		String ruta = "C:\\Users\\CFGS\\Downloads\\Ficheros\\OperacionesFicheros\\Fichero.txt";
		File fichero = new File(ruta);

		// crearFichero(fichero);

	
		  if (fichero.exists()) { 
			  System.out.println("Leyendo...");
			  // Lectura(fichero); 
			
		  }
		  else crearFichero(fichero);
		
		
		Escritura(ruta);
		Escritura2(ruta);
		LecturaBuffer(fichero);
		// Lectura(fichero);
		// LecturaBuffer2(fichero);
		
		
		

		// System.out.println(esFichero(fichero));

	}

}
