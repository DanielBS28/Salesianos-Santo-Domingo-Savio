
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


	public String informacion() {
		
		return "Modulo [Nombre=" + Nombre + ", NumeroHoras=" + NumeroHoras + ", convalidable=" + convalidable +
		profesor.toString();
	}


	@Override
	public String toString() {
		return "Modulo [Nombre=" + Nombre + ", NumeroHoras=" + NumeroHoras + ", profesor=" + profesor.getNombre()
				+ ", convalidable=" + convalidable + "]";
	}
	
	
	
	
	
	
	
	
}
