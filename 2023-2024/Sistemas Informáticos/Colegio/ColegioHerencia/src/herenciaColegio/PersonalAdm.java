package herenciaColegio;

public class PersonalAdm extends  Persona {
	
	private String DNI, telf, cargo;
	
	

	public PersonalAdm(String nombre, String direccion, String dNI, String telf, String cargo) {
		super(nombre, direccion);
		DNI = dNI;
		this.telf = telf;
		this.cargo = cargo;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getTelf() {
		return telf;
	}

	public void setTelf(String telf) {
		this.telf = telf;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "PersonalAdm [DNI=" + DNI + ", telf=" + telf + ", cargo=" + cargo + "]";
	}
	
}
