
public class Profesor extends Persona {
	
	String categoria;

	// Método constructor
	public Profesor(String nombre, String apellidos, int edad, char sexo, String categoria) {
		super(nombre, apellidos, edad, sexo);
		this.categoria = categoria;
	}

	// Getters & Setters
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	// Método toString para imprimir objetos Profesor
	@Override
	public String toString() {
		return "Profesor [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", sexo=" + sexo
				+ ", categoria=" + categoria + "]";
	}
	
	

}
