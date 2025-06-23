
public class Pas extends Persona {
	
	int numHoras;

	// Método constructor
	public Pas(String nombre, String apellidos, int edad, char sexo, int numHoras) {
		super(nombre, apellidos, edad, sexo);
		this.numHoras = numHoras;
	}

	// Getters & Setters
	public int getNumHoras() {
		return numHoras;
	}

	public void setNumHoras(int numHoras) {
		this.numHoras = numHoras;
	}

	// Imprimir objetos Pas
	@Override
	public String toString() {
		return "Pas [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", sexo=" + sexo
				+ ", numHoras=" + numHoras + "]";
	}
	
	

}
