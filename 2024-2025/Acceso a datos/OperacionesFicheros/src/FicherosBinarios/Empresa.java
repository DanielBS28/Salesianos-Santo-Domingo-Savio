package FicherosBinarios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Empresa implements Serializable {

	static Scanner teclado = new Scanner(System.in);

	private ArrayList<Empleado_Ejercicio4> EMPLEADOS = new ArrayList<>();

	public Empresa() {

	}

	public void insertarEmpleados() {

		System.out.println("Vamos a registrar a un empleado vamos a solicitar los siguientes datos:");
		System.out.println("Dime el nombre del empleado");
		String nombre = teclado.nextLine();
		System.out.println("Dime el apellido del empleado");
		String apellido = teclado.nextLine();
		System.out.println("Dime el puesto del empleado (Jefe/Trabajador/Becario)");
		String puesto = teclado.nextLine();
		System.out.println("Dime el salario del empleado");
		double salario = teclado.nextDouble();
		teclado.nextLine();
		registrarEmpleado(nombre, apellido, puesto, salario);
	}

	public void registrarEmpleado(String nombre, String apellido, String puesto, double salario) {

		EMPLEADOS.add(new Empleado_Ejercicio4(nombre, apellido, puesto, salario));

	}

	public void cambiarPuestoEmpleado() {

		if (EMPLEADOS.isEmpty()) {
			System.out.println("No hay empleados en la empresa");
			return;
		}

		System.out.println("Dime el nombre del empleado");
		String nombre = teclado.nextLine();
		System.out.println("Dime el apellido del empleado");
		String apellido = teclado.nextLine();

		for (Empleado_Ejercicio4 e : EMPLEADOS) {
			if (e.getNombre().equalsIgnoreCase(nombre) && e.getApellido().equalsIgnoreCase(apellido)) {
				System.out.println("Dime el puesto nuevo del empleado");
				String puesto = teclado.nextLine();
				if (e.getPuesto().equalsIgnoreCase(puesto))
					System.out.println("Has puesto el mismo cargo");
				else
					e.setPuesto(puesto);
			}
		}
	}

	public ArrayList<Empleado_Ejercicio4> listarEmpleadosPuesto() {

		ArrayList<Empleado_Ejercicio4> EmpleadosFiltrados = new ArrayList<>();
		Boolean puestoCorrecto = false;
		String puesto = "";

		do {
			System.out.println("Dime el nombre del puesto (Jefe/Trabajador/Becario)");
			puesto = teclado.nextLine();
			if (puesto.equalsIgnoreCase("Jefe") || puesto.equalsIgnoreCase("Trabajador")
					|| puesto.equalsIgnoreCase("Becario"))
				puestoCorrecto = true;
			else
				System.out.println("Has introducido mal los datos");
		} while (!puestoCorrecto);
		for (Empleado_Ejercicio4 e : EMPLEADOS) {
			if (e.getPuesto().equalsIgnoreCase(puesto)) {
				EmpleadosFiltrados.add(e);
			}
		}
		return EmpleadosFiltrados;

	}

	public ArrayList<Empleado_Ejercicio4> listarEmpleadosSalario() {

		ordenarArray();
		return EMPLEADOS;

	}

	private void ordenarArray() {

		Collections.sort(EMPLEADOS, Comparator.comparingDouble(Empleado_Ejercicio4::getSalario));

	}
	

}
