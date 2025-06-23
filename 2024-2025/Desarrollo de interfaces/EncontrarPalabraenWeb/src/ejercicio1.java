import java.io.BufferedReader;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ejercicio1 {

	public static void main(String[] args) throws IOException {

		String direccionString = "https://www.ingles.com/traductor/";

		System.out.println("Dime una palabra en español para traducirla");
		Scanner teclado = new Scanner(System.in);
		String palabra = teclado.nextLine();
		direccionString += palabra;

		URL direccion = new URL(direccionString);
		String html = obtenerHTML(direccion);

		// System.out.println(html);
		// buscarHtml(html);

		buscarHtmlpro(html);

	}

	private static void buscarHtmlpro(String html) {

		String id = "\"MhZ0VHvJ\">";
		char bandera = '<';
		boolean caracterBandera = false;

		int inicio = html.indexOf(id);
		String resultado = html.substring(inicio + id.length());
		String palabra = "";

		for (int i = 0; !caracterBandera; i++) {

			if (resultado.charAt(i) == bandera)
				caracterBandera = true;
			else
				palabra += resultado.charAt(i);
		}

		System.out.println(palabra.toUpperCase());
	}

	/*
	 * private static void buscarHtml(String html) {
	 * 
	 * String palabra =
	 * "<a href=\"/traductor/dog?langFrom=en\" class=\"MhZ0VHvJ\">";
	 * 
	 * int inicio = html.indexOf(palabra);
	 * 
	 * String resultado = html.substring(inicio+54, inicio+57); String resultado2 =
	 * html.substring(inicio+palabra.length(), inicio+palabra.length()+3);
	 * 
	 * 
	 * System.out.println(resultado); System.out.println(resultado2);
	 * 
	 * 
	 * }
	 */
	private static String obtenerHTML(URL direccion) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(direccion.openStream()));
		String inputline, codigo = "";

		while ((inputline = in.readLine()) != null) {

			codigo += inputline;
		}

		in.close();

		return codigo;
	}

}
