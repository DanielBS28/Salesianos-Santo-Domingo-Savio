import java.io.*;
import java.sql.*;

public class Main {

	public static void main(String[] args) {

		String URL = "jdbc:mysql://localhost/nba";
		String usuario = "root";
		String password = "cfgs";
		String controlador = "com.mysql.cj.jdbc.Driver";

		// JDBC Conector de java con MySQL

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);
			
			System.out.println(conexion != null ? "Conexion correcta" : "No se ha podido realizar la conexion");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
