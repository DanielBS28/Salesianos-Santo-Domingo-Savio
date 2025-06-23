package herenciaColegio;

public class Profesor extends Persona {
	
	private String DNI, tlf, asignatura, cargo;

	public Profesor(String nombre, String direccion, String dNI, String tlf, String asignatura, String cargo) {
		super(nombre, direccion);
		DNI = dNI;
		this.tlf = tlf;
		this.asignatura = asignatura;
		this.cargo = cargo;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Profesor [DNI=" + DNI + ", tlf=" + tlf + ", asignatura=" + asignatura + ", cargo=" + cargo + "]";
	}
	
}
