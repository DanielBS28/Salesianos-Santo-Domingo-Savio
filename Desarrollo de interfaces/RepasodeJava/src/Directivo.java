
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

	@Override
	public String toString() {
		return "Directivo [Salesiano=" + Salesiano + ", Turno=" + Turno + ", Salario=" + Salario + "]";
	}

	

	
	
	
	
	
	
	
	
	
	
	

}
