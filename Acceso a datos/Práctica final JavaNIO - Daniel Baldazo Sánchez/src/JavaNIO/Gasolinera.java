package JavaNIO;

public class Gasolinera {
	
	String nombre;
	String ubicacion;
	double precioLitro_G95;
	double precioLitro_Diesel;
	double cantidadG95;
	double cantidadDiesel;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public double getPrecioLitro_G95() {
		return precioLitro_G95;
	}
	public void setPrecioLitro_G95(double precioLitro_G95) {
		this.precioLitro_G95 = precioLitro_G95;
	}
	public double getPrecioLitro_Diesel() {
		return precioLitro_Diesel;
	}
	public void setPrecioLitro_Diesel(double precioLitro_Diesel) {
		this.precioLitro_Diesel = precioLitro_Diesel;
	}
	public double getCantidadG95() {
		return cantidadG95;
	}
	public void setCantidadG95(double cantidadG95) {
		this.cantidadG95 = cantidadG95;
	}
	public double getCantidadDiesel() {
		return cantidadDiesel;
	}
	public void setCantidadDiesel(double cantidadDiesel) {
		this.cantidadDiesel = cantidadDiesel;
	}
	@Override
	public String toString() {
		return "Gasolinera [nombre=" + nombre + ", ubicacion=" + ubicacion + ", precioLitro_G95=" + precioLitro_G95
				+ ", precioLitro_Diesel=" + precioLitro_Diesel + ", cantidadG95=" + cantidadG95 + ", cantidadDiesel="
				+ cantidadDiesel + "]";
	}
	public Gasolinera(String nombre, String ubicacion, double precioLitro_G95, double precioLitro_Diesel,
			double cantidadG95, double cantidadDiesel) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.precioLitro_G95 = precioLitro_G95;
		this.precioLitro_Diesel = precioLitro_Diesel;
		this.cantidadG95 = cantidadG95;
		this.cantidadDiesel = cantidadDiesel;
	}
	
	

}


