package EjerciciosDíaExcursión16Octubre;

import java.util.ArrayList;

public class Hotel {

	public ArrayList<Habitación> HABITACIONES = new ArrayList<>();
	private String nombre;

	public Hotel(String nombre) {

		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Hotel [HABITACIONES=" + HABITACIONES + ", nombre=" + nombre + "]";
	}

	public ArrayList<Habitación> getHABITACIONES() {
		return HABITACIONES;
	}

	public void setHABITACIONES(ArrayList<Habitación> Habitaciones) {
		HABITACIONES = Habitaciones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
