package LecturaEscritura;

public class Fruta {
	
	String Nombre;
	int cantidad = 0;
	
	public Fruta(String nombre) {
	
		Nombre = nombre;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	@Override
	public String toString() {
		return  Nombre + " -> cantidad = " + cantidad;
	}
	
	
	

}
