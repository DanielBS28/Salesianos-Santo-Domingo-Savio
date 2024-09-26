
public class Persona {

	private String DNI; 
	private String Nombre; 
	private String Apellidos; 

	
	public Persona(String dNI, String nombre, String apellidos) {
		
		DNI = dNI;
		Nombre = nombre;
		Apellidos = apellidos;

	}
	

	public String PersonatoString() {
		return "Datos [DNI=" + DNI + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos;
	}
	
	
	
	

}
