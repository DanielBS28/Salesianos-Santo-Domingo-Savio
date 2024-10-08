package FicherosBinarios;

import java.util.Scanner;

public class Alumno {

	private String nombre;
	private String apellido;
	private double nota = -1;

	static Scanner teclado = new Scanner(System.in);

	public Alumno(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public double getNota() {
		return nota;
	}

	public void setNota() {
		double nota;
		do {
			System.out.println("Dime la nota (0-10) del alumno: " + getNombre() + " " + getApellido());

			nota = teclado.nextDouble();
			teclado.nextLine();
			
			if(nota < 0 && nota > 10)
				System.out.println("Nota incorrecta por favor vuelve a intentarlo tiene que estar entre 0 y 10 se permiten decimales");
		} while (nota < 0 && nota > 10);
		
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Alumno [nombre= " + nombre + ", apellido= " + apellido + ", nota= " + nota + "]";
	}


	
	
	

}
