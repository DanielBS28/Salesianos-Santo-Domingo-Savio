
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class ConsultasSQL {

	final static String URL = "jdbc:mysql://localhost:3306/practicafinal";
	final static String usuario = "root";
	final static String password = "cfgs";
	final static String controlador = "com.mysql.cj.jdbc.Driver";

	public static void usuariosContraseñas() {

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);

			String consulta = "select alias, clave, rol from usuario;";

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				ResultSet rs = sentencia.executeQuery();

				while (rs.next()) {
					System.out.print("ALIAS: " + rs.getString(1) + " | ");
					System.out.print("CLAVE: " + rs.getString(2) + " | ");
					System.out.println("ROL: " + rs.getString(3));
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static String login(String alias, String contraseña) {

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);
			String consulta = "Select rol from usuario where alias =? and clave=?";

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				sentencia.setString(1, alias);
				sentencia.setString(2, contraseña);
				ResultSet rs = sentencia.executeQuery();

				while (rs.next()) {
					return rs.getString("rol");
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		System.out.println("No se ha podido encontrar el alias o la contraseña es incorrecta");
		return "";
	}

	public static int obtenerPuntos(int numeroDeCliente) {

		String alias = obtenerAliasPorNumeroDeCliente(numeroDeCliente);

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);
			String consulta = "Select puntos from usuario where Alias =?";

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				sentencia.setString(1, alias);
				ResultSet rs = sentencia.executeQuery();

				while (rs.next()) {
					return rs.getInt("puntos");
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return 0;

	}

	private static String obtenerAliasPorNumeroDeCliente(int numeroDeCliente) {

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);
			String consulta = "Select Usuario_Alias from cliente where numerodecliente =?";

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				sentencia.setInt(1, numeroDeCliente);
				ResultSet rs = sentencia.executeQuery();

				while (rs.next()) {
					return rs.getString("Usuario_Alias");
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void visualizarProductos(int Bandera, char letra) {

		String consulta = "";
		boolean encontrado = false;

		if (Bandera == Utilidades.INICIAL)
			consulta = "select * from producto where Nombre like?;";
		else if (Bandera == Utilidades.MAYOR_MENOR_PRECIO)
			consulta = "select * from producto order by PrecioUnitario desc;";
		else if (Bandera == Utilidades.MENOR_MAYOR_PRECIO)
			consulta = "select * from producto order by PrecioUnitario asc;";
		else if (Bandera == Utilidades.MAYOR_MENOR_STOCK)
			consulta = "select * from producto order by Stock desc;";
		else if (Bandera == Utilidades.MENOR_MAYOR_STOCK)
			consulta = "select * from producto order by Stock asc;";

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				if (Bandera == Utilidades.INICIAL)
					sentencia.setString(1, letra + "%");

				ResultSet rs = sentencia.executeQuery();

				while (rs.next()) {
					System.out.print("ID: " + rs.getString(1) + " | ");
					System.out.print(rs.getString(2) + " | ");
					System.out.print("Precio unitario: " + rs.getString(3) + "€ | ");
					System.out.println("Stock: " + rs.getString(4));
					encontrado = true;
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if (!encontrado)
			System.out.println("No se han encontrado productos que empiezen con la letra: " + letra);
	}

	public static void visualizarTickets(String alias, char Bandera) {

		boolean encontrado = false;
		String consulta = "";

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);

			int identificador = obtenerCodigo_porAlias(alias, Bandera);

			if (Bandera == Utilidades.EMPLEADO)
				consulta = "select * from ticket where Empleado_codigoEmpleado =?";
			else
				consulta = "select * from ticket where Cliente_numerodecliente =?";

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				sentencia.setInt(1, identificador);

				ResultSet rs = sentencia.executeQuery();

				while (rs.next()) {
					System.out.print("ID_Ticket: " + rs.getString(1) + " | ");
					System.out.print("Precio total: " + rs.getString(2) + "€ | ");
					System.out.print("Codigo de empleado: " + rs.getString(3) + " | ");
					System.out.println("Numero de cliente: " + rs.getString(4));
					encontrado = true;
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		if (!encontrado)
			System.out.println("No se han encontrado tickets del usuario: " + alias
					+ " para mostrar, volviendo al menú principal...");
	}

	public static int obtenerCodigo_porAlias(String alias, char Bandera) {

		String consulta = "";
		String tipo = Bandera == Utilidades.EMPLEADO ? "codigoEmpleado" : "numerodecliente";
		if (Bandera == Utilidades.EMPLEADO)
			consulta = "select codigoEmpleado from empleado where Usuario_Alias =?";
		else
			consulta = "select numerodecliente from cliente where Usuario_Alias =?";

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				sentencia.setString(1, alias);
				ResultSet rs = sentencia.executeQuery();

				while (rs.next()) {
					return rs.getInt(tipo);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static String obtenerCliente(int numerodecliente) {

		boolean encontrado = false;
		String consulta = "";

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);

			consulta = "select * from cliente where numerodecliente =?";

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				sentencia.setInt(1, numerodecliente);

				ResultSet rs = sentencia.executeQuery();

				while (rs.next()) {
					encontrado = true;
					return rs.getString("Nombre");
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		if (!encontrado)
			System.out.println("No se ha encontrado ningún cliente con número de cliente: " + numerodecliente);
		return "";

	}

	public static ArrayList<Producto> obtenerProductos() {

		ArrayList<Producto> TODOSLOSPRODUCTOS = new ArrayList<>();
		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);
			String consulta = "Select * from producto;";

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				ResultSet rs = sentencia.executeQuery();

				while (rs.next()) {
					TODOSLOSPRODUCTOS.add(new Producto(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4)));
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return TODOSLOSPRODUCTOS;

	}

	public static void insertarTicket(int ticket, double precioTotal, int codigoEmpleado, int numeroCliente) {
		String consulta = "insert into Ticket (idTicket, PrecioTotal, Empleado_codigoEmpleado, Cliente_numerodecliente) "
				+ "values (?, ?, ?, ?)";

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);

				sentencia.setInt(1, ticket);
				sentencia.setDouble(2, precioTotal);
				sentencia.setInt(3, codigoEmpleado);
				sentencia.setInt(4, numeroCliente);

				sentencia.executeUpdate();

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertarCantidadProducto(int idTicket, int idProducto, int cantidad) {

		String consulta = "insert into cantidadproducto (Ticket_idTicket, Producto_idProducto, Cantidad) "
				+ "VALUES (?, ?, ?)";

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);

				sentencia.setInt(1, idTicket);
				sentencia.setInt(2, idProducto);
				sentencia.setInt(3, cantidad);
				sentencia.executeUpdate();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static void actualizarStockProducto(int idProducto, int cantidad) {
		String consulta = "update producto set Stock = Stock - ? WHERE idProducto = ?";

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);

				sentencia.setInt(1, cantidad);
				sentencia.setInt(2, idProducto);

				sentencia.executeUpdate();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static int contarTickets() {
		String consulta = "select count(*) FROM ticket;";
		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				ResultSet rs = sentencia.executeQuery();

				if (rs.next()) {
					return rs.getInt(1);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public static void sumarPuntos(int puntos, int numerodecliente) {
		String consulta = "update usuario set puntos = puntos + ? where Alias = ?";

		String alias = obtenerAliasPorNumeroDeCliente(numerodecliente);
		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);

				sentencia.setInt(1, puntos);
				sentencia.setString(2, alias);
				sentencia.executeUpdate();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public static void restarPuntos(int puntos, int numerodecliente) {
		String consulta = "update usuario set puntos = puntos - ? where Alias = ?";

		String alias = obtenerAliasPorNumeroDeCliente(numerodecliente);
		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);

				sentencia.setInt(1, puntos);
				sentencia.setString(2, alias);
				sentencia.executeUpdate();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public static void insertarUsuario(String alias, String contraseña, String rol) {

		String consulta = "insert into usuario (Alias, Clave, rol, puntos) VALUES (?, ?, ?, ?);";

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);

				sentencia.setString(1, alias);
				sentencia.setString(2, contraseña);
				sentencia.setString(3, rol);
				sentencia.setInt(4, 0);

				sentencia.executeUpdate();

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public static void insertarEmpleado(String nombre, String alias, String puesto) {

		String consulta = "insert into empleado (Nombre, fechaIngreso, puesto, Usuario_Alias) VALUES (?, ?, ?, ?);";
		Date fechaRegistro = new Date();

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);

				sentencia.setString(1, nombre);
				sentencia.setDate(2, new java.sql.Date(fechaRegistro.getTime()));
				sentencia.setString(3, puesto);
				sentencia.setString(4, alias);

				sentencia.executeUpdate();

				System.out
						.println("El empleado: " + nombre + " con alias: " + alias + " se ha insertado correctamente");

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public static void insertarCliente(String nombre, String direccion, String alias) {

		String consulta = "insert into cliente (Nombre, Direccion, Usuario_Alias) values (?, ?, ?);";

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);

				sentencia.setString(1, nombre);
				sentencia.setString(2, direccion);
				sentencia.setString(3, alias);
				sentencia.executeUpdate();

				System.out.println("El cliente: " + nombre + " con alias: " + alias + " se ha insertado correctamente");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public static void insertarProducto(String nombre, double precio, int stock) {

		String consulta = "insert into producto (Nombre, PrecioUnitario, Stock) values (?, ?, ?);";

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);

				sentencia.setString(1, nombre);
				sentencia.setDouble(2, precio);
				sentencia.setInt(3, stock);
				sentencia.executeUpdate();

				System.out.println("El producto: " + nombre + " se ha insertado correctamente");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public static void eliminarRegistro(int numerodecliente, char Bandera) {

		String consulta = "";
		if (Bandera == Utilidades.CLIENTE)
			consulta = "delete from cliente where numerodecliente = ?";
		else if (Bandera == Utilidades.EMPLEADO)
			consulta = "delete from empleado where codigoEmpleado = ?";
		else if (Bandera == Utilidades.PRODUCTO)
			consulta = "delete from producto where idProducto = ?";

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);

				sentencia.setInt(1, numerodecliente);
				sentencia.executeUpdate();

				System.out.println("El registro se ha eliminado correctamente");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public static boolean obtenerClientes() {

		boolean encontrado = false;

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);
			String consulta = "Select * from cliente;";

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				ResultSet rs = sentencia.executeQuery();

				while (rs.next()) {
					System.out.print("ID: " + rs.getString(1) + " | ");
					System.out.print("Nombre: " + rs.getString(2) + " | ");
					System.out.println("Alias: " + rs.getString(4));
					encontrado = true;
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		if (encontrado)
			return true;
		else {
			System.out.println("No se han encontrado clientes");
			return false;
		}
	}

	public static boolean obtenerEmpleados() {

		boolean encontrado = false;

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);
			String consulta = "Select * from empleado;";

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				ResultSet rs = sentencia.executeQuery();

				while (rs.next()) {
					System.out.print("ID: " + rs.getString(1) + " | ");
					System.out.print("Nombre: " + rs.getString(2) + " | ");
					System.out.print("Puesto: " + rs.getString(4) + " | ");
					System.out.println("Alias: " + rs.getString(5));
					encontrado = true;
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		if (encontrado)
			return true;
		else {
			System.out.println("No se han encontrado empleados");
			return false;
		}
	}

	public static boolean obtenerProductos2() {

		boolean encontrado = false;

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);
			String consulta = "Select * from producto;";

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				ResultSet rs = sentencia.executeQuery();

				while (rs.next()) {
					System.out.print("ID: " + rs.getString(1) + " | ");
					System.out.print("Nombre: " + rs.getString(2) + " | ");
					System.out.print("Precio unitario: " + rs.getString(3) + "€ | ");
					System.out.println("Stock: " + rs.getString(4));
					encontrado = true;
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		if (encontrado)
			return true;
		else {
			System.out.println("No se han encontrado productos");
			return false;
		}
	}

	public static void actualizarProducto(String nombre, double precio, int stock, int id) {

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);
			String consulta = "update producto SET Nombre = ?, PrecioUnitario = ?, Stock = ? where idProducto = ?";

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				sentencia.setString(1, nombre);
				sentencia.setDouble(2, precio);
				sentencia.setInt(3, stock);
				sentencia.setInt(4, id);

				sentencia.executeUpdate();
			}
			System.out.println("El producto se ha actualizado correctamente");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static void actualizarEmpleado(String nombre, String puesto, int id) {

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);
			String consulta = "update empleado SET Nombre = ?, puesto = ? where codigoEmpleado = ?";

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				sentencia.setString(1, nombre);
				sentencia.setString(2, puesto);
				sentencia.setInt(3, id);

				sentencia.executeUpdate();
			}
			System.out.println("El empleado se ha actualizado correctamente");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static void actualizarCliente(String nombre, String direccion, int id) {

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);
			String consulta = "update cliente SET Nombre = ?, Direccion = ? where numerodecliente = ?";

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				sentencia.setString(1, nombre);
				sentencia.setString(2, direccion);
				sentencia.setInt(3, id);

				sentencia.executeUpdate();
			}
			System.out.println("El cliente se ha actualizado correctamente");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean obtenerNombreCompra(String nombre) {
		String consulta = "select * from cliente where Nombre like ?";
		boolean encontrado = false;

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);

				sentencia.setString(1, nombre + "%");
				ResultSet rs = sentencia.executeQuery();

				while (rs.next()) {
					System.out.print("ID: " + rs.getString(1) + " | ");
					System.out.print("Nombre: " + rs.getString(2) + " | ");
					System.out.print("Dirección: " + rs.getString(3) + " | ");
					System.out.println("Alias: " + rs.getString(4));
					encontrado = true;
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		if (encontrado)
			return true;
		else {
			System.out.println("No se han encontrado clientes que tengan la cadena de texto: " + nombre);
			return false;
		}
	}
	
	public static boolean estaEnVenta(String id) {
		String consulta = "select * from producto where idProducto =?";
		boolean encontrado = false;

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);

				sentencia.setString(1, id);
				ResultSet rs = sentencia.executeQuery();

				while (rs.next()) {
					encontrado = true;
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return encontrado;
		}
	}

