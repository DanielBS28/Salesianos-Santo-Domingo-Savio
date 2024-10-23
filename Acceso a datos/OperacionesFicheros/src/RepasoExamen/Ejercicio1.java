package RepasoExamen;

import java.io.*;
import java.util.ArrayList;
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
			System.out.println("Nombre incorrecto");

		} while (!nombreCorrecto);

		do {
			System.out.println("Introduce la contraseña del usuario");
			contrasena = teclado.nextLine();
			contrasenaCorrecta = comprobarContrasena(contrasena);
			if (!contrasenaCorrecta)
				System.out.println("Contraseña incorrecta");
		} while (!contrasenaCorrecta);

		Persona elegida = obtenerPersona(nombre, contrasena);

		return elegida;

	}

	private static Persona obtenerPersona(String nombre, String contrasena) {
		Persona persona = null;

		for (Persona p : PERSONAS) {
			if (p.getNombre().equals(nombre) && p.getContrasena().equals(p))
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

	private static boolean comprobarContrasena(String contrasena) {

		for (Persona p : PERSONAS) {
			if (p.getNombre().equals(contrasena))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {

		lecturaArchivo();
		login();

	}

}
