package RepasoExamen;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio1 {

	static String ruta = "src/RepasoExamen/ejercicio1Examen.txt";
	static ArrayList<Persona> PERSONAS = new ArrayList<>();
	static Scanner teclado = new Scanner(System.in);

	static void lecturaArchivo() {

		try {
			BufferedReader bf = new BufferedReader(new FileReader(ruta));
			String linea = "";

			while ((linea = bf.readLine()) != null) {

				String[] campos = linea.split(";");
				PERSONAS.add(new Persona(campos[0], campos[1], campos[2]));

			}

			bf.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Persona login() {

		boolean nombreCorrecto = false;
		boolean contrasenaCorrecta = false;
		String nombre = "";
		String contrasena = "";

		do {
			System.out.println("Introduce los datos para iniciar sesión");
			System.out.println("Introduce el nombre del usuario");
			nombre = teclado.nextLine();
			nombreCorrecto = comprobarNombre(nombre);
			if (!nombreCorrecto)
				System.out.println("Nombre incorrecto");

		} while (!nombreCorrecto);

		do {
			System.out.println("Introduce la contraseña del usuario");
			contrasena = teclado.nextLine();
			contrasenaCorrecta = comprobarContrasena(nombre, contrasena);
			if (!contrasenaCorrecta)
				System.out.println("Contraseña incorrecta");
		} while (!contrasenaCorrecta);

		Persona elegida = obtenerPersona(nombre, contrasena);

		return elegida;

	}

	private static Persona obtenerPersona(String nombre, String contrasena) {
		Persona persona = null;

		for (Persona p : PERSONAS) {
			if (p.getNombre().equals(nombre) && p.getContrasena().equals(contrasena))
				persona = p;
		}
		return persona;
	}

	private static boolean comprobarNombre(String nombre) {

		for (Persona p : PERSONAS) {
			if (p.getNombre().equals(nombre))
				return true;
		}
		return false;
	}

	private static boolean comprobarContrasena(String nombre, String contrasena) {

		for (Persona p : PERSONAS) {
			if (p.getNombre().equals(nombre) && p.getContrasena().equals(contrasena))
				return true;
		}
		return false;
	}

	private static void mostrarMenu(Persona personaSeleccionada) {

		if (personaSeleccionada.getRol().equals("administrador")) {
			mostrarMenuAdmin(personaSeleccionada);

		} else if (personaSeleccionada.getRol().equals("usuario")) {
			mostrarMenuUsuario(personaSeleccionada);
		} else if (personaSeleccionada.getRol().equals("lector")) {
			mostrarMenuLector(personaSeleccionada);
		}
	}

	private static void mostrarMenuAdmin(Persona personaSeleccionada) {
		int opcion = 0;

		System.out.println("Iniciada sesión como: " + personaSeleccionada.getNombre());
		do {

			System.out.println("Seleccione una opción");
			System.out.println("0- Cerrar Sesión");
			System.out.println("1- Dar de alta a un usuario");
			System.out.println("2- Mostrar datos de los usuarios");

			opcion = teclado.nextInt();
			teclado.nextLine();

			if (opcion == 1) {
				darDeAltaUsuario();
			} else if (opcion == 2)
				mostrarDatosUsuarios();
			else if (opcion == 0)
				System.out.println("Cerrando Sesión...");
			else
				System.out.println("Opción no reconocida");

		} while (opcion != 0);
	}

	private static void mostrarDatosUsuarios() {

		for (Persona p : PERSONAS) {
			System.out.print("Nombre: " + p.getNombre());
			System.out.print(", Contraseña: " + asteriscos(p));
			System.out.println(", Cargo: " + p.getRol());

		}
	}

	private static String asteriscos(Persona p) {

		String asteriscos = "";
		int i = 0;

		while (i < p.getContrasena().length()) {

			asteriscos += "*";
			i++;
		}
		return asteriscos;
	}

	private static void darDeAltaUsuario() {

		boolean cargoCorrecto = false;
		String cargo = "";

		System.out.println("Dime el nombre del usuario");
		String nombre = teclado.nextLine();
		System.out.println("Introduce una contraseña para el usuario");
		String contrasena = teclado.nextLine();
		do {
			System.out.println("Introduce el cargo de la persona (administrador/usuario/lector)");
			cargo = teclado.nextLine();

			if (cargo.equals("administrador") || cargo.equals("usuario") || cargo.equals("lector"))
				cargoCorrecto = true;
			else
				System.out.println("Has introducido un cargo incorrecto");
		} while (!cargoCorrecto);

		PERSONAS.add(new Persona(nombre, contrasena, cargo));
		System.out.println("Persona agregada correctamente");
		escribirEnFichero(nombre, contrasena, cargo);
	}

	private static void escribirEnFichero(String nombre, String contrasena, String cargo) {

		String nuevoUsuario = nombre+";"+contrasena+";"+cargo+"\n";
		try {
			BufferedWriter bf = new BufferedWriter(new FileWriter(ruta,true));
			
			bf.write(nuevoUsuario);
			
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void mostrarMenuUsuario(Persona personaSeleccionada) {

		int opcion = 0;
		System.out.println("Iniciada sesión como: " + personaSeleccionada.getNombre());

		do {

			System.out.println("Seleccione una opción");
			System.out.println("0- Cerrar Sesión");
			System.out.println("1- Mostrar la cantidad de personas por cargo");
			opcion = teclado.nextInt();
			teclado.nextLine();

			if (opcion == 0)
				System.out.println("Cerrando sesión...");
			else if (opcion == 1)
				mostrarCantidadCargos();
			else
				System.out.println("Opción no reconocida");

		} while (opcion != 0);

	}

	private static void mostrarCantidadCargos() {

		int[] cargos = new int[3];

		for (Persona p : PERSONAS) {
			if (p.getRol().equals("administrador"))
				cargos[0]++;
			else if (p.getRol().equals("usuario"))
				cargos[1]++;
			else if (p.getRol().equals("lector"))
				cargos[2]++;
		}
		System.out.println("Hay " + cargos[0] + (cargos[0] == 1 ? " administrador." : " administradores."));
		System.out.println("Hay " + cargos[1] + (cargos[1] == 1 ? " usuario." : " usuarios."));
		System.out.println("Hay " + cargos[2] + (cargos[2] == 1 ? " lector." : " lectores."));

	}

	private static void mostrarMenuLector(Persona personaSeleccionada) {

		int opcion = 0;
		System.out.println("Iniciada sesión como: " + personaSeleccionada.getNombre());

		do {

			System.out.println("Seleccione una opción");
			System.out.println("0- Cerrar Sesión");
			System.out.println("1- Mostrar mensaje de bienvenida");
			opcion = teclado.nextInt();
			teclado.nextLine();

			if (opcion == 0)
				System.out.println("Cerrando sesión...");
			else if (opcion == 1)
				mostrarMensajeBienvenida(personaSeleccionada);
			else
				System.out.println("Opción no reconocida");

		} while (opcion != 0);

	}

	private static void mostrarMensajeBienvenida(Persona personaSeleccionada) {

		System.out.println("¡Bienvenido/a " + personaSeleccionada.getNombre() + "!");

	}

	private static void mostrarMenuPrincipal() {

		int opcion = 0;

		do {
			System.out.println("BIENVENID@ A LA APLICACIÓN DE DANIEL");

			System.out.println("Seleccione una opción");
			System.out.println("0- Finalizar el programa");
			System.out.println("1- Iniciar Sesión");
			opcion = teclado.nextInt();
			teclado.nextLine();

			if (opcion == 0) {
				System.out.println("Saliendo de la aplicación...");
				System.out.println("Saliste de la aplicación");
			} else if (opcion == 1) {
				Persona PersonaSeleccionada = login();
				mostrarMenu(PersonaSeleccionada);
			} else
				System.out.println("Opción no reconocida");

		} while (opcion != 0);

	}

	public static void main(String[] args) {

		lecturaArchivo();
		mostrarMenuPrincipal();

	}

}
