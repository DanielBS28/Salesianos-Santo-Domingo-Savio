
public class Administración extends Persona{
	

	private String Estudios;
	private int Antiguedad;
	private double Salario;
	
	public Administración(String dNI, String nombre, String apellidos, String estudios,
			int antiguedad, double Salario) {
		
		super(dNI, nombre, apellidos);
		Estudios = estudios;
		Antiguedad = antiguedad;
		this.Salario = Salario;
	}

	@Override
	public String toString() {
		return "Administración [Estudios=" + Estudios + ", Antiguedad=" + Antiguedad + ", Salario=" + Salario + "]";
	}




	
	
	
	
	
	

}
