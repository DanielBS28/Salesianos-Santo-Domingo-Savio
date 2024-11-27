
public class Main {

	public static void main(String[] args) {


		ConexiónBBDD.conexion("select * from usuario inner join cliente on usuario.Alias = cliente.Usuario_Alias;");

	}

}
