import javax.swing.plaf.synth.SynthOptionPaneUI;

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

	public void ProfesortoString() {
		PersonatoString();
		System.out.println(", Asignaturas=" + Asignaturas + ", Tutor=" + Tutor + ", Salario= "+ Salario +"]");

	}
	
	
	
	
	
	
	
	
	
	
	
	




}
