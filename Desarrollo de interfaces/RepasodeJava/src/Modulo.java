
public class Modulo {

	private String Nombre;
	private int NumeroHoras;
	private Profesor profesor;
	private boolean convalidable;
	
	
	public Modulo(String nombre, int numeroHoras, Profesor profesor, boolean convalidable) {
		Nombre = nombre;
		NumeroHoras = numeroHoras;
		this.profesor = profesor;
		this.convalidable = convalidable;
	}


	public void informacion() {
		
		System.out.println("Modulo [Nombre=" + Nombre + ", NumeroHoras=" + NumeroHoras + ", convalidable=" + convalidable + "]");
		profesor.ProfesortoString();
	}
	
	
	
	
	
}
