package FicherosAccesoAleatorio;

import java.io.*;

public class Explicación_en_clase {

	public static void EscrituraFicheroAleatorio(String fichero, String cadena, RandomAccessFile raf) {

		try {
			raf = new RandomAccessFile(fichero, "rw");

			// Tamaño del fichero
			long size = raf.length();
			// Me posiciono en el fichero con seek
			raf.seek(size);
			raf.writeBytes(cadena);
			System.out.println("Se ha escrito en el fichero");
			raf.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error: no se ha encontrado el fichero");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("Error: en la lectura y escritura del fichero");
			System.out.println(e.getMessage());
		}

	}

	public static void LecturaFicheroAleatorio(long posicion, String nombreFichero) {

		String resultado = "";

		try (RandomAccessFile raf = new RandomAccessFile(nombreFichero, "r")) {

			raf.seek(posicion);
			byte[] bytes = new byte[(int) raf.length()];
			raf.readFully(bytes);

			resultado = new String(bytes).trim();

			System.out.println(resultado);

			raf.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		String nombreFichero = "FicheroAccesoAleatorio.txt";
		String cadena = "Esto es una prueba de escritura\n";
		RandomAccessFile raf = null;

		EscrituraFicheroAleatorio(nombreFichero, cadena, raf);
		LecturaFicheroAleatorio(0, nombreFichero);

	}

}
