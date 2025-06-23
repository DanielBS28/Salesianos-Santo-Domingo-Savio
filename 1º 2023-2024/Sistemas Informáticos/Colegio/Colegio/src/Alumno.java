
public class Alumno extends Persona {
	
	boolean becado; //true (becado), false (no becado)

	// Método constructor
	public Alumno(String nombre, String apellidos, int edad, char sexo, boolean becado) {
		super(nombre, apellidos, edad, sexo);
		this.becado = becado;
	}

	// Getters & Setters
	public boolean isBecado() {
		return becado;
	}

	public void setBecado(boolean becado) {
		this.becado = becado;
	}

	// Método toString para imprimir objetos Alumno
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", sexo=" + sexo
				+ ", becado=" + becado + "]";
	}
	
	

}
