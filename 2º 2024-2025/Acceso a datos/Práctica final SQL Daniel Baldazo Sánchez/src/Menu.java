import java.util.Scanner;

public class Menu {

	static Scanner teclado = new Scanner(System.in);

	public static void menuPrincipal() {

		int opcion = 0;
		String alias = "";
		String contraseña = "";
		String rol = "";
		// ╔ ═ ║ ╠ ╗ ╣ ╚ ╝
		do {
			Utilidades.generarPausa();

			System.out.println("""
					╔══════════════════════════════════════════════════════╗
					║  BIENVENIDA A LA PRÁCTICA DE CONSULTAS SQL DE DANIEL ║
					╠══════════════════════════════════════════════════════╣
					║  Selecciona una opción:                              ║
					║  0- Finalizar el programa                            ║
					║  1- Iniciar sesión (alias y contraseña)              ║
					║  2- Mostrar todos los usuarios y contraseñas (Ayuda) ║
					╚══════════════════════════════════════════════════════╝""");

			opcion = Utilidades.tryCatchInt();

			if (opcion == Errores.ERROR_INT)
				System.out.println(Errores.mostrarMensajeErrorInt());
			else if (opcion == 0) {
				System.out.println("Saliendo de la aplicación...");
				Utilidades.generarPausa();
				System.out.println("Saliste de la aplicación, ¡Hasta pronto!");
			} else if (opcion == 1) {
				System.out.println("Introduce tu alias");
				alias = teclado.nextLine();
				System.out.println("Introduce tu contraseña");
				contraseña = teclado.nextLine();
				rol = ConsultasSQL.login(alias, contraseña);
				if (rol.equals("Admin"))
					mostrarMenuAdmin(alias, rol);
				else if (rol.equals("Empleado"))
					mostrarMenuEmpleado(alias, rol);
				else if (rol.equals("Cliente"))
					mostrarMenuCliente(alias, rol);
			} else if (opcion == 2) {
				ConsultasSQL.usuariosContraseñas();
			} else
				System.out.println("Opción no reconocida");

		} while (opcion != 0);
	}

	private static void mostrarMenuAdmin(String alias, String rol) {

		int opcion = 0;

		System.out.println("Sesión iniciada correctamente");

		do {

			Utilidades.generarPausa();
			System.out.println(Utilidades.mostrarMensajeBienvenidaODespedida(alias, rol, Utilidades.BIENVENIDA));

			System.out.println("""
					║  Selecciona una opción:                                   ║
					║  0- Cerrar sesión                                         ║
					║  1- Insertar a un nuevo cliente                           ║
					║  2- Modificar los datos de un cliente                     ║
					║  3- Eliminar a un cliente                                 ║
					║  4- Insertar a un nuevo empleado                          ║
					║  5- Modificar los datos de un cliente                     ║
					║  6- Eliminar a un empleado                                ║
					║  7- Insertar un nuevo producto                            ║
					║  8- Modificar los datos de un producto                    ║
					║  9- Eliminar un producto                                  ║
					╚═══════════════════════════════════════════════════════════╝""");

			opcion = Utilidades.tryCatchInt();

			if (opcion == Errores.ERROR_INT)
				System.out.println(Errores.mostrarMensajeErrorInt());
			else if (opcion == 0)
				System.out.println(Utilidades.mostrarMensajeBienvenidaODespedida(alias, rol, Utilidades.DESPEDIDA));

			else if (opcion == 1)
				Utilidades.insertarNuevoCliente();
			else if (opcion == 2)
				Utilidades.modificarCliente();
			else if (opcion == 3)
				Utilidades.eliminarCliente();
			else if (opcion == 4)
				Utilidades.insertarNuevoEmpleado();
			else if (opcion == 5)
				Utilidades.modificarEmpleado();
			else if (opcion == 6)
				Utilidades.eliminarEmpleado();
			else if (opcion == 7)
				Utilidades.insertarNuevoProducto();
			else if (opcion == 8)
				Utilidades.modificarProducto();
			else if (opcion == 9)
				Utilidades.eliminarProducto();
			else
				System.out.println("Opción no reconocida");

		} while (opcion != 0);
		Utilidades.generarPausa();

	}

	private static void mostrarMenuEmpleado(String alias, String rol) {
		int opcion = 0;

		System.out.println("Sesión iniciada correctamente");

		do {

			Utilidades.generarPausa();
			System.out.println(Utilidades.mostrarMensajeBienvenidaODespedida(alias, rol, Utilidades.BIENVENIDA));

			System.out.println("""
					║  Selecciona una opción:                                   ║
					║  0- Cerrar sesión                                         ║
					║  1- Visualizar los productos por una letra inicial        ║
					║  2- Visualizar los productos por precio                   ║
					║  3- Visualizar los productos por stock                    ║
					║  4- Realizar ventas para un cliente (número de cliente)   ║
					║  5- Realizar ventas para un cliente (filtrando Nombre)    ║
					║  6- Ver los tickets generados por este empleado           ║
					╚═══════════════════════════════════════════════════════════╝""");

			opcion = Utilidades.tryCatchInt();

			if (opcion == Errores.ERROR_INT)
				System.out.println(Errores.mostrarMensajeErrorInt());
			else if (opcion == 0)
				System.out.println(Utilidades.mostrarMensajeBienvenidaODespedida(alias, rol, Utilidades.DESPEDIDA));
			else if (opcion == 1)
				mostrarMenuLetraInicial();
			else if (opcion == 2)
				mostrarMenuPrecios();
			else if (opcion == 3)
				mostrarMenuStock();
			else if (opcion == 4)
				mostrarMenuVentaClientesNumero(alias);
			else if (opcion == 5)
				mostrarMenuVentaClientesLetras(alias);
			else if (opcion == 6)
			ConsultasSQL.visualizarTickets(alias, Utilidades.EMPLEADO);
			else
				System.out.println("Opción no reconocida");

		} while (opcion != 0);
		Utilidades.generarPausa();

	}

