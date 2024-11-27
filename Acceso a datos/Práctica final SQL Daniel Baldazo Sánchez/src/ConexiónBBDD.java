import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexiónBBDD {

	public static void conexion(String consulta) {

		String URL = "jdbc:mysql://localhost:3306/practicafinal";
		String usuario = "root";
		String password = "cfgs";
		String controlador = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(controlador);
			Connection conexion = DriverManager.getConnection(URL, usuario, password);

			if (conexion != null) {
				System.out.println("Conexión correcta");
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				ResultSet rs = sentencia.executeQuery();
				sentencia.getMetaData().getColumnCount();
				while (rs.next()) {
					System.out.println(rs.getString(1));
					System.out.println(rs.getString(2));
				}

			} else {
				System.out.println("No se pudo realizar la conexión a la base de datos");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Hubo un error en la conexión a la base de datos");
		}
	}

}
