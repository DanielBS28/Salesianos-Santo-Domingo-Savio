
public class Profesor extends Persona{
	
	private int Asignaturas;
	private boolean Tutor;
	private double Salario ;
	
	public Profesor(String dNI, String nombre, String apellidos, int asignaturas, boolean tutor, double Salario) {
		super(dNI, nombre, apellidos);
		Asignaturas = asignaturas;
		Tutor = tutor;
		this.Salario = Salario;
	}

	public String toString() {
		
		return PersonatoString() + ", Asignaturas=" + Asignaturas + ", Tutor=" + Tutor + ", Salario= "+ Salario +"]";
	}
	
	
	
	
	
	
	
	
	
	
	
	




}
