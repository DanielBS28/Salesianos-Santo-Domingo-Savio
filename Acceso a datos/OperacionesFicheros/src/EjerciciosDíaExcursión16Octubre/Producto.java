package EjerciciosDíaExcursión16Octubre;

public class Producto {
	
	private String nombre;
	private int cantidad;
	@Override
	public String toString() {
		return nombre + " con una cantidad de " + cantidad + (cantidad == 1 ? " producto." : " productos.");
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Producto(String nombre, int cantidad) {

		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	
	

}
