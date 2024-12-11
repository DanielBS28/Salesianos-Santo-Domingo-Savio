package JavaNIO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	static ArrayList<Cliente> CLIENTES = new ArrayList<>();
	static ArrayList<Gasolinera> GASOLINERAS = new ArrayList<>();
	final static char ArrayGasolineras = 'G';
	static ArrayList<Ticket> TICKETS = new ArrayList<>();
	final static char ArrayTickets = 'T';

	final static Path directorioClientes = Paths.get("src/JavaNIO/Clientes");
	final static Path directorioClientesAntiguos = Paths.get("src/JavaNIO/ClientesAntiguos");
	final static Path directorioTickets = Paths.get("src/JavaNIO/Tickets");
	final static Path ficheroXML = Paths.get("src/JavaNIO/Clientes.xml");
	final static Path ficheroGasolineras = Paths.get("src/JavaNIO/gasolineras.bin");
	final static Path ficheroTickets = Paths.get("src/JavaNIO/Histórico/tickets.bin");

	final static String NUMEROCLIENTE = "<numerodecliente>";
	final static String NOMBRE = "<Nombre>";
	final static String CALLE = "<Calle>";
	final static String CIUDAD = "<Ciudad>";
	final static String CODIGOPOSTAL = "<Codigo Postal>";
	final static String PAIS = "<Pais>";

	final static char DESPEDIDA = '0';
	final static char BIENVENIDA = '1';
	final static char TODOS_LOS_CLIENTES = '2';
	final static char UN_CLIENTE = '3';
	final static char TODAS_LAS_GASOLINERAS = '4';
	final static char POR_UBICACION = '5';
	final static char POR_UBICACION_Y_PRECIOS = '6';
	final static char POR_PRECIOS = '7';

	final static byte ERROR_INT = -1;
	final static byte NUMERO_NEGATIVO = -2;
	final static byte ERROR_DOUBLE = -3;

	static Scanner teclado = new Scanner(System.in);

	public static void crearDirectorio(Path directorio) {

		if (!Files.exists(directorio)) {
			try {
				Files.createDirectory(directorio);
			} catch (IOException e) {
				e.getStackTrace();
			}
		}

	}

	public static void leerArchivoXML() {

		int indice = 0;

		boolean encontrado = false;
		String campoNumeroCliente = "";
		String campoNombre = "";
		String campoCalle = "";
		String campoCiudad = "";
		String campoCodigoPostal = "";
		String campoPais = "";
		String campoRol = "";
		int eleccionRol = 0;

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

				if (campoNumeroCliente != "" && campoCiudad != "" && campoCalle != "" && campoNombre != ""
						&& campoCodigoPostal != "" && campoPais != "") {

					if (clienteDuplicado(campoNumeroCliente, campoCiudad, campoCalle, campoNombre, campoCodigoPostal,
							campoPais)) {
						Cliente clienteRegistrado = obtenerClienteRegistrado(campoNumeroCliente);
						CLIENTES.add(clienteRegistrado);
						encontrado = true;
					} else if (numeroClienteExistente(campoNumeroCliente))
						System.out.println("El cliente: " + campoNombre
								+ " no se ha podido agregar, otro cliente ya existía con el número de cliente: "
								+ campoNumeroCliente);
					else {

						do {
							System.out.println(
									"El cliente: " + campoNombre + " es un nuevo registro, ¿Va a ser administrador?");
							System.out.println("1- Sí");
							System.out.println("2- No");

							eleccionRol = tryCatchInt();

						} while (!confirmarDatos1_2(eleccionRol));

						campoRol = eleccionRol == 1 ? "Administrador" : "Usuario";

						Cliente nuevoCliente = new Cliente(Integer.parseInt(campoNumeroCliente), campoNombre,
								campoCalle, campoCiudad, Integer.parseInt(campoCodigoPostal), campoPais, campoRol);
						CLIENTES.add(nuevoCliente);
						encontrado = true;
						HistorialAltas.HISTORIALCLIENTES.add(nuevoCliente);
						HistorialAltas.sobrescribirXML();

					}

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
			System.out.println("No se ha podido encontrar el archivo XML");
		}

		if (!encontrado) {
			System.out.println("NO SE HAN ENCONTRADO CLIENTES EN EL XML");
			System.out.println(mostrarMensajeCampos());
			CLIENTES.add(HistorialAltas.obtenerAdministrador());
		}
	}

	public static String mostrarMensajeCampos() {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<listadeclientes>\n" + " <cliente>\n" + "  "
				+ NUMEROCLIENTE + "12345</" + NUMEROCLIENTE.substring(1) + "\n" + "  " + NOMBRE + "Luis García</"
				+ NOMBRE.substring(1) + "\n" + "   <Direccion>\n" + "    " + CALLE + "Calle de la Princesa</"
				+ CALLE.substring(1) + "\n" + "    " + CIUDAD + "Madrid</" + CIUDAD.substring(1) + "\n" +

				"    " + CODIGOPOSTAL + "28020</" + CODIGOPOSTAL.substring(1) + "\n" + "    " + PAIS + "España</"
				+ PAIS.substring(1) + "\n" + "   </direccion>\n" + " </cliente>\n" + "</listadeclientes>\n"
				+ "Aún así puedes utilizar el usuario Super Administrador que es el usuario número 1";

	}

	private static boolean numeroClienteExistente(String campoNumeroCliente) {
		int numeroCliente = Integer.parseInt(campoNumeroCliente);

		for (int i = 0; i < HistorialAltas.HISTORIALCLIENTES.size(); i++) {
			if (HistorialAltas.HISTORIALCLIENTES.get(i).getNumeroCliente() == numeroCliente)
				return true;
		}
		return false;
	}

	private static Cliente obtenerClienteRegistrado(String campoNumeroCliente) {

		int numeroCliente = Integer.parseInt(campoNumeroCliente);
		for (int i = 0; i < HistorialAltas.HISTORIALCLIENTES.size(); i++) {
			if (HistorialAltas.HISTORIALCLIENTES.get(i).getNumeroCliente() == numeroCliente)
				return HistorialAltas.HISTORIALCLIENTES.get(i);
		}
		return null;
	}

	private static boolean clienteDuplicado(String campoNumeroCliente, String campoCiudad, String campoCalle,
			String campoNombre, String campoCodigoPostal, String campoPais) {
		for (int i = 0; i < HistorialAltas.HISTORIALCLIENTES.size(); i++) {
			Cliente p = HistorialAltas.HISTORIALCLIENTES.get(i);

			if (p.getNombre().equals(campoNombre) && p.getCiudad().equals(campoCiudad)
					&& p.getCodigopostal() == Integer.parseInt(campoCodigoPostal) && p.getPais().equals(campoPais)
					&& p.getNumeroCliente() == Integer.parseInt(campoNumeroCliente) && p.getCalle().equals(campoCalle))

				return true;
		}

		return false;
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

	public static void crearYEscribirFichasClientes() {

		for (int i = 0; i < CLIENTES.size(); i++) {

			Path fichero = null;

			if (CLIENTES.get(i).getRol().equals("Cliente antiguo"))
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

	private static void leerArchivoBinario(String ruta, char Bandera) {

		ArrayList<Gasolinera> ArrayListSerializadoG = new ArrayList<>();
		ArrayList<Ticket> ArrayListSerializadoT = new ArrayList<>();

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta));

			if (Bandera == ArrayGasolineras) {
				ArrayListSerializadoG = (ArrayList<Gasolinera>) ois.readObject();
				for (Gasolinera g : ArrayListSerializadoG)
					GASOLINERAS.add(new Gasolinera(g.getNombre(), g.getUbicacion(), g.getPrecioLitro_G95(),
							g.getPrecioLitro_Diesel(), g.getCantidadG95(), g.getCantidadDiesel()));
			} else if (Bandera == ArrayTickets) {
				ArrayListSerializadoT = (ArrayList<Ticket>) ois.readObject();
				for (Ticket t : ArrayListSerializadoT)
					TICKETS.add(new Ticket(t.getIDTicket(), t.getCliente(), t.getGasolinera(), t.getCantidadRepostada(),
							t.getEuros(), t.getTipoGasolina()));
			}

			ois.close();

		} catch (ClassNotFoundException | IOException e) {
			System.out.println("El archivo gasolineras.bin no existe, está dañado o no se ha podido leer correctamente.");
			System.out.println("Añada gasolineras para poder realizar repostajes");
		}

	}

	public static void inicializarCargaDatosAPP() {

		char Clientes = 'C';
		char ClientesAntiguos = 'A';

		eliminarDirectorio(directorioClientes, Clientes);
		eliminarDirectorio(directorioClientesAntiguos, ClientesAntiguos);
		HistorialAltas.inicializarHistorialAltas();
		crearDirectorio(directorioClientes);
		crearDirectorio(directorioClientesAntiguos);
		crearDirectorio(directorioTickets);
		crearArchivo(ficheroGasolineras);
		crearArchivo(ficheroTickets);
		crearArchivo(ficheroXML);

		leerArchivoXML();
		sobrescribirXML();
		crearYEscribirFichasClientes();
		HistorialAltas.altaClienteFichero();

		leerArchivoBinario("src/JavaNIO/gasolineras.bin", ArrayGasolineras);
		leerArchivoBinario("src/JavaNIO/Histórico/tickets.bin", ArrayTickets);
		comprobarCarpetaTickets();
	}

	private static void eliminarDirectorio(Path directorio, char Bandera) {

		if (Bandera == 'C') {
			borrarArchivos("src/JavaNIO/Clientes");
		} else if (Bandera == 'A')
			borrarArchivos("src/JavaNIO/ClientesAntiguos");

		try {
			Files.delete(directorio);
		} catch (IOException e) {
			System.out.println("No se ha encontrado el directorio");
		}
	}

	private static void borrarArchivos(String directorio) {

		File carpeta = new File(directorio);
		try {
			File[] Archivos = carpeta.listFiles();

			for (File f : Archivos)
				f.delete();
		} catch (Exception e) {
			System.out.println("No se ha encontrado el directorio para eliminar los archivos");
		}

	}

	private static void comprobarCarpetaTickets() {

		for (Ticket t : TICKETS)
			t.generarTicket(directorioTickets, t.getTipoGasolina());
	}

	private static void mostrarMenuPrincipal() {

		int opcion = 0;
		int numeroUsuario = 0;
		// ╔ ═ ║ ╠ ╗ ╣ ╚ ╝
		do {
			generarPausa();

			System.out.println("""
					╔══════════════════════════════════════════════════════╗
					║  BIENVENID@ A LA APLICACIÓN DE GASOLINERAS DE DANIEL ║
					╠══════════════════════════════════════════════════════╣
					║  Seleccione una opción:                              ║
					║  0- Finalizar el programa                            ║
					║  1- Entrar a la aplicación                           ║
					║  2- Mostrar todos los clientes cargados del XML      ║
					╚══════════════════════════════════════════════════════╝
					""");

			opcion = tryCatchInt();

			if (opcion == ERROR_INT)
				System.out.println(mostrarMensajeErrorInt());
			else if (opcion == 0) {
				System.out.println("Saliendo de la aplicación...");
				generarPausa();
				System.out.println("Saliste de la aplicación, ¡Hasta pronto!");
			} else if (opcion == 1) {
				System.out.println("Introduce tú numero de usuario");
				numeroUsuario = tryCatchInt();
				login(numeroUsuario);
			} else if (opcion == 2)
				mostrarDatosClientes(null, TODOS_LOS_CLIENTES);
			else
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
		} else if (numeroUsuario == ERROR_INT)
			System.out.println(mostrarMensajeErrorInt());
		else
			System.out.println("El usuario no existe o no lo has cargado en el archivo XML");
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
			System.out.println("El usuario no existe o no lo has cargado en el archivo XML");
			return null;
		}

	}

	private static String mostrarMensajeBienvenidaODespedida(Cliente clienteOnLine, char Bandera) {

		// ╔ ═ ║ ╠ ╗ ╣

		if (Bandera == BIENVENIDA) {
			return "╔═══════════════════════════════════════════════════════════╗" + "\n" + "║  ¡Bienvenid@ "
					+ clienteOnLine.getNombre() + "!" + " (Menú: "
					+ (clienteOnLine.getRol().equals("Administrador") ? "Administrador" : "Usuario") + ")\n"
					+ "╠═══════════════════════════════════════════════════════════╣";
		} else
			return "Cerrando sesión... ¡Hasta pronto " + clienteOnLine.getNombre() + "!";
	}

	public static String mostrarMensajeErrorInt() {

		return "El dato que has introducido no es una entrada válida para un Int.";
	}

	private static void mostrarMenuNormal(Cliente clienteOnLine) {

		int opcion = 0;
		System.out.println("Sesión iniciada correctamente");

		do {
			generarPausa();

			System.out.println(mostrarMensajeBienvenidaODespedida(clienteOnLine, BIENVENIDA));

			System.out.println("""
					║  Seleccione una opción:                                   ║
					║  0- Cerrar sesión                                         ║
					║  1- Visualizar los datos de un cliente                    ║
					║  2- Realizar repostaje (Venta generando ticket)           ║
					║  3- Mostrar el dinero gastado por este usuario            ║
					╚═══════════════════════════════════════════════════════════╝""");

			opcion = tryCatchInt();

			if (opcion == ERROR_INT)
				System.out.println(mostrarMensajeErrorInt());
			else if (opcion == 0)
				System.out.println(mostrarMensajeBienvenidaODespedida(clienteOnLine, DESPEDIDA));
			else if (opcion == 1)
				visualizarDatosCliente();
			else if (opcion == 2)
				realizarRepostaje(clienteOnLine);
			else if (opcion == 3)
				mostrarDatosDinero(clienteOnLine, UN_CLIENTE);
			else
				System.out.println("Opción no reconocida");

		} while (opcion != 0);

	}

	private static void mostrarMenuAdministrador(Cliente clienteOnLine) {

		int opcion = 0;

		System.out.println("Sesión iniciada correctamente");

		do {

			generarPausa();
			System.out.println(mostrarMensajeBienvenidaODespedida(clienteOnLine, BIENVENIDA));

			System.out.println("""
					║  Seleccione una opción:                                   ║
					║  0- Cerrar sesión                                         ║
					║  1- Mostrar todos los clientes cargados del XML           ║
					║  2- Visualizar los datos de un cliente                    ║
					║  3- Añadir un nuevo cliente                               ║
					║  4- Eliminar a un cliente                                 ║
					║  5- Añadir una gasolinera                                 ║
					║  6- Realizar repostaje (Venta generando ticket)           ║
					║  7- Mostrar el dinero gastado de todos los clientes       ║
					║  8- Mostrar el dinero gastado de un cliente en particular ║
					║  9- Mostrar el histórico de clientes (TODOS)              ║
					╚═══════════════════════════════════════════════════════════╝""");

			opcion = tryCatchInt();

			if (opcion == ERROR_INT)
				System.out.println(mostrarMensajeErrorInt());
			else if (opcion == 0)
				System.out.println(mostrarMensajeBienvenidaODespedida(clienteOnLine, DESPEDIDA));
			else if (opcion == 1)
				mostrarDatosClientes(null, TODOS_LOS_CLIENTES);
			else if (opcion == 2)
				visualizarDatosCliente();
			else if (opcion == 3)
				añadirCliente();
			else if (opcion == 4)
				eliminarCliente();
			else if (opcion == 5)
				añadirGasolinera();
			else if (opcion == 6)
				realizarRepostaje(clienteOnLine);
			else if (opcion == 7)
				mostrarDatosDinero(null, TODOS_LOS_CLIENTES);
			else if (opcion == 8)
				mostrarDineroCliente();
			else if (opcion == 9)
				HistorialAltas.mostrarTodosLosClientes();
			else
				System.out.println("Opción no reconocida");

		} while (opcion != 0);
		generarPausa();

	} 

	private static void mostrarDatosDinero(Cliente cliente, char Bandera) {

		double cantidad = 0;

		if (Bandera == TODOS_LOS_CLIENTES) {
			for (Ticket ticket : TICKETS)
				cantidad += ticket.getEuros();
			System.out
					.println("El dinero gastado por todos los clientes es: " + Math.floor(cantidad * 100) / 100 + "€");
		} else if (Bandera == UN_CLIENTE) {
			for (Ticket ticket : TICKETS)
				if (ticket.getCliente().getNumeroCliente() == cliente.getNumeroCliente())
					cantidad += ticket.getEuros();
			System.out.println("El dinero gastado por el cliente: " + cliente.getNumeroCliente() + ", con nombre: "
					+ cliente.getNombre() + " asciende a: " + Math.floor(cantidad * 100) / 100 + "€");
		}

	}

	private static void mostrarDineroCliente() {

		System.out.println("Introduce el número del cliente para ver su dinero gastado");

		Cliente clienteBuscado = HistorialAltas.busquedaCliente();
		if (clienteBuscado != null)
			mostrarDatosDinero(clienteBuscado, UN_CLIENTE);
	}

	private static void realizarRepostaje(Cliente clienteOnLine) {

		if (GASOLINERAS.isEmpty()) {
			System.out.println(
					"No puedes visualizar las gasolineras ya que no hay ninguna cargada en el archivo binario");
			System.out.println("Añade una gasolinera para poder realizar repostajes");
			return;
		}
		int opcion = 0;

		do {

			System.out.println(
					"Selecciona una opción para filtrar las gasolineras y poder seleccionar una gasolinera para repostar\n");
			System.out.println("0- Volver al menú principal");
			System.out.println("1- Visualizar todas las gasolineras");
			System.out.println("2- Visualizar todas las gasolineras por ubicación");
			System.out.println("3- Mostrar las gasolineras según los precios de las gasolinas");
			System.out.println("4- Mostrar las gasolineras por precios y por ubicación");

			opcion = tryCatchInt();

			if (opcion == ERROR_INT)
				System.out.println(mostrarMensajeErrorInt());
			else if (opcion == 0)
				System.out.println("Volviendo al menú principal...");
			else if (opcion == 1)
				visualizarGasolineras(TODAS_LAS_GASOLINERAS, clienteOnLine);
			else if (opcion == 2)
				visualizarGasolineras(POR_UBICACION, clienteOnLine);
			else if (opcion == 3)
				visualizarGasolineras(POR_PRECIOS, clienteOnLine);
			else if (opcion == 4)
				visualizarGasolineras(POR_UBICACION_Y_PRECIOS, clienteOnLine);
			else
				System.out.println("Opción no reconocida");

		} while (opcion != 0 && opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4);

	}

	private static void visualizarGasolineras(char Bandera, Cliente clienteOnLine) {

		ArrayList<Gasolinera> GasolinerasFiltradas = new ArrayList<>();

		String ubicacion = "";

		if (Bandera == POR_PRECIOS) {
			filtradoPrecios();
		} else if (Bandera == POR_UBICACION) {
			ubicacion = filtrarUbicacion();
			Collections.sort(GASOLINERAS, Comparator.comparingInt(Gasolinera::getID));
		} else if (Bandera == POR_UBICACION_Y_PRECIOS) {
			filtradoPrecios();
			ubicacion = filtrarUbicacion();
		} else if (Bandera == TODAS_LAS_GASOLINERAS)
			Collections.sort(GASOLINERAS, Comparator.comparingInt(Gasolinera::getID));

		for (Gasolinera g : GASOLINERAS) {
			if (Bandera == TODAS_LAS_GASOLINERAS || Bandera == POR_PRECIOS)
				GasolinerasFiltradas.add(g);
			else if (g.getUbicacion().equalsIgnoreCase(ubicacion))
				GasolinerasFiltradas.add(g);
		}

		seleccionarGasolineras(GasolinerasFiltradas, clienteOnLine);
	}

	private static void seleccionarGasolineras(ArrayList<Gasolinera> gasolinerasFiltradas, Cliente clienteOnLine) {

		int opcion = 0;
		boolean GasolineraEncontrada = false;

		if (gasolinerasFiltradas.isEmpty()) {
			System.out.println(
					"No se han encontrado gasolineras por la ubicación que pusistes, volviendo al menú principal...");
			return;
		}
		do {
			System.out.print(
					"Seleccione el ID de la gasolinera para realizar el repostaje, pulse 0 para salir al menú principal\n\n");

			for (Gasolinera g : gasolinerasFiltradas)
				System.out.println(g);

			opcion = tryCatchInt();

			if (opcion == ERROR_INT)
				System.out.println(mostrarMensajeErrorInt());
			else if (opcion == 0)
				System.out.println("Volviendo al menú principal...");
			else if (existeGasolinera(opcion, gasolinerasFiltradas)) {
				Gasolinera GasolineraSeleccionada = obtenerGasolinera(opcion, gasolinerasFiltradas);
				realizarPago(GasolineraSeleccionada, clienteOnLine);
				GasolineraEncontrada = true;
			} else
				System.out.println("No has seleccionado una gasolinera de las mostradas, vuelve a intentarlo");

		} while (opcion != 0 && !GasolineraEncontrada);
	}

	private static void realizarPago(Gasolinera gasolineraSeleccionada, Cliente clienteOnLine) {

		int cantidad = 0;
		int tipoGasolina = 0;
		int confirmarCompra = 0;
		do {
			System.out.println("¿Con qué tipo de gasolina quieres repostar?");
			System.out.println("1- Gasolina95");
			System.out.println("2- Diesel");
			tipoGasolina = tryCatchInt();
		} while (!confirmarDatos1_2(tipoGasolina));

		do {
			System.out.println(
					"¿Cuántos litros de " + (tipoGasolina == 1 ? "Gasolina95 " : "Diesel ") + "quieres repostar?");
			cantidad = tryCatchInt();

			if (cantidad == ERROR_INT)
				System.out.println(mostrarMensajeErrorInt());
			else if (cantidad == NUMERO_NEGATIVO || cantidad == 0)
				System.out.println("Debes de introducir una cantidad mayor de 0, inténtalo de nuevo por favor.");

		} while (cantidad <= 0);

		System.out.print("El precio de repostar " + cantidad + "L de " + (tipoGasolina == 1 ? "Gasolina95 " : "Diesel ")
				+ "en " + gasolineraSeleccionada.getNombre() + " son: ");
		System.out.println(tipoGasolina == 1
				? Math.floor((gasolineraSeleccionada.getPrecioLitro_G95() * cantidad) * 100) / 100 + "€"
				: Math.floor((gasolineraSeleccionada.getPrecioLitro_Diesel() * cantidad) * 100) / 100 + "€");
		do {
			System.out.println("¿Quieres confirmar la compra?");
			System.out.println("1- Sí");
			System.out.println("2- No, volver al menú principal");
			confirmarCompra = tryCatchInt();
		} while (!confirmarDatos1_2(confirmarCompra));

		if (confirmarCompra == 1) {
			if (clienteOnLine.getRol().equals("Cliente antiguo"))
				System.out.println(
						"Eres un cliente antiguo, no puedes realizar repostajes. Volviendo al menú principal...");
			else if (clienteOnLine.getNumeroCliente() == 1)
				System.out
						.println("El super administrador no puede realizar repostajes, volviendo al menú principal...");
			else if (cantidad > (tipoGasolina == 1 ? gasolineraSeleccionada.getCantidadG95()
					: gasolineraSeleccionada.getCantidadDiesel())) {
				System.out.println(
						"Error, no hay cantidad suficiente de " + (tipoGasolina == 1 ? "Gasolina95 " : "Diesel ")
								+ "para realizar el repostaje, vaya a otra gasolinera");
				System.out.println("Volviendo al menú principal...");
			} else {

				double Euros = tipoGasolina == 1
						? Math.floor((gasolineraSeleccionada.getPrecioLitro_G95() * cantidad) * 100) / 100
						: Math.floor((gasolineraSeleccionada.getPrecioLitro_Diesel() * cantidad) * 100) / 100;
				Ticket ticket = new Ticket(clienteOnLine, gasolineraSeleccionada, cantidad, Euros, tipoGasolina);
				TICKETS.add(ticket);

				if (tipoGasolina == 1)
					gasolineraSeleccionada.setCantidadG95(gasolineraSeleccionada.getCantidadG95() - cantidad);
				else
					gasolineraSeleccionada.setCantidadDiesel(gasolineraSeleccionada.getCantidadDiesel() - cantidad);

				Collections.sort(GASOLINERAS, Comparator.comparingInt(Gasolinera::getID));
				escribirArchivoBinario("src/JavaNIO/gasolineras.bin", ArrayGasolineras);
				escribirArchivoBinario("src/JavaNIO/Histórico/tickets.bin", ArrayTickets);
				System.out.println("Realizando el pago...");
				generarPausa();
				ticket.generarTicket(directorioTickets, tipoGasolina);
				System.out.println("Pago realizado correctamente");
				System.out.println("Resumen del repostaje: Litros de " + (tipoGasolina == 1 ? "Gasolina95 " : "Diesel ")
						+ "repostados: " + cantidad + "L x "
						+ (tipoGasolina == 1 ? String.valueOf(gasolineraSeleccionada.getPrecioLitro_G95())
								: String.valueOf(gasolineraSeleccionada.getPrecioLitro_Diesel()))
						+ "€ = " + Euros + "€");
			}

		} else
			System.out.println("Compra cancelada, volviendo al menú principal...");

	}

	private static Gasolinera obtenerGasolinera(int opcion, ArrayList<Gasolinera> gasolinerasFiltradas) {

		for (Gasolinera g : gasolinerasFiltradas) {
			if (g.getID() == opcion)
				return g;
		}
		return null;
	}

	private static boolean existeGasolinera(int opcion, ArrayList<Gasolinera> gasolinerasFiltradas) {

		for (Gasolinera g : gasolinerasFiltradas) {
			if (g.getID() == opcion)
				return true;
		}
		return false;
	}

	private static String filtrarUbicacion() {
		String ubicacion = "";

		do {
			System.out.println("Dime la ubicación por la que quieres filtrar las gasolineras");
			ubicacion = teclado.nextLine();
		} while (!cadenaVacia(ubicacion));

		return ubicacion;
	}

	private static void filtradoPrecios() {

		int opcionPrecios = 0;
		int opcionGasolina = 0;

		do {
			System.out.println("¿Por que tipo de gasolina quieres ordenar los datos?");
			System.out.println("1- Gasolina95");
			System.out.println("2- Diesel");
			opcionGasolina = tryCatchInt();
		} while (!confirmarDatos1_2(opcionGasolina));

		if (opcionGasolina == 1)
			Collections.sort(GASOLINERAS, Comparator.comparingDouble(Gasolinera::getPrecioLitro_G95));
		else
			Collections.sort(GASOLINERAS, Comparator.comparingDouble(Gasolinera::getPrecioLitro_Diesel));

		do {
			System.out.println("¿De que forma te gustaría ordenar los precios?");
			System.out.println("1- De menor a mayor precio");
			System.out.println("2- De mayor a menor precio");
			opcionPrecios = tryCatchInt();
		} while (!confirmarDatos1_2(opcionPrecios));

		if (opcionPrecios == 2)
			Collections.reverse(GASOLINERAS);

	}

	private static void añadirGasolinera() {

		String nombre = "";
		String ubicacion = "";

		double precioGasolina95 = 0;
		double precioDiesel = 0;
		int litrosGasolina95 = 0;
		int litrosDiesel = 0;

		int confirmacionGasolinera = 0;

		System.out.println("Vamos a añadir una una nueva gasolinera");
		do {
			System.out.println("Dime el nombre de la gasolinera");
			nombre = teclado.nextLine();
		} while (!cadenaVacia(nombre));
		do {
			System.out.println("Dime la ubicación de la gasolinera");
			ubicacion = teclado.nextLine();
		} while (!cadenaVacia(ubicacion));

		// Mi programa solo detecta hasta dos decimales ya que la función tryCatchDouble
		// me trunca
		// el número que introduce el usuario con dos decimales.
		do {
			System.out.println("Dime el precio del litro de la Gasolina 95");
			precioGasolina95 = tryCatchDouble();
		} while (!precioGasolinaCorrecta(precioGasolina95));
		do {
			System.out.println("Dime el precio del litro del Diesel");
			precioDiesel = tryCatchDouble();
		} while (!precioGasolinaCorrecta(precioDiesel));
		do {
			System.out.println("Dime la cantidad inicial de litros de Gasolina 95 que tendrá la gasolinera");
			litrosGasolina95 = tryCatchInt();
		} while (!LitrosGasolinaCorrecta(litrosGasolina95));
		do {
			System.out.println("Dime la cantidad inicial de litros de Diesel que tendrá la gasolinera");
			litrosDiesel = tryCatchInt();
		} while (!LitrosGasolinaCorrecta(litrosDiesel));

		do {
			System.out.println("¿Quiere confirmar que se guarda la gasolinera?");
			System.out.println("Nombre: " + nombre + ", ubicacion: " + ubicacion + ", PRECIOS/L: G95= "
					+ precioGasolina95 + "€, Diesel= " + precioDiesel + "€ | LITROS DISPONIBLES: G95= "
					+ litrosGasolina95 + "L, Diesel =" + litrosDiesel + "L");
			System.out.println("1- Sí");
			System.out.println("2- No");

			confirmacionGasolinera = tryCatchInt();

		} while (!confirmarDatos1_2(confirmacionGasolinera));

		if (confirmacionGasolinera == 1) {
			GASOLINERAS.add(
					new Gasolinera(nombre, ubicacion, precioGasolina95, precioDiesel, litrosGasolina95, litrosDiesel));
			escribirArchivoBinario("src/JavaNIO/gasolineras.bin", ArrayGasolineras);
			System.out.println("La gasolinera: " + nombre + " se ha registrado correctamente");
		} else
			System.out.println("Has decidido no registrar la gasolinera, volviendo al menú principal...");
	}

	private static boolean confirmarDatos1_2(int confirmacion) {

		if (confirmacion == ERROR_INT) {
			System.out.println(mostrarMensajeErrorInt());
			return false;
		} else if (confirmacion != 1 && confirmacion != 2) {
			System.out.println("Debes de introducir un 1 o un 2, opción no reconocida");
			return false;
		} else
			return true;

	}

	private static void escribirArchivoBinario(String rutaFichero, char Bandera) {

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaFichero));

			if (Bandera == ArrayGasolineras)
				oos.writeObject(GASOLINERAS);
			else if (Bandera == ArrayTickets)
				oos.writeObject(TICKETS);

			oos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean LitrosGasolinaCorrecta(int LitrosGasolina) {

		if (LitrosGasolina == NUMERO_NEGATIVO || LitrosGasolina == 0) {
			System.out.println("Debes de introducir una cantidad de litros mayor que 0");
			return false;
		} else if (LitrosGasolina == ERROR_INT) {
			System.out.println(mostrarMensajeErrorInt());
			return false;
		} else
			return true;
	}

	private static boolean precioGasolinaCorrecta(double precioGasolina) {

		if (precioGasolina == ERROR_DOUBLE) {
			System.out.println(mostrarMensajeErrorDouble());
			return false;
		} else if (precioGasolina == NUMERO_NEGATIVO || precioGasolina == 0) {
			System.out.println("El precio de la gasolina debe de ser mayor que 0,00 por favor repite el proceso");
			return false;
		} else
			return true;
	}

	private static void visualizarDatosCliente() {

		System.out.println("Introduce el número del cliente para ver sus datos");

		Cliente clienteBuscado = HistorialAltas.busquedaCliente();
		if (clienteBuscado != null)
			HistorialAltas.mostrarDatosClientes(clienteBuscado, UN_CLIENTE);
	}

	private static void eliminarCliente() {

		int opcionEliminarCliente = 0;

		System.out.println("Introduce el número del cliente para eliminarlo");

		Cliente clienteBuscado = busquedaCliente();

		if (clienteBuscado != null) {

			if (clienteBuscado.getNumeroCliente() == 1) {
				System.out.println("El Super Administrador no se puede eliminar, volviendo al menú principal...");
				return;
			}

			if (clienteBuscado.getRol().equals("Cliente antiguo")) {
				System.out.println("El cliente seleccionado ya es un cliente antiguo, volviendo el menú principal...");
				return;
			} else {
				do {
					System.out.println("¿Confirma la decisión de eliminar al siguiente cliente?");
					System.out.println(clienteBuscado);
					System.out.println("1- Sí");
					System.out.println("2- No");
					opcionEliminarCliente = tryCatchInt();
				} while (!confirmarDatos1_2(opcionEliminarCliente));
			}

			if (opcionEliminarCliente == 2) {
				System.out
						.println("El cliente no ha sido borrado, operación cancelada. Volviendo al menú principal...");
				return;
			}

			Path ficheroParaMover = directorioClientes.resolve(clienteBuscado.getNumeroCliente() + ".txt");
			Path ficheroNuevaUbicacion = directorioClientesAntiguos.resolve(clienteBuscado.getNumeroCliente() + ".txt");

			try {
				Files.move(ficheroParaMover, ficheroNuevaUbicacion);
				System.out.println("Se ha movido el archivo: " + ficheroNuevaUbicacion.getFileName() + " a: "
						+ ficheroNuevaUbicacion.toAbsolutePath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			clienteBuscado.setRol("Cliente antiguo");
			sobrescribirXML();
			HistorialAltas.sobrescribirXML();
		}
	}

	private static double tryCatchDouble() {

		double numero = 0;

		try {
			numero = teclado.nextDouble();
			teclado.nextLine();
			if (numero < 0)
				return NUMERO_NEGATIVO;
		} catch (InputMismatchException e) {
			teclado.nextLine();
			return ERROR_DOUBLE;
		}
		return Math.floor(numero * 100) / 100;
	}

	private static void añadirCliente() {

		int campoNumeroCliente = 0;
		int campoCodigoPostal = 0;
		int eleccionRol = 0;
		int confirmarDatos = 0;

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
			else if (!HistorialAltas.numeroClienteExistente(campoNumeroCliente))
				usuarioCorrecto = true;
			else
				System.out.println(
						"El número de cliente que has introducido ya está registrado, debes de introducir otro número");

		} while (!usuarioCorrecto);
		do {
			System.out.println("Introduce el nombre del cliente");
			campoNombre = teclado.nextLine();

		} while (!cadenaVacia(campoNombre));
		do {
			System.out.println("Introduce la calle del cliente");
			campoCalle = teclado.nextLine();
		} while (!cadenaVacia(campoCalle));
		do {
			System.out.println("Introduce la ciudad del cliente");
			campoCiudad = teclado.nextLine();
		} while (!cadenaVacia(campoCiudad));

		do {
			System.out.println("Introduce el código postal");
			campoCodigoPostal = tryCatchInt();

			if (campoCodigoPostal == NUMERO_NEGATIVO || campoCodigoPostal == 0) {
				System.out.println("Debes de introducir un Codigo Postal mayor que 0");
			} else if (campoCodigoPostal == ERROR_INT)
				System.out.println(mostrarMensajeErrorInt());
			else
				codigoPostalCorrecto = true;

		} while (!codigoPostalCorrecto);

		do {
			System.out.println("Introduce el país del cliente");
			campoPais = teclado.nextLine();
		} while (!cadenaVacia(campoPais));

		do {
			System.out.println("¿El usuario va a ser administrador, introduce un 1 o un 2?");
			System.out.println("1- Sí");
			System.out.println("2- No");

			eleccionRol = tryCatchInt();

		} while (!confirmarDatos1_2(eleccionRol));

		campoRol = eleccionRol == 1 ? "Administrador" : "Usuario";

		do {
			System.out.println("¿Quiere confirmar que se guarde el cliente?");
			System.out.println("Numero Cliente: " + campoNumeroCliente + ", nombre: " + campoNombre + ", calle: "
					+ campoCalle + ", ciudad: " + campoCiudad + ", código postal: " + campoCodigoPostal + ", pais: "
					+ campoPais + ", rol: " + campoRol);
			System.out.println("1- Sí");
			System.out.println("2- No");

			confirmarDatos = tryCatchInt();

		} while (!confirmarDatos1_2(confirmarDatos));

		if (confirmarDatos == 1) {
			Cliente nuevoCliente = new Cliente(campoNumeroCliente, campoNombre, campoCalle, campoCiudad,
					campoCodigoPostal, campoPais, campoRol);
			CLIENTES.add(nuevoCliente);
			HistorialAltas.HISTORIALCLIENTES.add(nuevoCliente);
			crearYEscribirFichasClientes();
			HistorialAltas.altaClienteFichero();
			HistorialAltas.sobrescribirXML();
			sobrescribirXML();
			System.out.println("El cliente se ha guardado correctamente");
		} else
			System.out.println("El cliente no se ha agregado, volviendo al menú principal...");

	}

	private static void sobrescribirXML() {

		Path fichero = ficheroXML;

		try {

			Files.writeString(fichero, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			Files.writeString(fichero, "<listadeclientes>\n", StandardOpenOption.APPEND);

			for (int i = 0; i < CLIENTES.size(); i++) {

				Files.writeString(fichero, "\t<cliente>\n", StandardOpenOption.APPEND);
				Files.writeString(fichero, "\t\t" + NUMEROCLIENTE + CLIENTES.get(i).getNumeroCliente() + "</"
						+ NUMEROCLIENTE.substring(1) + "\n", StandardOpenOption.APPEND);
				Files.writeString(fichero,
						"\t\t" + NOMBRE + CLIENTES.get(i).getNombre() + "</" + NOMBRE.substring(1) + "\n",
						StandardOpenOption.APPEND);
				Files.writeString(fichero, "\t\t<Direccion>\n", StandardOpenOption.APPEND);
				Files.writeString(fichero,
						"\t\t\t" + CALLE + CLIENTES.get(i).getCalle() + "</" + CALLE.substring(1) + "\n",
						StandardOpenOption.APPEND);
				Files.writeString(fichero,
						"\t\t\t" + CIUDAD + CLIENTES.get(i).getCiudad() + "</" + CIUDAD.substring(1) + "\n",
						StandardOpenOption.APPEND);
				Files.writeString(fichero, "\t\t\t" + CODIGOPOSTAL + CLIENTES.get(i).getCodigopostal() + "</"
						+ CODIGOPOSTAL.substring(1) + "\n", StandardOpenOption.APPEND);
				Files.writeString(fichero,
						"\t\t\t" + PAIS + CLIENTES.get(i).getPais() + "</" + PAIS.substring(1) + "\n",
						StandardOpenOption.APPEND);
				Files.writeString(fichero, "\t\t</direccion>\n", StandardOpenOption.APPEND);
				Files.writeString(fichero, "\t</cliente>\n", StandardOpenOption.APPEND);

			}
			Files.writeString(fichero, "</listadeclientes>\n", StandardOpenOption.APPEND);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Se produjo un error al sobrescribir el archivo");
		}

	}

	private static boolean cadenaVacia(String palabra) {

		if (palabra.equals("")) {
			System.out.println("La palabra que has introducido no puede estar en blanco, por favor repítelo de nuevo");
			return false;
		} else
			return true;
	}

	public static void mostrarDatosClientes(Cliente cliente, char Bandera) {

		if (Bandera == TODOS_LOS_CLIENTES) {
			for (Cliente e : CLIENTES)
				System.out.println(e);
		} else if (Bandera == UN_CLIENTE)
			System.out.println(cliente);
	}

	public static String mostrarMensajeErrorDouble() {

		return "El dato que has introducido no es una entrada válida para un Double.";
	}

	public static int tryCatchInt() {

		int numero = 0;

		try {
			numero = teclado.nextInt();
			teclado.nextLine();
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

	public static void generarPausa() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Hubo un error en la pausa");
		}
	}

	public static void main(String[] args) {

		inicializarCargaDatosAPP();
		mostrarMenuPrincipal();

	}

}
