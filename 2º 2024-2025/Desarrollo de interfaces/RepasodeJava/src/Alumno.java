import java.util.ArrayList;
import java.util.Date;

public class Alumno extends Persona {

	private String fechaNacimiento;
	private char sexo;
	private boolean repetidor;
	ArrayList<Modulo> modulos = new ArrayList<>();

	public Alumno(String dNI, String nombre, String apellidos, String fechaNacimiento, char sexo, boolean repetidor) {

		super(dNI, nombre, apellidos);
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.repetidor = repetidor;
	}

	public ArrayList<Modulo> modulosAlumno() {

		return modulos;
	}
	
	public String modulos(ArrayList<Modulo> modulosAlumnos) {
		
		return modulos.toString();
	
	}

	
	@Override
	public String toString() {
		return super.toString() + "Alumno [fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", repetidor=" + repetidor+
				" , Modulos ---------->" + modulos(modulos);
	}
	
	
	

	/*
	 * LocalDate localDate = LocalDate.of(2024, 9, 27); 
	 * Date fechaDesdeLocalDate = java.sql.Date.valueOf(localDate); // Conversión a Date
	 */

}
