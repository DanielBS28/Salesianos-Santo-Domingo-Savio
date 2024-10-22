package EjerciciosDíaExcursión16Octubre;

import java.util.ArrayList;

public class Hotel {
	
	public ArrayList <Habitación> HABITACIONES = new ArrayList<>();
	private String nombre;

	public Hotel(String nombre) {
		
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Hotel [HABITACIONES=" + HABITACIONES + ", nombre=" + nombre + "]";
	}
	
	
	

}
