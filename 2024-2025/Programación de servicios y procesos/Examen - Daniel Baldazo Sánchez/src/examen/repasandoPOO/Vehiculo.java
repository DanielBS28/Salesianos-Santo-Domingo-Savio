package examen.repasandoPOO;

public class Vehiculo {
	
	static int contador=0;
	
	private String Marca;
	private String modelo;
	private int anio;
	private Persona propietario;
	
	public Vehiculo(String Marca, String modelo, int anio) {
		
		this.Marca = Marca;
		this.modelo = modelo;
		this.anio = anio;
		contador++;
	}
	
	// Constructor 2 
	public Vehiculo(String Marca, String modelo, int anio, Persona propietario) {
		
		this.Marca = Marca;
		this.modelo = modelo;
		this.anio = anio;
		this.propietario = propietario;
		contador++;
	}

	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}
	
	public static int getContador() {
		return contador;
	}

	// Ternaria: si no tiene propietario devuelve no tiene propietario, en caso contrario muestro la información del propietario.
	public String obtenerInformacion() {
		return propietario == null ? " no tiene propietario" : " propietario: " + getPropietario().InfoPropietario();
	}


	
	
	
	
	
	
	
	
	
	

}
