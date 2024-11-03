package JavaNIO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EjercicioXML {

	// iniciar sesion, --> seleccionar gasolinera pero filtrada filtrar por
	// ubicacion o todas las gasolineras
	// xml actualizado por cada nuevo cliente

	static ArrayList<Cliente> CLIENTES = new ArrayList<>();
	static ArrayList<Gasolinera> GASOLINERAS = new ArrayList<>();
	static ArrayList<Object> TICKETS = new ArrayList<>();

	final static Path directorioClientes = Paths.get("src/JavaNIO/Clientes");
	final static Path directorioClientesAntiguos = Paths.get("src/JavaNIO/ClientesAntiguos");
	final static Path directorioTickets = Paths.get("src/JavaNIO/Tickets");
	final static Path ficheroXML = Paths.get("src/JavaNIO/XML.txt");
	final static Path ficheroGasolineras = Paths.get("src/JavaNIO/gasolineras.bin");
	final static Path ficheroTickets = Paths.get("src/JavaNIO/tickets.bin");

	final static String NUMEROCLIENTE = "<numerodecliente>";
	final static String NOMBRE = "<Nombre>";
	final static String CALLE = "<Calle>";
	final static String CIUDAD = "<Ciudad>";
	final static String CODIGOPOSTAL = "<Codigo Postal>";
	final static String PAIS = "<Pais>";
	final static String ROL = "<Rol>";

	final static char DESPEDIDA = '0';
	final static char BIENVENIDA = '1';
	final static char TODOS_LOS_CLIENTES = '2';
	final static char UN_CLIENTE = '3';

	final static byte ERROR_INT = -1;
	final static byte NUMERO_NEGATIVO = -2;

	static Scanner teclado = new Scanner(System.in);

	public static void crearDirectorio(Path directorio) {

		if (!Files.exists(directorio)) {
			try {
				Files.createDirectory(directorio);
				System.out.println("Se ha creado el directorio en: " + directorio.toAbsolutePath());
			} catch (IOException e) {
				e.getStackTrace();
			}
		}

	}

	public static void leerArchivoXML() {

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

				else if (lineaActual.startsWith(ROL))
					campoRol = guardarDatos(lineaActual, ROL.length());

				if (campoNumeroCliente != "" && campoCiudad != "" && campoCalle != "" && campoNombre != ""
						&& campoCodigoPostal != "" && campoPais != "" && campoRol != "") {

					CLIENTES.add(new Cliente(Integer.parseInt(campoNumeroCliente), campoNombre, campoCalle, campoCiudad,
							Integer.parseInt(campoCodigoPostal), campoPais, campoRol));

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

	public static String guardarDatos(String linea, int campolength) {

		String campo = "";
		char Bandera = '<';
		boolean caracterBandera = false;
		int ComienzoPalabra = campolength;

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

	public static void crearYEscribirFichasClientes() {

		for (int i = 0; i < CLIENTES.size(); i++) {

			Path fichero = null;

			if (CLIENTES.get(i).getRol().equals("Cliente Antiguo"))
				fichero = directorioClientesAntiguos
						.resolve(String.valueOf(CLIENTES.get(i).getNumeroCliente()) + ".txt");
			else
				fichero = directorioClientes.resolve(String.valueOf(CLIENTES.get(i).getNumeroCliente()) + ".txt");

			if (!Files.exists(fichero)) {
				try {

					Files.writeString(fichero,
							"Numero de cliente: " + String.valueOf(CLIENTES.get(i).getNumeroCliente()) + "\n");
					Files.writeString(fichero, "Nombre: " + CLIENTES.get(i).getNombre() + "\n",
							StandardOpenOption.APPEND);
					Files.writeString(fichero,
							"Dirección: " + CLIENTES.get(i).getCalle() + ", " + CLIENTES.get(i).getCiudad() + ", "
									+ String.valueOf(CLIENTES.get(i).getCodigopostal()) + ", "
									+ CLIENTES.get(i).getPais() + "\n",
							StandardOpenOption.APPEND);
					System.out.println("Se ha creado el fichero: " + fichero.getFileName());

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private static void crearArchivoBinario(Path fichero) {

		if (!Files.exists(fichero)) {
			try {
				Files.createFile(fichero);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static void leerArchivoBinarioGasolineras(String ruta) {

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta));

			GASOLINERAS = (ArrayList<Gasolinera>) ois.readObject();

			ois.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static ArrayList<Object> leerArchivoBinario(String ruta) {

		ArrayList<Object> ArrayListSerializado = new ArrayList<>();

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta));

			ArrayListSerializado = (ArrayList<Object>) ois.readObject();

			ois.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ArrayListSerializado;

	}

	public static void inicializarCargaDatosAPP() {

		crearDirectorio(directorioClientes);
		crearDirectorio(directorioClientesAntiguos);
		crearDirectorio(directorioTickets);
		crearArchivoBinario(ficheroGasolineras);
		crearArchivoBinario(ficheroTickets);

		leerArchivoXML();
		crearYEscribirFichasClientes();

		// leerArchivoBinarioGasolineras("src/JavaNIO/gasolineras.bin");
		// TICKETS = leerArchivoBinario("src/JavaNIO/tickets.bin");
	}

	private static void mostrarMenuPrincipal() {

		int opcion = 0;
		int numeroUsuario = 0;

		do {
			System.out.println("BIENVENID@ A LA APLICACIÓN DE DANIEL");
			System.out.println("Seleccione una opción");
			System.out.println("0- Finalizar el programa");
			System.out.println("1- Entrar a la aplicación");

			opcion = tryCatchInt();

			if (opcion == ERROR_INT)
				System.out.println(mostrarMensajeErrorInt());
			else if (opcion == 0) {
				System.out.println("Saliendo de la aplicación...");
				System.out.println("Saliste de la aplicación, ¡Hasta pronto!");
			} else if (opcion == 1) {
				System.out.println("Introduce tú numero de usuario");
				numeroUsuario = tryCatchInt();
				login(numeroUsuario);
			} else
				System.out.println("Opción no reconocida");

		} while (opcion != 0);

	}

	private static void login(int numeroUsuario) {

		if (comprobarUsuario(numeroUsuario)) {
			Cliente ClienteOnLine = obtenerUsuario(numeroUsuario);
			if (ClienteOnLine.getRol().equals("Administrador"))
				mostrarMenuAdministrador(ClienteOnLine);
			else
				mostrarMenuNormal(ClienteOnLine);
		} else if (numeroUsuario == -1)
			System.out.println(mostrarMensajeErrorInt());
		else
			System.out.println("El usuario no existe, por favor comienza de nuevo.");
	}

	private static Cliente busquedaCliente() {

		int numeroUsuario = 0;

		numeroUsuario = tryCatchInt();

		if (comprobarUsuario(numeroUsuario)) {
			return obtenerUsuario(numeroUsuario);
		} else if (numeroUsuario == ERROR_INT) {
			System.out.println(mostrarMensajeErrorInt());
			return null;
		} else {
			System.out.println("El usuario no existe, por favor comienza de nuevo.");
			return null;
		}

	}

	private static String mostrarMensajeBienvenidaODespedida(Cliente clienteOnLine, char Bandera) {

		if (Bandera == BIENVENIDA) {
			return "¡Bienvenid@ " + clienteOnLine.getNombre() + "!" + " (Vista menú modo: "
					+ (clienteOnLine.getRol().equals("Administrador") ? "Administrador)"
							: "Sin privilegios de administrador)");
		} else
			return "Cerrando sesión... ¡Hasta pronto" + clienteOnLine.getNombre() + "!";
	}

	public static String mostrarMensajeErrorInt() {

		return "El dato que has introducido no es una entrada válida para un Int, inténtalo de nuevo.";
	}

	private static void mostrarMenuNormal(Cliente clienteOnLine) {

		System.out.println(mostrarMensajeBienvenidaODespedida(clienteOnLine, BIENVENIDA));

	}

	private static void mostrarMenuAdministrador(Cliente clienteOnLine) {

		System.out.println(mostrarMensajeBienvenidaODespedida(clienteOnLine, BIENVENIDA));

		int opcion = 0;
		Cliente clienteBuscado = null;

		do {

			System.out.println("Seleccione una opción");
			System.out.println("0- Cerrar sesión");
			System.out.println("1- Visualizar los datos de todos los clientes");
			System.out.println("2- Visualizar los datos de un cliente");

			System.out.println("3- Añadir un nuevo cliente");

			System.out.println("3- Eliminar a un cliente");
			System.out.println("5- Visualizar todas las gasolineras");
			System.out.println("6- Visualizar todas las gasolineras por ubicación");
			System.out.println("7- Mostrar las gasolineras según los precios de las gasolinas");
			System.out.println("8- Mostrar las gasolineras por precios y por ubicación");
			System.out.println("9- Añadir una gasolinera");
			System.out.println("10- Realizar repostaje (Venta generando ticket)");
			System.out.println("11- Mostrar el dinero gastado de todos los clientes");
			System.out.println("12- Mostrar el dinero gastado de un cliente en particular");

			opcion = tryCatchInt();

			if (opcion == ERROR_INT)
				System.out.println(mostrarMensajeErrorInt());
			else if (opcion == 0)
				System.out.println(mostrarMensajeBienvenidaODespedida(clienteOnLine, DESPEDIDA));
			else if (opcion == 1)
				mostrarDatosClientes(null, TODOS_LOS_CLIENTES);
			else if (opcion == 2) {
				System.out.println("Dime el número del cliente para ver sus datos");
				clienteBuscado = busquedaCliente();
				if (clienteBuscado != null)
					mostrarDatosClientes(clienteBuscado, UN_CLIENTE);
			} else if (opcion == 3)
				añadirCliente();
			else
				System.out.println("Opción no reconocida");

		} while (opcion != 0);

	}

	private static void añadirCliente() {

		int campoNumeroCliente = 0;
		int campoCodigoPostal = 0; 
		
		String campoNombre = "";
		String campoCalle = "";
		String campoCiudad = "";
		String campoPais = "";
		String campoRol = "";
		
		boolean usuarioCorrecto = false;
		boolean codigoPostalCorrecto = false;
		
		do {
			System.out.println("Dime el número del cliente");
			campoNumeroCliente = tryCatchInt();
			if (campoNumeroCliente == NUMERO_NEGATIVO || campoNumeroCliente == 0) {
				System.out.println("Debes de introducir un número de usuario mayor que cero");
			} else if (campoNumeroCliente == ERROR_INT)
				System.out.println(mostrarMensajeErrorInt());
			else if (!comprobarUsuario(campoNumeroCliente))
				usuarioCorrecto = true;
			else
				System.out.println("El cliente ya existe, debes de introducir otro número");

		} while (!usuarioCorrecto);

		System.out.println("Introduce el nombre del cliente");
		campoNombre = teclado.nextLine();
		System.out.println("Introduce la calle del cliente");
		campoCalle = teclado.nextLine();
		System.out.println("Introduce la ciudad del cliente");
		campoCiudad = teclado.nextLine();

		do {
			System.out.println("Introduce el código postal");
			campoCodigoPostal = tryCatchInt();
			
			if (campoCodigoPostal == NUMERO_NEGATIVO || campoCodigoPostal == 0) {
				System.out.println("Debes de introducir un Codigo Póstal mayor que 0");
			} else if (campoNumeroCliente == ERROR_INT)
				System.out.println(mostrarMensajeErrorInt());
			else
				codigoPostalCorrecto = true;

		} while (!codigoPostalCorrecto);
		
		do {
		System.out.println("Introduce el país del cliente");
		campoPais = teclado.nextLine();
		}while(campoPais == "");

	}

	public static void mostrarDatosClientes(Cliente cliente, char Bandera) {

		if (Bandera == TODOS_LOS_CLIENTES) {
			for (Cliente e : CLIENTES)
				System.out.println(e);
		} else if (Bandera == UN_CLIENTE)
			System.out.println(cliente);
	}

	private static int tryCatchInt() {

		int numero = 0;
		boolean entradaValida = false;

		while (!entradaValida) {
			try {
				numero = teclado.nextInt();
				teclado.nextLine();
				entradaValida = true;
				if (numero < 0) // No quiero que el usuario introduza un número negativo, en ese caso devuelvo
								// un número negativo que califico como numero negativo (es un -2)
					// Para que el programa lo interprete como opción no valida.
					return NUMERO_NEGATIVO;
			} catch (InputMismatchException e) {
				teclado.nextLine();
				return ERROR_INT; // Aquí devuelvo -1 por que quiero que sea el mensaje de error dentro del menú y
				// no en el tryCatch
				// ya que si no se provocaría aquí un bucle que quiero evitar ya que si no el
				// menú quedaría arriba en el consola
			}
		}
		return numero; // Si todo fue bien devuelvo el número introducido

	}

	private static Cliente obtenerUsuario(int numeroUsuario) {

		for (Cliente c : CLIENTES) {
			if (c.getNumeroCliente() == numeroUsuario)
				return c;
		}
		return null;
	}

	private static boolean comprobarUsuario(int numeroUsuario) {

		for (Cliente c : CLIENTES) {
			if (c.getNumeroCliente() == numeroUsuario)
				return true;
		}

		return false;
	}

	public static void main(String[] args) {

		inicializarCargaDatosAPP();
		mostrarMenuPrincipal();

	}

}
