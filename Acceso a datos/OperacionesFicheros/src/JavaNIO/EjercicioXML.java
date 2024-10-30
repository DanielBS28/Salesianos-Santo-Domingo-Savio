package JavaNIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class EjercicioXML {

	static ArrayList<Cliente> CLIENTES = new ArrayList<>();

	final static String NUMEROCLIENTE = "<numerodecliente>";
	final static String NOMBRE = "<Nombre>";
	final static String CALLE = "<Calle>";
	final static String CIUDAD = "<Ciudad>";
	final static String CODIGOPOSTAL = "<Codigo Postal>";
	final static String PAIS = "<Pais>";

	public static void crearDirectorio(Path directorio) {

		if (!Files.exists(directorio)) {
			try {
				Files.createDirectory(directorio);
				System.out.println("Se ha creado el directorio en: "+ directorio.toAbsolutePath());
			} catch (IOException e) {
				e.getStackTrace();
			}
		} else
			System.out.println("El directorio ya existe en: " + directorio.toAbsolutePath());

	}

	public static void leerArchivo(Path fichero) {

		int indice = 0;
		int PunteroCampo = 0;

		String campoNumeroCliente = "";
		String campoNombre = "";
		String campoCalle = "";
		String campoCiudad = "";
		String campoCodigoPostal = "";
		String campoPais = "";

		try {
			ArrayList<String> LINEAS = (ArrayList<String>) Files.readAllLines(fichero);

			while (indice < LINEAS.size() && !LINEAS.get(indice).trim().equals("</listadeclientes>")) {

				String lineaActual = LINEAS.get(indice).trim();

				if (lineaActual.startsWith(NUMEROCLIENTE))
					campoNumeroCliente = guardarDatos(lineaActual, NUMEROCLIENTE.length());

				else if (lineaActual.startsWith(NOMBRE))
					campoNombre = guardarDatos(lineaActual, NOMBRE.length());

				else if (lineaActual.startsWith(CALLE))
					campoCalle = guardarDatos(lineaActual, CALLE.length());

				else if (lineaActual.startsWith(CIUDAD))
					campoCiudad = guardarDatos(lineaActual, CIUDAD.length());

				else if (lineaActual.startsWith(CODIGOPOSTAL))
					campoCodigoPostal = guardarDatos(lineaActual, CODIGOPOSTAL.length());

				else if (lineaActual.startsWith(PAIS))
					campoPais = guardarDatos(lineaActual, PAIS.length());

				if (campoNumeroCliente != "" && campoCiudad != "" && campoCalle != "" && campoNombre != ""
						&& campoCodigoPostal != "" && campoPais != "") {

					CLIENTES.add(new Cliente(Integer.parseInt(campoNumeroCliente), campoNombre, campoCalle, campoCiudad,
							Integer.parseInt(campoCodigoPostal), campoPais));

					campoNumeroCliente = "";
					campoNombre = "";
					campoCalle = "";
					campoCiudad = "";
					campoCodigoPostal = "";
					campoPais = "";

				}
				indice++;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String guardarDatos(String linea, int campolenght) {

		String campo = "";
		char Bandera = '<';
		boolean caracterBandera = false;
		int ComienzoPalabra = campolenght;

		while (!caracterBandera) {

			for (int i = ComienzoPalabra; !caracterBandera; i++) {

				if (linea.charAt(i) != Bandera)
					campo += linea.charAt(i);
				else
					caracterBandera = true;
			}
		}

		return campo;

	}

	public static void crearYEscribirArchivos(Path directorio) {

		for (int i = 0, j = 1; i < CLIENTES.size(); i++, j++) {

			Path fichero = directorio.resolve(String.valueOf(j) + ".txt");

			try {
				
				// StandardOpenOption.CREATE sirve para crear un archivo y que no me de error si en la primera linea que escribo
				// uso APPEND y el archivo no existe.
				// Para evitar eso tendría que poner: 
				// Files.writeString(fichero, "Numero de cliente: " + String.valueOf(CLIENTES.get(i).getNumeroCliente()) + "\n"
				//,StandardOpenOption.APPEND, StandardOpenOption.CREATE )
				//Como lo tengo ahora mismo siempre me va a sobreescribir el archivo que tenga
				Files.writeString(fichero,
						"Numero de cliente: " + String.valueOf(CLIENTES.get(i).getNumeroCliente()) + "\n");
				Files.writeString(fichero, "Nombre: " + CLIENTES.get(i).getNombre() + "\n", StandardOpenOption.APPEND);
				Files.writeString(fichero, "Calle : " + CLIENTES.get(i).getCalle() + "\n", StandardOpenOption.APPEND);
				Files.writeString(fichero, "Ciudad:  " + CLIENTES.get(i).getCiudad() + "\n", StandardOpenOption.APPEND);
				Files.writeString(fichero, "Código Postal: " + String.valueOf(CLIENTES.get(i).getCodigopostal()) + "\n",
						StandardOpenOption.APPEND);
				Files.writeString(fichero, "Pais:  " + CLIENTES.get(i).getPais() + "\n", StandardOpenOption.APPEND);

			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("Se ha creado el fichero: " + fichero.getFileName());
		}

	}

	public static void main(String[] args) {

		Path directorio = Paths.get("src/JavaNIO/Clientes");
		Path fichero = Paths.get("src/JavaNIO/XML.txt");

		crearDirectorio(directorio);
		leerArchivo(fichero);
		crearYEscribirArchivos(directorio);

	}

}
