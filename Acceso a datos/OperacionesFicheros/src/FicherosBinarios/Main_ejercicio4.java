package FicherosBinarios;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_ejercicio4 {

	static String nombreFichero = "ejercicio4.bin";
	static Scanner teclado = new Scanner(System.in);
	static ArrayList <Empleado_Ejercicio4> EMPLEADOS = new ArrayList<>();

	public static void escribirFichero(String nombreFichero, ArrayList <Empleado_Ejercicio4> Empleados) {

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(nombreFichero)));

			oos.writeObject(Empleados);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void leerFichero(String nombreFichero) {

		ArrayList<Empleado_Ejercicio4> Empleados = new ArrayList<>();

		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(new File(nombreFichero)));

			Empleados = (ArrayList<Empleado_Ejercicio4>) ois.readObject();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Empleado_Ejercicio4 e : Empleados)
			System.out.println(e);

	}

	public static void mostrarMenu(Empresa empresa) {
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
				empresa.insertarEmpleados();
			else if (opcion == 2)
				empresa.cambiarPuestoEmpleado();
			else if (opcion == 3) {
				EMPLEADOS = empresa.listarEmpleadosPuesto();
				escribirFichero(nombreFichero, EMPLEADOS);
				leerFichero(nombreFichero);
			}
			else if (opcion == 4) {
				EMPLEADOS = empresa.listarEmpleadosSalario();
				escribirFichero(nombreFichero, EMPLEADOS);
				leerFichero(nombreFichero);
			}
			else
				System.out.println("Opción no reconocida, por favor vuelve a intentarlo");

		} while (opcion != 0);
	}

	public static void main(String[] args) {

		Empresa Daniel = new Empresa();
		mostrarMenu(Daniel);

	}

}
