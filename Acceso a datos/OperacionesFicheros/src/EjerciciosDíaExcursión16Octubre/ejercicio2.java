package EjerciciosDíaExcursión16Octubre;

import java.io.*;
import java.util.ArrayList;

public class ejercicio2 {

	/*
	 * Crea un programa que lea un fichero de texto que contiene información sobre
	 * empleados de una empresa, incluyendo su nombre, salario y horas trabajadas.
	 * Luego, el programa calculará el salario total a pagar, la media de salarios,
	 * y generará un informe que detalle el salario de cada empleado y su estado
	 * (por encima o por debajo del salario promedio). Juan,3000,40 María,2500,35
	 * Pedro,4500,50 Lucía,3200,45 Antonio,2800,38
	 */

	private static void leerFichero(String ruta) {

		ArrayList<Empleado> EMPLEADOS = new ArrayList<>();
		String linea = "";

		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta));

			while ((linea = br.readLine()) != null) {

				String[] campos = linea.split(",");

				EMPLEADOS.add(new Empleado(campos[0], Double.parseDouble(campos[1]), Integer.parseInt(campos[2])));

			}
			br.close();

			extraerDatos(EMPLEADOS);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void extraerDatos(ArrayList<Empleado> EMPLEADOS) {

		double salarioTotal = obtenerSalarios(EMPLEADOS);
		double mediaSalarios = salarioTotal / EMPLEADOS.size();

		System.out.println("************************************************************");
		System.out.println("El salario total a pagar es: " + salarioTotal+"€");
		System.out.println("La media de los salarios de los empleados es: " + mediaSalarios+"€");
		System.out.println("************************************************************");
		System.out.println("DATOS DE LOS EMPLEADOS");
		System.out.println("------------------------");

		

		for (Empleado e : EMPLEADOS) {

			if (e.getSueldo() > mediaSalarios)
				System.out
						.println("El empleado " + e + " tiene un salario SUPERIOR a la media");
			else
				System.out.println("El empleado " + e + " tiene un salario MENOR a la media");
		}

	}

	private static double obtenerSalarios(ArrayList<Empleado> EMPLEADOS) {
		int salarioTotal = 0;

		for (int i = 0; i < EMPLEADOS.size(); i++)
			salarioTotal += EMPLEADOS.get(i).getSueldo();

		return salarioTotal;
	}

	public static void main(String[] args) {

		String ruta = "src/EjerciciosDíaExcursión16Octubre/ejercicio2.txt";
		leerFichero(ruta);

	}

}
