import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class Main {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String URL = "jdbc:mysql://localhost:3306/nba";
		String usuario = "root";
		String password = "cfgs";
		String controlador = "com.mysql.cj.jdbc.Driver";
		String consulta = "Select * from equipos where Nombre =? or Conferencia=?";
		String nombre = "";

		// JDBC Conector de java con MySQL

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);

			if (conexion != null) {
				System.out.println("Conexión correcta");
				// Statement para ejecutar una consulta o actualizaciones

				/*
				 * Statement s = conexion.createStatement();
				 * 
				 * System.out.println("Dime el nombre que quieres filtrar: "); nombre =
				 * teclado.nextLine().trim(); //ResultSet rs =
				 * s.executeQuery("Select * from equipos where Nombre like 'B%'"); ResultSet rs
				 * = s.executeQuery("Select * from equipos where Nombre = '"+nombre+ "'");
				 * 
				 * while(rs.next()) { System.out.print(rs.getString("Nombre")); // es el nombre
				 * de la columna.
				 * 
				 * System.out.println(rs.getString(1)); // es la columna, empieza en 1 }
				 */

				// Sin inyeciones SQL

				System.out.println("Dime el nombre que quieres filtrar: ");
				nombre = teclado.nextLine().trim();
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				sentencia.setString(1, nombre);
				sentencia.setString(2, "East");
				ResultSet rs = sentencia.executeQuery();
				while (rs.next()) {
					System.out.print(rs.getString("Nombre")); // es el nombre de la columna.

					System.out.println(rs.getString(1)); // es la columna, empieza en 1
				}

			} else {
				System.out.println("No hay conexion");

			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
