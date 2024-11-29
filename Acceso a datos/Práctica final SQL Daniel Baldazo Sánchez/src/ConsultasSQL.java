import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	public static void visualizarProductos(int Bandera) {

		String consulta = "";

		if (Bandera == Utilidades.INICIAL)
			System.out.println("Falta por hacer la función");
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
				ResultSet rs = sentencia.executeQuery();

				while (rs.next()) {
					System.out.print("ID: " + rs.getString(1) + " | ");
					System.out.print("NOMBRE: " + rs.getString(2) + " | ");
					System.out.print("PRECIO UNITARIO: " + rs.getString(3) + " | ");
					System.out.println("STOCK: " + rs.getString(4));
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static void visualizarTickets(String alias, char Bandera) {

		boolean encontrado = false;
		String consulta = "";

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);

			String identificador = obtenerCodigo_porAlias(alias, Bandera);

			if (Bandera == Utilidades.EMPLEADO)
				consulta = "select * from ticket where Empleado_codigoEmpleado =?";
			else
				consulta = "select * from ticket where Cliente_numerodecliente =?";

			if (conexion != null) {
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				sentencia.setString(1, identificador);

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

	public static String obtenerCodigo_porAlias(String alias, char Bandera) {

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
					return rs.getString(tipo);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
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

}
