package EjerciciosDíaExcursión16Octubre;

public class Empleado {
	
	private String nombre;
	private double sueldo;
	private int horasTrabajadas;
	
	public Empleado(String nombre, double sueldo, int horasTrabajadas) {
		
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.horasTrabajadas = horasTrabajadas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	@Override
	public String toString() {
		return nombre + " con sueldo: " + sueldo + "€ y con horas trabajadas: " + horasTrabajadas +",";
	}

	
	
	
	

}
