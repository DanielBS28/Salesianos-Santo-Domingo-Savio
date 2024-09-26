
public class Directivo extends Persona{
	
	
	private boolean Salesiano;
	private char Turno;
	private double Salario;
	
	public Directivo(String dNI, String nombre, String apellidos, boolean salesiano, char turno, double Salario) {
		super(dNI, nombre, apellidos);
		Salesiano = salesiano;
		Turno = turno;
		this.Salario = Salario;
	}

	
	public String toString() {
		return PersonatoString() + ", Directivo [Salesiano=" + Salesiano + ", Turno=" + ", Salario= "+ Salario +"]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
