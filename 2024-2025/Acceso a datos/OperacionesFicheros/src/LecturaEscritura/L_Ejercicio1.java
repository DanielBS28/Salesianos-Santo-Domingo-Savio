package LecturaEscritura;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class L_Ejercicio1 {

	/*
	 * 1. Crea un fichero de texto con el nombre y contenido que tu quieras,
	 * editarlo a mano. Ahora crea una aplicación que lea este fichero de texto
	 * carácter a carácter y muestre su contenido por pantalla sin espacios
	 */

	static void leerArchivo(File f) {

		try {
			FileReader salida = new FileReader(f);
			char[] texto = new char[(int) f.length()]; // Es el tamaño del archivo en bytes, cada caracter ocupa 1 byte
			salida.read(texto); // Lee hasta texto.length que es el tamaño de archivo (PUEDE HABER PROBLEMAS CON
								// LA CODIFICACIÓN DIFERENTE A ASCII)
			System.out.println(recorrerArrayTexto(texto));

			salida.close();
		} catch (Exception e) {
			e.getStackTrace();

		}
	}

	public static String recorrerArrayTexto(char[] array) {

		String miString = "";

		for (char c : array)
			if (c != ' ')
				miString += Character.toString(c);

		return miString;

	}

	/*
	 * public static void leerArchivoSinEspacios(File archivo) { try { FileReader
	 * lector = new FileReader(archivo); int caracter; // Esto será el caracter
	 * unicode dentro del while
	 * 
	 * // Leemos carácter a carácter while ((caracter = lector.read()) != -1) { //
	 * El -1 Indica el final del archivo (lo devuelve lector.read) char c = (char)
	 * caracter; // Convierto el caracter unicode a char
	 * 
	 * // Si el carácter no es un espacio, lo imprimimos if (c != ' ') {
	 * System.out.print(c); } }
	 * 
	 * // Cerramos el lector una vez que hemos terminado lector.close(); } catch
	 * (IOException e) { e.printStackTrace(); } }
	 * 
	 * 
	 * // OTRO EJEMPLO PERO CON READLINE
	 * 
	 * 
	 * public static void leerArchivoSinEspacios(File archivo) { try { // Usamos
	 * BufferedReader para leer línea por línea BufferedReader lector = new
	 * BufferedReader(new FileReader(archivo)); String linea;
	 * 
	 * // Leemos cada línea del archivo while ((linea = lector.readLine()) != null)
	 * { // Si devuelve null no hay mas lineas // Eliminamos los espacios de la
	 * línea y la imprimimos System.out.print(linea.replace(" ", "")); }
	 * 
	 * // Cerramos el lector lector.close(); } catch (IOException e) {
	 * e.printStackTrace(); } }
	 * 
	 */
	static void ejercicio1() {

		String ruta = ".\\ejercicio1.txt";
		File archivo = new File(ruta);
		leerArchivo(archivo);
	}

	public static void main(String[] args) {

		ejercicio1();

	}

}
