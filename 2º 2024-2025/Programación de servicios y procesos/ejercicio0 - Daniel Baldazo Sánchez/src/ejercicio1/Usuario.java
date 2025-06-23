package ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {

	static Scanner teclado = new Scanner(System.in);

	private String idUsuario;
	private String nombre;
	private String telefono;
	private String email;
	ArrayList<Libro> datosUsuario = new ArrayList<>();

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

		System.out.println("Introduce el id de usuario");
		idUsuario = teclado.nextLine();
		System.out.println("Introduce el nombre del usuario de usuario");
		nombre = teclado.nextLine();
		System.out.println("Introduce el telefono del usuario");
		telefono = teclado.nextLine();
		System.out.println("Introduce el email del usuario");
		email = teclado.nextLine();

	}

	public void actualizarInfo() {

		System.out.println("Introduce el id de usuario");
		idUsuario = teclado.nextLine();
		System.out.println("Introduce el nombre del usuario de usuario");
		nombre = teclado.nextLine();
		System.out.println("Introduce el telefono del usuario");
		telefono = teclado.nextLine();
		System.out.println("Introduce el email del usuario");
		email = teclado.nextLine();

	}

	public ArrayList<Libro> consultarPrestamos() {

		return datosUsuario;

	}

	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email
				+ ", datosUsuario=" + datosUsuario + "]";
	}
	
	
}