	private static void mostrarMenuVentaClientesLetras(String alias) {
		
		String nombre = "";
		do {
			System.out.println("Introduce un nombre para ver los usuarios con ese nombre");
			nombre = teclado.nextLine();
		}while(!Utilidades.cadenaVacia(nombre));
		
		if(ConsultasSQL.obtenerNombreCompra(nombre)) {
			int numerodecliente = Utilidades.escogerNúmero();
			int numeroempleado = ConsultasSQL.obtenerCodigo_porAlias(alias, Utilidades.EMPLEADO);
			Utilidades.iniciarCompra(numerodecliente, numeroempleado);
		}
	}

	private static void mostrarMenuLetraInicial() {

		String linea = "";

		do {
			System.out.println("Introduce una letra para filtrar los productos por esa letra inicial");
			linea = teclado.nextLine();
			if (linea.length() > 1)
				System.out.println("Debes de introducir solo una letra, vuelve a intentarlo por favor.");
			else if (linea.length() == 0)
				System.out.println("No puedes introducir una letra vacía, vuelve a intentarlo por favor.");
		} while (linea.length() != 1);

		ConsultasSQL.visualizarProductos(Utilidades.INICIAL, linea.charAt(0));

	}

	private static void mostrarMenuVentaClientesNumero(String aliasEmpleado) {

		int numerodecliente = 0;

		do {
			System.out.println("Introduce el número de cliente para realizar una venta");
			numerodecliente = Utilidades.tryCatchInt();

			if (numerodecliente == Errores.ERROR_INT)
				System.out.println(Errores.mostrarMensajeErrorInt());
			else if (numerodecliente == Errores.NUMERO_NEGATIVO)
				System.out.println("No puedes introducir un número de cliente negativo");

		} while (numerodecliente == Errores.ERROR_INT || numerodecliente == Errores.NUMERO_NEGATIVO);

		String ClienteEncontrado = ConsultasSQL.obtenerCliente(numerodecliente);

		if (!ClienteEncontrado.equals("")) {
			int numeroDeEmpleado = ConsultasSQL.obtenerCodigo_porAlias(aliasEmpleado, Utilidades.EMPLEADO);
			Utilidades.iniciarCompra(numerodecliente, numeroDeEmpleado);
		}

	}

	private static void mostrarMenuStock() {

		int eleccion = 0;
		do {
			System.out.println("¿De que forma te gustaría los productos");
			System.out.println("1- De mayor a menor stock");
			System.out.println("2- De menor a mayor stock");
			eleccion = Utilidades.tryCatchInt();
		} while (!Utilidades.confirmarDatos1_2(eleccion));

		if (eleccion == 1)
			ConsultasSQL.visualizarProductos(Utilidades.MAYOR_MENOR_STOCK, '0');
		else
			ConsultasSQL.visualizarProductos(Utilidades.MENOR_MAYOR_STOCK, '0');

	}

	private static void mostrarMenuPrecios() {

		int eleccion = 0;
		do {
			System.out.println("¿De que forma te gustaría ver los productos");
			System.out.println("1- De mayor a menor precio");
			System.out.println("2- De menor a mayor precio");
			eleccion = Utilidades.tryCatchInt();
		} while (!Utilidades.confirmarDatos1_2(eleccion));

		if (eleccion == 1)
			ConsultasSQL.visualizarProductos(Utilidades.MAYOR_MENOR_PRECIO, '0');
		else
			ConsultasSQL.visualizarProductos(Utilidades.MENOR_MAYOR_PRECIO, '0');

	}

	private static void mostrarMenuCliente(String alias, String rol) {
		int opcion = 0;

		System.out.println("Sesión iniciada correctamente");
		int numerocliente = ConsultasSQL.obtenerCodigo_porAlias(alias, Utilidades.CLIENTE);


		do {

			Utilidades.generarPausa();
			System.out.println(Utilidades.mostrarMensajeBienvenidaODespedida(alias, rol, Utilidades.BIENVENIDA));

			System.out.println("""
					║  Selecciona una opción:                                   ║
					║  0- Cerrar sesión                                         ║
					║  1- Visualizar los productos por una letra inicial        ║
					║  2- Visualizar los productos por precio                   ║
					║  3- Visualizar los productos por stock                    ║
					║  4- Realizar compra de productos                          ║
					║  5- Visualizar el historial de compras de este cliente    ║
					╚═══════════════════════════════════════════════════════════╝""");

			opcion = Utilidades.tryCatchInt();

			if (opcion == Errores.ERROR_INT)
				System.out.println(Errores.mostrarMensajeErrorInt());
			else if (opcion == 0)
				System.out.println(Utilidades.mostrarMensajeBienvenidaODespedida(alias, rol, Utilidades.DESPEDIDA));
			else if (opcion == 1)
				mostrarMenuLetraInicial();
			else if (opcion == 2)
				mostrarMenuPrecios();
			else if (opcion == 3)
				mostrarMenuStock();
			else if (opcion == 4) 
			Utilidades.iniciarCompra(numerocliente, 1);
			else if (opcion == 5)
				ConsultasSQL.visualizarTickets(alias, Utilidades.CLIENTE);
			else
				System.out.println("Opción no reconocida");

		} while (opcion != 0);
		Utilidades.generarPausa();

	}

}
