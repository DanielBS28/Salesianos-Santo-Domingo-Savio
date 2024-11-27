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
					║  Seleccione una opción:                              ║
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
					║  Seleccione una opción:                                   ║
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
		/*	else if (opcion == 1)
			else if (opcion == 2)
			else if (opcion == 3)
			else if (opcion == 4)
			else if (opcion == 5)
			else if (opcion == 6)
			else if (opcion == 7)
			else if (opcion == 8)
			else if (opcion == 9)
			else
				System.out.println("Opción no reconocida");
*/
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
					║  Seleccione una opción:                                   ║
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
			/*else if (opcion == 1)
			else if (opcion == 2)
			else if (opcion == 3)
			else if (opcion == 4)
			else if (opcion == 5)*/
			else if (opcion == 6)
				ConsultasSQL.visualizarTickets(alias, Utilidades.EMPLEADO);
			else
				System.out.println("Opción no reconocida");

		} while (opcion != 0);
		Utilidades.generarPausa();

	}

	private static void mostrarMenuCliente(String alias, String rol) {
		int opcion = 0;

		System.out.println("Sesión iniciada correctamente");

		do {

			Utilidades.generarPausa();
			System.out.println(Utilidades.mostrarMensajeBienvenidaODespedida(alias, rol, Utilidades.BIENVENIDA));

			System.out.println("""
					║  Seleccione una opción:                                   ║
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
		/*	else if (opcion == 1)
			else if (opcion == 2)
			else if (opcion == 3)
			else if (opcion == 4)
			else if (opcion == 5)
			else
				System.out.println("Opción no reconocida");
*/
		} while (opcion != 0);
		Utilidades.generarPausa();

	}

}
