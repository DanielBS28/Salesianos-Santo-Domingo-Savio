import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilidades {

	final static char DESPEDIDA = '0';
	final static char BIENVENIDA = '1';
	final static char EMPLEADO = '2';
	final static char CLIENTE = '3';
	final static char PRODUCTO = '4';

	final static int INICIAL = 0;
	final static int MAYOR_MENOR_PRECIO = 1;
	final static int MENOR_MAYOR_PRECIO = 2;
	final static int MENOR_MAYOR_STOCK = 3;
	final static int MAYOR_MENOR_STOCK = 4;

	static Scanner teclado = new Scanner(System.in);

	public static int tryCatchInt() {

		int numero = 0;

		try {
			numero = teclado.nextInt();
			teclado.nextLine();
			if (numero < 0) // No quiero que el usuario introduza un número negativo, en ese caso devuelvo
							// un número negativo que califico como numero negativo (es un -2)
				// Para que el programa lo interprete como opción no valida.
				return Errores.NUMERO_NEGATIVO;
		} catch (InputMismatchException e) {
			teclado.nextLine();
			return Errores.ERROR_INT; // Aquí devuelvo -1 por que quiero que sea el mensaje de error dentro del menú y
			// no en el tryCatch
			// ya que si no se provocaría aquí un bucle que quiero evitar ya que si no el
			// menú quedaría arriba en el consola
		}
		return numero; // Si todo fue bien devuelvo el número introducido

	}

	public static void generarPausa() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Hubo un error en la pausa");
		}
	}

	public static String mostrarMensajeBienvenidaODespedida(String alias, String rol, char Bandera) {

		if (Bandera == BIENVENIDA) {
			return "╔═══════════════════════════════════════════════════════════╗" + "\n" + "║  ¡Bienvenid@ " + alias
					+ "!" + " (Menú: " + rol + ")\n" + "╠═══════════════════════════════════════════════════════════╣";
		} else
			return "Cerrando sesión... ¡Hasta pronto " + alias + "!";

	}

	public static boolean confirmarDatos1_2(int confirmacion) {

		if (confirmacion == Errores.ERROR_INT) {
			System.out.println(Errores.mostrarMensajeErrorInt());
			return false;
		} else if (confirmacion != 1 && confirmacion != 2) {
			System.out.println("Debes de introducir un 1 o un 2, opción no reconocida");
			return false;
		} else
			return true;

	}

	public static void iniciarCompra(int numeroDeCliente, int numeroDeEmpleado) {
		
		/*Aquí he usado dos arraylist, y voy a justificar por que decidí hacerlo de esta forma
		 * mi array list de todos los productos se rellena con una consulta para obtener 
		 * todos los productos de la base de datos. También tengo otro array que se llama cesta
		 * el proposito de esto es que durante el proceso de compra los use de manera "temporal"
		 * es decir no voy a hacer el update a la base de datos hasta que el cliente no confirme 
		 * la compra, ya que si hago el update antes y luego el cliente cancela la compra no se
		 * como podría volver a actualizar el stock, de esta manera voy actulizando el stock pero
		 * de manera temporal en el arraylist, si el cliente acepta la compra, hago un update con
		 * los datos de la cesta, si no no pasa nada. Es el unico fragmento de codigo (proceso de compra)
		 * donde he utilizado los arraylist, todo lo demás está hecho con consultas, te lo pregunté
		 * lo de los array list y te pareció buena idea :)
		 * */
		
		ArrayList<Producto> TODOSLOSPRODUCTOS = ConsultasSQL.obtenerProductos();
		ArrayList<Producto> CESTA = new ArrayList<>();
		String id = "";

		do {
			double precioTotal = 0;

			for (Producto p : TODOSLOSPRODUCTOS)
				System.out.println(p);
			System.out.println("----------------------------------------------------------");
			System.out.println("Tu cesta: ");
			if (CESTA.isEmpty())
				System.out.println("No tienes productos en la cesta.");
			else {
				for (Producto cesta : CESTA) {
					System.out.println(cesta.getNombre() + " -> " + cesta.getStock() + " unidades x "
							+ cesta.getPrecioUnitario() + "€ = " + cesta.getStock() * cesta.getPrecioUnitario() + "€");
					precioTotal += cesta.getStock() * cesta.getPrecioUnitario();
				}
			}
			System.out.println("\nPrecio total en la cesta: " + precioTotal + "€");
			System.out.println("----------------------------------------------------------");
			System.out.println(
					"Introduce el ID del producto que quieras\no pulsa 0 terminar el proceso de compra (confirmar o cancelar compra)");

			id = teclado.nextLine();

			if (ConsultasSQL.estaEnVenta(id))
				pedirCantidad(TODOSLOSPRODUCTOS, CESTA, id);
			else if (id.equals("0"))
				mostrarPasarelaDePago(numeroDeCliente, numeroDeEmpleado, CESTA, precioTotal);
			else
				System.out.println("El ID que has introducido no se encuentra en la lista de productos.");

		} while (!id.equals("0"));
	}

	private static void mostrarPasarelaDePago(int numeroDeCliente, int numeroDeEmpleado, ArrayList<Producto> CESTA,
			double precioTotal) {

		int eleccion = 0;

		if (CESTA.isEmpty()) {
			System.out.println("No puedes realizar una compra sin productos, volviendo al menú principal...");
			return;
		}
		do {
			System.out.println("----------------------------------------------------------");

			System.out.println("RESUMEN DE LA COMPRA:\n");

			for (Producto cesta : CESTA) {
				System.out.println(cesta.getNombre() + " -> " + cesta.getStock() + " unidades x "
						+ cesta.getPrecioUnitario() + "€ = " + cesta.getStock() * cesta.getPrecioUnitario() + "€");
			}
			System.out.println("\nPrecio total en la cesta: " + precioTotal + "€");
			System.out.println("----------------------------------------------------------");

			System.out.println("¿Quieres confirmar la compra?\n");
			System.out.println("1- Sí");
			System.out.println("2- No");
			eleccion = Utilidades.tryCatchInt();
		} while (!Utilidades.confirmarDatos1_2(eleccion));

		if (eleccion == 1) {
			System.out.println("Redirigiendo...");
			generarPausa();
			preguntarPuntos(numeroDeCliente, numeroDeEmpleado, CESTA, precioTotal);
		} else
			System.out.println("Has decidido cancelar la compra, volviendo al menú principal...");

	}

	private static void preguntarPuntos(int numeroDeCliente, int numeroDeEmpleado, ArrayList<Producto> CESTA,
			double precioTotal) {

		int eleccion = 0;
		int puntosSeleccionados = 0;
		int puntos = ConsultasSQL.obtenerPuntos(numeroDeCliente);

		do {
			System.out.println("El precio total de la compra es de: " + precioTotal + "€");
			System.out.println("¿Te gustaría usar puntos de usuario para obtener un descuento?");
			System.out.println("1- Sí");
			System.out.println("2- No");
			System.out.println("Puntos disponibles: " + puntos + "\n");

			eleccion = tryCatchInt();

			if (puntos == 0) {
				System.out.println("No tienes puntos disponibles");
				generarPausa();
				eleccion = 2;
			}

		} while (!Utilidades.confirmarDatos1_2(eleccion));

		if (eleccion == 1) {
			do {
				System.out.println("¿Cuántos puntos quieres canjear? 1 punto es 1€");
				System.out.println("Puntos disponibles: " + puntos + "\n");
				System.out.println("Precio total de la compra: " + precioTotal + "€");

				puntosSeleccionados = tryCatchInt();

				if (puntosSeleccionados == Errores.ERROR_INT)
					System.out.println(Errores.mostrarMensajeErrorInt());
				else if (puntosSeleccionados < 0 || puntosSeleccionados > precioTotal)
					System.out.println("Debes de introducir un número de puntos entre 1 y " + (int) precioTotal);

			} while (puntosSeleccionados <= 0 || puntosSeleccionados > precioTotal);
		}

		System.out.println("Generando el pago...");
		generarPausa();
		visualizarTicketConsola(numeroDeCliente, numeroDeEmpleado, CESTA, precioTotal, puntosSeleccionados);
	}

	private static void visualizarTicketConsola(int numeroDeCliente, int numeroDeEmpleado, ArrayList<Producto> CESTA,
			double precioTotal, int puntosSeleccionados) {

		generarPausa();
		int puntosAcumulados = 0;
		System.out.println("----------------------------------------------------------");

		System.out.println("RESUMEN DE LA COMPRA:");

		for (Producto cesta : CESTA) {
			System.out.println(cesta.getNombre() + " -> " + cesta.getStock() + " unidades x "
					+ cesta.getPrecioUnitario() + "€ = " + cesta.getStock() * cesta.getPrecioUnitario() + "€");
		}
		System.out.println("----------------------------------------------------------");
		System.out.println("Descuento por puntos: " + precioTotal + "€ - " + puntosSeleccionados + " puntos = "
				+ (precioTotal - puntosSeleccionados) + "€");
		precioTotal -= puntosSeleccionados;
		precioTotal = Math.floor(precioTotal * 100) / 100;
		puntosAcumulados = (int) (precioTotal * 0.10);
		System.out.println("Precio total: " + precioTotal + "€");
		System.out.println("En esta compra has sumado a tus puntos: " + puntosAcumulados + " puntos");
		System.out.println();
		int ticket = ConsultasSQL.contarTickets() + 1;
		ConsultasSQL.insertarTicket(ticket, precioTotal, numeroDeEmpleado, numeroDeCliente);
		for (int i = 0; i < CESTA.size(); i++) {
			ConsultasSQL.insertarCantidadProducto(ticket, CESTA.get(i).getIdProducto(), CESTA.get(i).getStock());
			ConsultasSQL.actualizarStockProducto(CESTA.get(i).getIdProducto(), CESTA.get(i).getStock());
		}
		ConsultasSQL.restarPuntos(puntosSeleccionados, numeroDeCliente);
		ConsultasSQL.sumarPuntos(puntosAcumulados, numeroDeCliente);

		generarPausa();

	}

	private static void pedirCantidad(ArrayList<Producto> TODOSLOSPRODUCTOS, ArrayList<Producto> CESTA, String id) {

		int cantidad = 0;
		
		do {

		Producto productoSeleccionado = obtenerProductoPorID(id, TODOSLOSPRODUCTOS);
		System.out.println("El producto que has seleccionado es: " + productoSeleccionado.getNombre()
				+ " y su stock disponible es: " + productoSeleccionado.getStock());
		System.out.println("¿Cuántas unidades te gustaría comprar? Su precio unitario es de: "
				+ productoSeleccionado.getPrecioUnitario() + "€");

		cantidad = tryCatchInt();
		
		if (cantidad == Errores.ERROR_INT)
			System.out.println(Errores.mostrarMensajeErrorInt() + " Repite el proceso de nuevo.");
		else if (cantidad == Errores.NUMERO_NEGATIVO || cantidad == 0)
			System.out.println("Debes de introducir una cantidad superior a 0, vuelve a repetir el proceso");
		else if (cantidad > productoSeleccionado.getStock())
			System.out.println(
					"La cantidad que has introducido es mayor al stock disponible del producto\nvuelve a repetir el proceso.");
		else {
			boolean encontrado = false;

			for (int i = 0; i < CESTA.size(); i++) {
				if (CESTA.get(i).getIdProducto() == Integer.valueOf(id)) {
					CESTA.get(i).setStock(CESTA.get(i).getStock() + cantidad);
					productoSeleccionado.setStock(productoSeleccionado.getStock() - cantidad);
					encontrado = true;
				}
			}
			if (!encontrado) {
				CESTA.add(new Producto(productoSeleccionado.getIdProducto(), productoSeleccionado.getNombre(),
						productoSeleccionado.getPrecioUnitario(), cantidad));
				productoSeleccionado.setStock(productoSeleccionado.getStock() - cantidad);

			}

			System.out.println(
					"El producto " + productoSeleccionado.getNombre() + " se ha agregado correctamente al carrito.");
		}
		
		}while(cantidad == Errores.NUMERO_NEGATIVO || cantidad == 0 || cantidad == Errores.ERROR_INT);

		generarPausa();
		generarPausa();

	}

	private static Producto obtenerProductoPorID(String id, ArrayList<Producto> TODOSLOSPRODUCTOS) {
		
		for(Producto p : TODOSLOSPRODUCTOS) {
			if(p.getIdProducto() == Integer.parseInt(id))
				return p;
		}
		return null;
	}

	public static void insertarNuevoCliente() {

		String alias = "";
		String contraseña = "";
		String nombrePersona = "";
		String direccion = "";
		String rol = "Cliente";

		System.out.println("Vamos a insertar un nuevo cliente: (Solo podrá tener el rol cliente)");
		do {
			System.out.println("Introduce el alias del cliente nuevo");
			alias = teclado.nextLine();
		} while (!cadenaVacia(alias));
		do {
			System.out.println("Introduce la contraseña que tendrá el cliente");
			contraseña = teclado.nextLine();
		} while (!cadenaVacia(contraseña));
		do {
			System.out.println("Introduce el nombre real que tiene el cliente");
			nombrePersona = teclado.nextLine();
		} while (!cadenaVacia(nombrePersona));
		do {
			System.out.println("Introduce la dirección del cliente nuevo");
			direccion = teclado.nextLine();
		} while (!cadenaVacia(direccion));

		ConsultasSQL.insertarUsuario(alias, contraseña, rol);
		ConsultasSQL.insertarCliente(nombrePersona, direccion, alias);
	}

	public static boolean cadenaVacia(String palabra) {

		if (palabra.equals("")) {
			System.out.println("La palabra que has introducido no puede estar en blanco, por favor repítelo de nuevo");
			return false;
		} else
			return true;
	}

	public static void insertarNuevoEmpleado() {

		int opcionCargo = 0;
		int opcionRol = 0;
		String alias = "";
		String contraseña = "";
		String nombrePersona = "";
		String rol = "";
		String cargo = "";

		System.out.println("Vamos a insertar un nuevo empleado: ");
		do {
			System.out.println("Introduce el alias del empleado nuevo");
			alias = teclado.nextLine();
		} while (!cadenaVacia(alias));
		do {
			System.out.println("Introduce la contraseña que tendrá el empleado");
			contraseña = teclado.nextLine();
		} while (!cadenaVacia(contraseña));
		do {
			System.out.println("Introduce el nombre real que tiene el empleado");
			nombrePersona = teclado.nextLine();
		} while (!cadenaVacia(nombrePersona));
		do {
			System.out.println("¿Qué rol tendrá el empleado?");
			System.out.println("1- Empleado");
			System.out.println("2- Administrador");
			opcionRol = tryCatchInt();

		} while (!confirmarDatos1_2(opcionRol));
		do {
			System.out.println("¿Que puesto tendrá el nuevo empleado elige un número del 1 al 4?");

			System.out.println("1- Dependiente");
			System.out.println("2- Dependiente, Encargado");
			System.out.println("3- Dependiente, Encargado, Cajero");
			System.out.println("4- Dependiente, Encargado, Cajero, Pistolero");
			opcionCargo = tryCatchInt();
			if (opcionCargo == Errores.ERROR_INT)
				System.out.println(Errores.mostrarMensajeErrorInt());
			else if (opcionCargo < 1 || opcionCargo > 4)
				System.out.println("Debes de introducir un número entre el 1 y el 4");
		} while (opcionCargo < 1 || opcionCargo > 4);

		if (opcionRol == 1)
			rol = "Empleado";
		else
			rol = "Admin";

		if (opcionCargo == 1)
			cargo = "Dependiente";
		else if (opcionCargo == 2)
			cargo = "Dependiente,Encargado";
		else if (opcionCargo == 3)
			cargo = "Dependiente,Encargado,Cajero";
		else if (opcionCargo == 4)
			cargo = "Dependiente,Encargado,Cajero,Pistolero";

		ConsultasSQL.insertarUsuario(alias, contraseña, rol);
		ConsultasSQL.insertarEmpleado(nombrePersona, alias, cargo);

	}

	public static void insertarNuevoProducto() {

		String nombre = "";
		double precio = 0;
		int stockinicial = 0;
		System.out.println("Vamos a insertar un nuevo producto: ");
		do {
			System.out.println("Introduce el nombre del producto nuevo");
			nombre = teclado.nextLine();
		} while (!cadenaVacia(nombre));

		do {
			System.out.println("Introduce el precio del producto: " + nombre);
			precio = tryCatchDouble();
		} while (!precioProductoCorrecto(precio));
		do {
			System.out.println("Introduce la cantidad inicial de stock que tendrá " + nombre);
			stockinicial = tryCatchInt();
		} while (!comprobarStock(stockinicial));

		ConsultasSQL.insertarProducto(nombre, precio, stockinicial);

	}

	private static boolean comprobarStock(int stock) {

		if (stock == Errores.NUMERO_NEGATIVO || stock == 0) {
			System.out.println("Debes de introducir una cantidad de stock mayor que 0");
			return false;
		} else if (stock == Errores.ERROR_INT) {
			System.out.println(Errores.mostrarMensajeErrorInt());
			return false;
		} else
			return true;
	}

	private static boolean precioProductoCorrecto(double precio) {

		if (precio == Errores.ERROR_DOUBLE) {
			System.out.println(Errores.mostrarMensajeErrorDouble());
			return false;
		} else if (precio == Errores.NUMERO_NEGATIVO || precio == 0) {
			System.out.println("El precio del producto debe de ser mayor que 0,00 por favor repite el proceso");
			return false;
		} else
			return true;
	}

	private static double tryCatchDouble() {

		double numero = 0;

		try {
			numero = teclado.nextDouble();
			teclado.nextLine();
			if (numero < 0)
				return Errores.NUMERO_NEGATIVO;
		} catch (InputMismatchException e) {
			teclado.nextLine();
			return Errores.ERROR_DOUBLE;
		}
		return Math.floor(numero * 100) / 100;
	}

	public static void eliminarCliente() {

		int opcion = 0;
		int opcionEliminar = 0;
		do {
			System.out.println("¿De que forma te gustaría eliminar a un cliente?");
			System.out.println("1- Insertando su número de cliente");
			System.out.println("2- Mostrando todos los clientes y seleccionar su ID");
			opcion = tryCatchInt();

		} while (!confirmarDatos1_2(opcion));

		if (opcion == 1) {
			opcionEliminar = escogerNúmero();
			ConsultasSQL.eliminarRegistro(opcionEliminar, CLIENTE);
		} else if (ConsultasSQL.obtenerClientes()) {
			opcionEliminar = escogerNúmero();
			ConsultasSQL.eliminarRegistro(opcionEliminar, CLIENTE);
		}

	}

	public static int escogerNúmero() {

		int opcionEliminar = 0;
		do {
			System.out.println("Introduce el ID que actúa comoo clave primaria");
			opcionEliminar = tryCatchInt();
			if (opcionEliminar == Errores.ERROR_INT)
				System.out.println(Errores.mostrarMensajeErrorInt());
			else if (opcionEliminar <= 0)
				System.out.println("Tienes que introducir un número mayor que 0");
		} while (opcionEliminar <= 0);
		return opcionEliminar;
	}

	public static void eliminarEmpleado() {

		int opcion = 0;
		int opcionEliminar = 0;
		do {
			System.out.println("¿De que forma te gustaría eliminar a un empleado?");
			System.out.println("1- Insertando su número de empleado");
			System.out.println("2- Mostrando todos los empleados y seleccionar su ID");
			opcion = tryCatchInt();

		} while (!confirmarDatos1_2(opcion));

		if (opcion == 1) {
			opcionEliminar = escogerNúmero();
			ConsultasSQL.eliminarRegistro(opcionEliminar, EMPLEADO);
		} else if (ConsultasSQL.obtenerEmpleados()) {
			opcionEliminar = escogerNúmero();
			ConsultasSQL.eliminarRegistro(opcionEliminar, EMPLEADO);
		}
	}

	public static void eliminarProducto() {

		int opcion = 0;
		int opcionEliminar = 0;
		do {
			System.out.println("¿De que forma te gustaría eliminar un producto?");
			System.out.println("1- Insertando el ID del producto");
			System.out.println("2- Mostrando todos los productos y seleccionar su ID");
			opcion = tryCatchInt();

		} while (!confirmarDatos1_2(opcion));

		if (opcion == 1) {
			opcionEliminar = escogerNúmero();
			ConsultasSQL.eliminarRegistro(opcionEliminar, PRODUCTO);
		} else if (ConsultasSQL.obtenerProductos2()) {
			opcionEliminar = escogerNúmero();
			ConsultasSQL.eliminarRegistro(opcionEliminar, PRODUCTO);
		}
	}
	
	public static void modificarProducto() {

		int opcion = 0;
		int opcionModificar = 0;
		do {
			System.out.println("¿De que forma te gustaría modificar un producto?");
			System.out.println("1- Insertando el ID del producto");
			System.out.println("2- Mostrando todos los productos y seleccionar su ID");
			opcion = tryCatchInt();

		} while (!confirmarDatos1_2(opcion));

		if (opcion == 1) {
			opcionModificar = escogerNúmero();
			modificarDatosProducto(opcionModificar);
		} else if (ConsultasSQL.obtenerProductos2()) {
			opcionModificar = escogerNúmero();
			modificarDatosProducto(opcionModificar);

		}
	}

	private static void modificarDatosProducto(int opcionModificar) {
		
		String nombre = "";
		double precio = 0;
		int stockinicial = 0;
		System.out.println("Vamos a modificar el producto con ID: " + opcionModificar);
		do {
			System.out.println("Introduce el nombre que quieres modificar");
			nombre = teclado.nextLine();
		} while (!cadenaVacia(nombre));

		do {
			System.out.println("Introduce el precio nuevo del producto: " + nombre);
			precio = tryCatchDouble();
		} while (!precioProductoCorrecto(precio));
		do {
			System.out.println("Introduce la cantidad de stock que tendrá " + nombre);
			stockinicial = tryCatchInt();
		} while (!comprobarStock(stockinicial));
		
		ConsultasSQL.actualizarProducto(nombre, precio, stockinicial, opcionModificar);
	}
	
	public static void modificarEmpleado() {

		int opcion = 0;
		int opcionModificar = 0;
		do {
			System.out.println("¿De que forma te gustaría modificar un empleado?");
			System.out.println("1- Insertando el ID del empleado");
			System.out.println("2- Mostrando todos los empleados y seleccionar su ID");
			opcion = tryCatchInt();

		} while (!confirmarDatos1_2(opcion));

		if (opcion == 1) {
			opcionModificar = escogerNúmero();
			modificarDatosEmpleado(opcionModificar);
		} else if (ConsultasSQL.obtenerEmpleados()) {
			opcionModificar = escogerNúmero();
			modificarDatosEmpleado(opcionModificar);
		}
	}

	private static void modificarDatosEmpleado(int opcionModificar) {
		
		int opcionCargo = 0;

		String nombrePersona = "";
		String cargo = "";

		System.out.println("Vamos a modificar los datos del empleado cuyo ID es: " + opcionModificar);
	
		do {
			System.out.println("Introduce el nombre que tiene el empleado");
			nombrePersona = teclado.nextLine();
		} while (!cadenaVacia(nombrePersona));

		do {
			System.out.println("¿Que puesto tendrá el empleado elige un número del 1 al 4?");

			System.out.println("1- Dependiente");
			System.out.println("2- Dependiente, Encargado");
			System.out.println("3- Dependiente, Encargado, Cajero");
			System.out.println("4- Dependiente, Encargado, Cajero, Pistolero");
			opcionCargo = tryCatchInt();
			if (opcionCargo == Errores.ERROR_INT)
				System.out.println(Errores.mostrarMensajeErrorInt());
			else if (opcionCargo < 1 || opcionCargo > 4)
				System.out.println("Debes de introducir un número entre el 1 y el 4");
		} while (opcionCargo < 1 || opcionCargo > 4);


		if (opcionCargo == 1)
			cargo = "Dependiente";
		else if (opcionCargo == 2)
			cargo = "Dependiente,Encargado";
		else if (opcionCargo == 3)
			cargo = "Dependiente,Encargado,Cajero";
		else if (opcionCargo == 4)
			cargo = "Dependiente,Encargado,Cajero,Pistolero";
		
		ConsultasSQL.actualizarEmpleado(nombrePersona, cargo, opcionModificar);

	}
	
	public static void modificarCliente() {
		
		int opcion = 0;
		int opcionModificar = 0;
		do {
			System.out.println("¿De que forma te gustaría modificar un cliente?");
			System.out.println("1- Insertando el ID del cliente");
			System.out.println("2- Mostrando todos los clientes y seleccionar su ID");
			
			opcion = tryCatchInt();

		} while (!confirmarDatos1_2(opcion));

		if (opcion == 1) {
			opcionModificar = escogerNúmero();
			actualizarCliente(opcionModificar);
		} else if (ConsultasSQL.obtenerClientes()) {
			opcionModificar = escogerNúmero();
			actualizarCliente(opcionModificar);
		}
	}
	
	public static void actualizarCliente(int opcionModificar) {
		
		String nombrePersona = "";
		String direccion = "";

		System.out.println("Vamos a modificar los datos del cliente cuyo ID es: " + opcionModificar);
		
		do {
			System.out.println("Introduce el nombre real que tiene el cliente");
			nombrePersona = teclado.nextLine();
		} while (!cadenaVacia(nombrePersona));
		do {
			System.out.println("Introduce la dirección del cliente");
			direccion = teclado.nextLine();
		} while (!cadenaVacia(direccion));
		
		ConsultasSQL.actualizarCliente(nombrePersona, direccion, opcionModificar);
		
	}
	
	

}
