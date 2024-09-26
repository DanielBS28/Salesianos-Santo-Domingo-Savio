import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {

	private String idUsuario;
	private String nombre;
	private String telefono;
	private String email;

	static Scanner teclado = new Scanner(System.in);

	ArrayList<Libro> librosUsuario = new ArrayList<>();

	public Usuario(String idUsuario, String nombre, String telefono, String email) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}

	public Usuario() {

		registrar();
	}

	public void registrar() {

		System.out.println("Dime el identificador del usuario");
		idUsuario = teclado.nextLine();
		System.out.println("Dime el nombre del usuario");
		nombre = teclado.nextLine();
		System.out.println("Dime el telefono del usuario");
		telefono = teclado.nextLine();
		System.out.println("Dime el email del usuario");
		email = teclado.nextLine();
	}

	public void actualizarInfo() {

		System.out.println("Dime el identificador del usuario");
		idUsuario = teclado.nextLine();
		System.out.println("Dime el nombre del usuario");
		nombre = teclado.nextLine();
		System.out.println("Dime el telefono del usuario");
		telefono = teclado.nextLine();
		System.out.println("Dime el email del usuario");
		email = teclado.nextLine();
	}
	
	public ArrayList<Libro> consultarPrestamos(){
		
		return librosUsuario;
	}

}
