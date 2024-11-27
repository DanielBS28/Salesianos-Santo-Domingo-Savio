package JavaNIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HistorialAltas {

	public static ArrayList<Cliente> HISTORIALCLIENTES = new ArrayList<>();
	static Scanner teclado = new Scanner(System.in);

	final static String NUMEROCLIENTE = "<numerodecliente>";
	final static String NOMBRE = "<Nombre>";
	final static String CALLE = "<Calle>";
	final static String CIUDAD = "<Ciudad>";
	final static String CODIGOPOSTAL = "<CodigoPostal>";
	final static String PAIS = "<Pais>";
	final static String ROL = "<Rol>";

	final static Path directorioHistorialClientes = Paths.get("src/JavaNIO/Histórico/Historial Clientes");
	final static Path directorioAltas = Paths.get("src/JavaNIO/Histórico");
	final static Path ficheroXML = Paths.get("src/JavaNIO/Histórico/AltasClientes.xml");

	public static void crearDirectorio(Path directorio) {

		if (!Files.exists(directorio)) {
			try {
				Files.createDirectory(directorio);
			} catch (IOException e) {
				e.getStackTrace();
			}
		}

	}

	private static void crearArchivo(Path fichero) {

		if (!Files.exists(fichero)) {
			try {
				Files.createFile(fichero);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static ArrayList<Cliente> todosLosClientes() {

		ArrayList<Cliente> HISTORIALCLIENTES = new ArrayList<>();

		return HISTORIALCLIENTES;
	}
	
	public static void mostrarTodosLosClientes() {
		for(Cliente c : HISTORIALCLIENTES)
			System.out.println(c);
	}

	public static void inicializarHistorialAltas() {

		crearDirectorio(directorioAltas);
		crearDirectorio(directorioHistorialClientes);
		crearArchivo(ficheroXML);

		leerXMLRol();
	}

	public static void leerXMLRol() {
		int indice = 0;

		String campoNumeroCliente = "";
		String campoNombre = "";
		String campoCalle = "";
		String campoCiudad = "";
		String campoCodigoPostal = "";
		String campoPais = "";
		String campoRol = "";

		try {
			ArrayList<String> LINEAS = (ArrayList<String>) Files.readAllLines(ficheroXML);

			while (indice < LINEAS.size() && !LINEAS.get(indice).trim().equals("</listadeclientes>")) {

				String lineaActual = LINEAS.get(indice).trim();

				if (lineaActual.startsWith(NUMEROCLIENTE))
					campoNumeroCliente = guardarDatos(lineaActual, NUMEROCLIENTE);

				else if (lineaActual.startsWith(NOMBRE))
					campoNombre = guardarDatos(lineaActual, NOMBRE);

				else if (lineaActual.startsWith(CALLE))
					campoCalle = guardarDatos(lineaActual, CALLE);

				else if (lineaActual.startsWith(CIUDAD))
					campoCiudad = guardarDatos(lineaActual, CIUDAD);

				else if (lineaActual.startsWith(CODIGOPOSTAL))
					campoCodigoPostal = guardarDatos(lineaActual, CODIGOPOSTAL);

				else if (lineaActual.startsWith(PAIS))
					campoPais = guardarDatos(lineaActual, PAIS);

				else if (lineaActual.startsWith(ROL))
					campoRol = guardarDatos(lineaActual, ROL);

				if (campoNumeroCliente != "" && campoCiudad != "" && campoCalle != "" && campoNombre != ""
						&& campoCodigoPostal != "" && campoPais != "" && campoRol != "") {

					HISTORIALCLIENTES.add(new Cliente(Integer.parseInt(campoNumeroCliente), campoNombre, campoCalle,
							campoCiudad, Integer.parseInt(campoCodigoPostal), campoPais, campoRol));

					campoNumeroCliente = "";
					campoNombre = "";
					campoCalle = "";
					campoCiudad = "";
					campoCodigoPostal = "";
					campoPais = "";
					campoRol = "";

				}
				indice++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String guardarDatos(String linea, String campoPasado) {

		String campo = "";
		String finalEtiqueta = "</" + campoPasado.substring(1);
		int ComienzoPalabra = campoPasado.length();
		int finalPalabra = linea.indexOf(finalEtiqueta);

		for (int i = ComienzoPalabra; i < finalPalabra; i++) {

			campo += linea.charAt(i);
		}

		return campo.trim();
	}

	public static void sobrescribirXML() {

		Path fichero = ficheroXML;

		try {

			Files.writeString(fichero, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			Files.writeString(fichero, "<listadeclientes>\n", StandardOpenOption.APPEND);

			for (int i = 0; i < HISTORIALCLIENTES.size(); i++) {

				Files.writeString(fichero, "\t<cliente>\n", StandardOpenOption.APPEND);
				Files.writeString(fichero,
						"\t\t" + NUMEROCLIENTE + HISTORIALCLIENTES.get(i).getNumeroCliente() + "</numerodecliente>\n",
						StandardOpenOption.APPEND);
				Files.writeString(fichero, "\t\t" + NOMBRE + HISTORIALCLIENTES.get(i).getNombre() + "</Nombre>\n",
						StandardOpenOption.APPEND);
				Files.writeString(fichero, "\t\t<Direccion>\n", StandardOpenOption.APPEND);
				Files.writeString(fichero, "\t\t\t" + CALLE + HISTORIALCLIENTES.get(i).getCalle() + "</Calle>\n",
						StandardOpenOption.APPEND);
				Files.writeString(fichero, "\t\t\t" + CIUDAD + HISTORIALCLIENTES.get(i).getCiudad() + "</Ciudad>\n",
						StandardOpenOption.APPEND);
				Files.writeString(fichero,
						"\t\t\t" + CODIGOPOSTAL + HISTORIALCLIENTES.get(i).getCodigopostal() + "</CodigoPostal>\n",
						StandardOpenOption.APPEND);
				Files.writeString(fichero, "\t\t\t" + PAIS + HISTORIALCLIENTES.get(i).getPais() + "</Pais>\n",
						StandardOpenOption.APPEND);
				Files.writeString(fichero, "\t\t</Direccion>\n", StandardOpenOption.APPEND);
				Files.writeString(fichero, "\t\t" + ROL + HISTORIALCLIENTES.get(i).getRol() + "</Rol>\n",
						StandardOpenOption.APPEND);
				Files.writeString(fichero, "\t</cliente>\n", StandardOpenOption.APPEND);

			}
			Files.writeString(fichero, "</listadeclientes>\n", StandardOpenOption.APPEND);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Se produjo un error al sobrescribir el archivo");
		}

	}

	public static Cliente obtenerAdministrador() {

		for (Cliente c : HISTORIALCLIENTES) {
			if (c.getNumeroCliente() == 1)
				return c;
		}
		return null;
	}

	public static boolean numeroClienteExistente(int NumeroCliente) {

		for (int i = 0; i < HISTORIALCLIENTES.size(); i++) {
			if (HISTORIALCLIENTES.get(i).getNumeroCliente() == NumeroCliente)
				return true;
		}
		return false;
	}

	public static Cliente busquedaCliente() {

		int numeroUsuario = 0;

		numeroUsuario = Main.tryCatchInt();

		if (numeroClienteExistente(numeroUsuario)) {
			return obtenerUsuario(numeroUsuario);
		} else if (numeroUsuario == Main.ERROR_INT) {
			System.out.println(Main.mostrarMensajeErrorInt());
			return null;
		} else {
			System.out.println("El usuario no existe.");
			return null;
		}

	}

	private static Cliente obtenerUsuario(int numeroUsuario) {

		for (Cliente c : HISTORIALCLIENTES) {
			if (c.getNumeroCliente() == numeroUsuario)
				return c;
		}
		return null;
	}

	public static int tryCatchInt() {

		int numero = 0;

		try {
			numero = teclado.nextInt();
			teclado.nextLine();
			if (numero < 0) // No quiero que el usuario introduza un número negativo, en ese caso devuelvo
							// un número negativo que califico como numero negativo (es un -2)
				// Para que el programa lo interprete como opción no valida.
				return Main.NUMERO_NEGATIVO;
		} catch (InputMismatchException e) {
			teclado.nextLine();
			return Main.ERROR_INT; // Aquí devuelvo -1 por que quiero que sea el mensaje de error dentro del menú y
			// no en el tryCatch
			// ya que si no se provocaría aquí un bucle que quiero evitar ya que si no el
			// menú quedaría arriba en el consola
		}
		return numero; // Si todo fue bien devuelvo el número introducido

	}

	public static void mostrarDatosClientes(Cliente cliente, char Bandera) {

		if (Bandera == Main.TODOS_LOS_CLIENTES) {
			for (Cliente e : HISTORIALCLIENTES)
				System.out.println(e);
		} else if (Bandera == Main.UN_CLIENTE)
			System.out.println(cliente);
	}

	public static void altaClienteFichero() {

		for (int i = 0; i < HISTORIALCLIENTES.size(); i++) {

			Path fichero = directorioHistorialClientes
					.resolve(String.valueOf(HISTORIALCLIENTES.get(i).getNumeroCliente()) + ".txt");

			if (!Files.exists(fichero)) {
				try {

					Files.writeString(fichero,
							"Numero de cliente: " + String.valueOf(HISTORIALCLIENTES.get(i).getNumeroCliente()) + "\n");
					Files.writeString(fichero, "Nombre: " + HISTORIALCLIENTES.get(i).getNombre() + "\n",
							StandardOpenOption.APPEND);
					Files.writeString(fichero,
							"Dirección: " + HISTORIALCLIENTES.get(i).getCalle() + ", "
									+ HISTORIALCLIENTES.get(i).getCiudad() + ", "
									+ String.valueOf(HISTORIALCLIENTES.get(i).getCodigopostal()) + ", "
									+ HISTORIALCLIENTES.get(i).getPais() + "\n",
							StandardOpenOption.APPEND);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
