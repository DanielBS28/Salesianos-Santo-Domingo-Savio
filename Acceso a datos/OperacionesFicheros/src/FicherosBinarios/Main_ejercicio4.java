package FicherosBinarios;

import java.io.*;
import java.util.Scanner;

public class Main_ejercicio4 {
	
	static String nombreFichero = "ejercicio4.bin";
	static Scanner teclado = new Scanner(System.in);


	public void escribirFichero(String nombreFichero) {
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(nombreFichero)));
			
			oos.writeObject(oos);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void leerFichero() {

		
	}
	
	public static void mostrarMenu() {
		int opcion = 0;
		
		do {

			System.out.println("********************************************");
			System.out.println("Selecciona la acción que deseas realizar");
			System.out.println("0- Salir");
			System.out.println("1- Dar de alta a empleado");
			System.out.println("2- Cambiar de puesto a un empleado");
			System.out.println("3- Listar empleados por puesto introducido");
			System.out.println("4- Listar los empleados por rango de salario");
			System.out.println("********************************************");

			opcion = teclado.nextInt();
			teclado.nextLine();

			if (opcion == 0)
				System.out.println("Saliste del programa, ¡Hasta pronto!");
			else if (opcion == 1)
			
			else if (opcion == 2)
				
			else if (opcion == 3)
				
			else if (opcion == 4)
				
			else
				System.out.println("Opción no reconocida, por favor vuelve a intentarlo");

		} while (opcion != 0);
	}

	public static void main(String[] args) {
		
		Empresa Daniel = new Empresa();
		mostrarMenu();
		

	}

}
